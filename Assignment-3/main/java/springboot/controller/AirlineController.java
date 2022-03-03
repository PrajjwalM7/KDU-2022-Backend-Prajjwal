package springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.dto.AirlineDTO;
import springboot.dto.AirportDTO;
import springboot.service.AirlineService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    private ResponseEntity<List<AirlineDTO>> notFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public AirlineDTO getAirlineById(@PathVariable String id){
        return airlineService.findByAirlineId(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<AirlineDTO>> getAirlineByName(@PathVariable String name){
        return Optional.ofNullable(airlineService.findByAirlineName(name))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(notFound());
    }

}
