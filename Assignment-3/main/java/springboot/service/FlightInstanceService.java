package springboot.service;

import springboot.dto.FlightInstanceDTO;
import springboot.entity.FlightInstance;

import java.util.List;

public interface FlightInstanceService {
    FlightInstanceDTO findByInstanceID(String Id);
    List<FlightInstanceDTO> findByRouteID(String routeID);
    List<FlightInstanceDTO> findByPlaneID(String planeID);
    List<FlightInstanceDTO> findByDeparture(String departure);
    List<FlightInstanceDTO> findByArrival(String arrival);
}
