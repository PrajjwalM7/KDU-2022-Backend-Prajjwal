package springboot.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="route")
public class Route {
    @Id
    @Column(name = "route_id")
    private String routeID;

    @Column(name = "airline_code")
    private String airlineCode;

    @Column(name = "departure_airport_code")
    private String departureAirportCode;

    @Column(name = "arrival_airport_code")
    private String arrivalAirportCode;
}
