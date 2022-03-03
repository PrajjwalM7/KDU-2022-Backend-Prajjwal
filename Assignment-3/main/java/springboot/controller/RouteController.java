package springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.dto.AirplaneDTO;
import springboot.dto.RouteDTO;
import springboot.service.RouteService;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/routes")
public class RouteController {
    @Autowired
    RouteService routeService;

    @GetMapping("/{id}")
    public RouteDTO getRouteByID(@PathVariable String id) {
        return routeService.findByRouteID(id);
    }

    private ResponseEntity<List<RouteDTO>> notFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/airline/{id}")
    public ResponseEntity<List<RouteDTO>> getAllRouteByAirplane(@PathVariable String id){
        return Optional.ofNullable(new ResponseEntity<>(
                routeService.findByAirlineCode(id), HttpStatus.OK
        )).orElse(notFound());
    }

    @GetMapping("/dep/{id}")
    public ResponseEntity<List<RouteDTO>> getRouteByDep(@PathVariable String id) {
        return Optional.ofNullable(new ResponseEntity<>(
                routeService.findByDepartureAirportCode(id),HttpStatus.OK
        )).orElse(notFound());
    }

    @GetMapping("/arrival/{id}")
    public ResponseEntity<List<RouteDTO>> getRouteByArrival(@PathVariable String id) {
        return Optional.ofNullable(new ResponseEntity<>(
                routeService.findByArrivalAirportCode(id),HttpStatus.OK
        )).orElse(notFound());
    }
}
