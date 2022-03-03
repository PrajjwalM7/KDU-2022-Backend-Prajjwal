package springboot.mapper;


import org.springframework.stereotype.Component;
import springboot.dto.RouteDTO;
import springboot.entity.Route;

@Component
public class RouteMapper {

    public RouteDTO fromEntity(Route route) {
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setRouteID(route.getRouteID());
        routeDTO.setAirlineCode(route.getAirlineCode());
        routeDTO.setArrivalAirportCode(route.getArrivalAirportCode());
        routeDTO.setDepartureAirportCode(route.getDepartureAirportCode());
        return routeDTO;
    }

    public Route toEntity(RouteDTO routeDTO) {
        Route route = new Route();
        route.setRouteID(routeDTO.getRouteID());
        route.setAirlineCode(routeDTO.getAirlineCode());
        route.setArrivalAirportCode(routeDTO.getArrivalAirportCode());
        route.setDepartureAirportCode(routeDTO.getDepartureAirportCode());
        return route;
    }
}
