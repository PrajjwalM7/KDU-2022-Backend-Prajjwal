package springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private String userID;
    private String userName;
    private String email;
    private String password;
    private String contactID;
}
