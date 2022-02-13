package springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StaffListDTO implements Serializable {
    private int id;
    private String name;
    private String address;
    private int zipCode;
    private String city;
    private String country;
    private int sid;
}
