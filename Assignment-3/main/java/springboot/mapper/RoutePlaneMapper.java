package springboot.mapper;

import org.springframework.stereotype.Component;
import springboot.dto.RoutePlaneDTO;
import springboot.entity.RoutePlane;

@Component
public class RoutePlaneMapper {

    public RoutePlaneDTO fromEntity(RoutePlane routePlane) {
        RoutePlaneDTO routePlaneDTO = new RoutePlaneDTO();
        routePlaneDTO.setRouteID(routePlane.getRouteID());
        routePlaneDTO.setAirplaneID(routePlane.getAirplaneID());
        return routePlaneDTO;
    }

    public RoutePlane toEntity(RoutePlaneDTO routePlaneDTO) {
        RoutePlane routePlane = new RoutePlane();
        routePlane.setRouteID(routePlaneDTO.getRouteID());
        routePlane.setAirplaneID(routePlaneDTO.getAirplaneID());
        return routePlane;
    }
}
