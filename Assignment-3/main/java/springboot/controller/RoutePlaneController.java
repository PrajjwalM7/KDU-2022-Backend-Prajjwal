package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.dto.RoutePlaneDTO;
import springboot.entity.RoutePlane;
import springboot.repository.RoutePlaneRepository;
import springboot.service.RoutePlaneService;

@RestController
@RequestMapping("/routePlane")
public class RoutePlaneController {
    @Autowired
    RoutePlaneService routePlaneService;

    @Autowired
    RoutePlaneRepository routePlaneRepository;

    @PostMapping("/add")
    public RoutePlane addRoutePlane(@RequestBody RoutePlane routePlane){
        return routePlaneRepository.save(routePlane);
    }

    @GetMapping("/{id}")
    public RoutePlaneDTO getById(@PathVariable String id) {
        return routePlaneService.findByRouteID(id);
    }
}
