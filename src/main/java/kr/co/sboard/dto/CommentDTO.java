package kr.co.sboard.dto;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
    private int cno;
    private int ano;
    private String content;
    private String writer;
    private String reg_ip;
    private String wdate;

    // 추가 필드
    private String nick;
}
