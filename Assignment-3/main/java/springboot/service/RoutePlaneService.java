package springboot.service;

import springboot.dto.RoutePlaneDTO;
import springboot.entity.RoutePlane;

import java.util.List;

public interface RoutePlaneService {
    RoutePlaneDTO findByRouteID(String routeID);
    List<RoutePlaneDTO> findByAirplaneID(String airplaneID);
}
