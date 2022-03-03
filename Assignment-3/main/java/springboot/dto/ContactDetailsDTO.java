package springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactDetailsDTO implements Serializable {
    private String contactID;
    private Integer phone;
    private String email;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
}
