package springboot.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class FlightInstanceDTO {
    private String instanceID;
    private String routeID;
    private String planeID;
    private Integer bSeats;
    private Integer eSeats;
    private Integer fSeats;
    private Integer eCost;
    private Integer bCost;
    private Integer fCost;
    private Date departure;
    private Date arrival;
}
