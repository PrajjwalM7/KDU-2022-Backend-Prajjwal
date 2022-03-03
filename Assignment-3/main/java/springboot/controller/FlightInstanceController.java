package springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dto.AirportDTO;
import springboot.dto.FlightInstanceDTO;
import springboot.entity.FlightInstance;
import springboot.repository.FlightInstanceRepository;
import springboot.service.FlightInstanceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightInstanceController {

    @Autowired
    private FlightInstanceService flightService;

    @Autowired
    private FlightInstanceRepository flightInstanceRepository;

    @GetMapping("/{id}")
    private FlightInstanceDTO getById(@PathVariable String id) {
        return flightService.findByInstanceID(id);
    }

    private ResponseEntity<List<FlightInstanceDTO>> notFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/route/{routeID}")
    public ResponseEntity<List<FlightInstanceDTO>> getByRouteId(@PathVariable String routeID){
        return Optional.ofNullable(flightService.findByRouteID(routeID))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(notFound());
    }

    @PostMapping("/add")
    FlightInstance addFlightInstance(@RequestBody FlightInstance flightInstance){
        return flightInstanceRepository.save(flightInstance);
    }

    @GetMapping("/plane/{id}")
    public ResponseEntity<List<FlightInstanceDTO>> getByPlaneID(@PathVariable String id) {
        return Optional.ofNullable(flightService.findByPlaneID(id))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(notFound());
    }

}
