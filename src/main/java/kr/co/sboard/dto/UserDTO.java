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

    public User toEntity() {
        return User.builder()
                .usid(usid)
                .pass(pass)
                .us_name(us_name)
                .nick(nick)
                .email(email)
                .hp(hp)
                .us_role(us_role)
                .zip(zip)
                .addr1(addr1)
                .addr2(addr2)
                .reg_ip(reg_ip)
                .reg_date(reg_date)
                .leave_date(leave_date)
                .build();
    }
}
