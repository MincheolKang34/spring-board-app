package kr.co.sboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SB_USER")
public class User {
    @Id
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

    @CreationTimestamp
    private String reg_date;
    @UpdateTimestamp
    private String leave_date;
}
