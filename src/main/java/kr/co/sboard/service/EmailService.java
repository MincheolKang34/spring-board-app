package kr.co.sboard.service;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import kr.co.sboard.dto.SessionData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    private final SessionData sessionData;

    public void sendCode(String receiver){
        MimeMessage message = mailSender.createMimeMessage();

        int code = ThreadLocalRandom.current().nextInt(100000, 1000000);

        String title = "sboard 인증코드 입니다.";
        String Content = "<h1>인증코드는 " + code + "입니다.</h1>";
        try {
            message.setFrom(new InternetAddress(sender, "보내는 사람", "UTF-8"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
            message.setSubject(title);
            message.setContent(Content, "text/html;charset=UTF-8");

            // 메일 전송
            mailSender.send(message);

            // 현재 세션 저장
            sessionData.setCode(String.valueOf(code));

        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public boolean verifyCode(String code){
        // 현재 세션 코드 가져오기
        String sessCode = (String) sessionData.getCode();

        if(sessCode.equals(code)){
            return true;
        }
        return false;
    }
}
