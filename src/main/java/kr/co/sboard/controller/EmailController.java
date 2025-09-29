package kr.co.sboard.controller;

import kr.co.sboard.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/email/code")
    public ResponseEntity<Map<String, Boolean>> verify(@RequestBody Map<String, String> jsonData) {
        String code = jsonData.get("code");
        log.info("code = {}",  code);

        boolean result = emailService.verifyCode(code);
        Map<String,Boolean> reusltMap = Map.of("result",result);

        return ResponseEntity.ok(reusltMap);
    }
}
