package springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dto.AirplaneDTO;
import springboot.dto.PassengerDTO;
import springboot.service.PassengerService;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @GetMapping("{id}")
    public PassengerDTO getPassengerByID(@PathVariable String id) {
        return passengerService.findByPassengerID(id);
    }

    private ResponseEntity<List<PassengerDTO>> notFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PassengerDTO>> findPassengerByName(@PathVariable String name){
        return Optional.ofNullable(new ResponseEntity(
                passengerService.findByPassengerName(name), HttpStatus.OK))
                .orElse(notFound());
    }

    @GetMapping("/instance/{id}")
    public ResponseEntity<List<PassengerDTO>> getPassengerByFlightInstance(@PathParam("flightID") String id){
        return Optional.ofNullable(new ResponseEntity(
                passengerService.findByFlightInstanceID(id),HttpStatus.OK
        )).orElse(notFound());
    }
}
