package springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RouteDTO implements Serializable {
    private String routeID;
    private String airlineCode;
    private String departureAirportCode;
    private String arrivalAirportCode;
}
