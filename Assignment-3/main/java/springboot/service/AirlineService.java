package springboot.service;

import springboot.dto.AirlineDTO;
import springboot.entity.Airline;

import java.util.List;

public interface AirlineService {
    AirlineDTO findByAirlineId(String id);
    List<AirlineDTO> findByAirlineName(String name);
}
