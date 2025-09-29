package kr.co.sboard.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FileDTO {
    private int fno;
    private int ano;
    private String oname;
    private String sname;
    private String download;
    private String rdate;
}
