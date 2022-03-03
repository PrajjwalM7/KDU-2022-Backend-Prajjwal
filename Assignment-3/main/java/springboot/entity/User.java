package springboot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="user")
public class User {
    @Id
    @Column(name = "user_id")
    private String userID;

    @Column(name = "u_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "pass")
    private String password;

    @Column(name = "contact_id")
    private String contactID;
}
