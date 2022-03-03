package springboot.service;

import springboot.dto.RouteDTO;
import springboot.entity.Route;

import java.util.List;

public interface RouteService {
    RouteDTO findByRouteID(String routeID);
    List<RouteDTO> findByAirlineCode(String airlineCode);
    List<RouteDTO> findByDepartureAirportCode(String departureAirportCode);
    List<RouteDTO> findByArrivalAirportCode(String arrivalAirportCode);
}
