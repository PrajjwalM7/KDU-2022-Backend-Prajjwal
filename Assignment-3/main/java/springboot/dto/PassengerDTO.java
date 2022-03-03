package springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PassengerDTO implements Serializable {
    private String passengerID;
    private String passengerName;
    private String type;
    private String seatNo;
    private String userID;
    private String flightInstanceID;
    private String emailID;
    private Long phone;
    private Integer age;
    private String sex;
    private Boolean confirmed;
    private Boolean cancelled;
}
