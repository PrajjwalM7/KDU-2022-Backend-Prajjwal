package springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AirplaneDTO implements Serializable {
    private String airplaneID;
    private String airplaneName;
    private Integer bSeats;
    private Integer eSeats;
    private Integer fSeats;
}
