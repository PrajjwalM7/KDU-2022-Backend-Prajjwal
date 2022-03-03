package springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dto.AirportDTO;
import springboot.dto.CityDTO;
import springboot.entity.City;
import springboot.repository.CityRepository;
import springboot.service.CityService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityService cityService;

    @Autowired
    CityRepository cityRepository;

    @PostMapping("/add")
    public City addCity(@RequestBody City city){
        return cityRepository.save(city);
    }

    @GetMapping("/{id}")
    public CityDTO getCityByCode(@PathVariable String id) {
        return cityService.findByCityCode(id);
    }

    private ResponseEntity<List<CityDTO>> notFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CityDTO>> getAirportByCity(@PathVariable String name){
        return Optional.ofNullable(cityService.findByCityName(name))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(notFound());
    }

}
