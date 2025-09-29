package kr.co.sboard.dto;

import kr.co.sboard.entity.User;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String usid;
    private String pass;
    private String us_name;
    private String nick;
    private String email;
    private String hp;
    private String us_role;
    private String zip;
    private String addr1;
    private String addr2;
    private String reg_ip;
    private String reg_date;
    private String leave_date;
}
