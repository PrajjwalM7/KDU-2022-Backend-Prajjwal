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
import springboot.dto.AirportDTO;
import springboot.service.AirplaneService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {
    @Autowired
    private AirplaneService airplaneService;

    private ResponseEntity<List<AirplaneDTO>> notFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public AirplaneDTO getAirplaneById(@PathVariable String id){
        return  airplaneService.findByAirplaneID(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<AirplaneDTO>> getAirplaneByName(@PathVariable String name){
        return Optional.ofNullable(airplaneService.findByAirplaneName(name))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(notFound());
    }
}
