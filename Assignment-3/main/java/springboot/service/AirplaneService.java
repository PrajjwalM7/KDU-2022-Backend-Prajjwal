package springboot.service;

import springboot.dto.AirplaneDTO;

import java.util.List;

public interface AirplaneService {
    AirplaneDTO findByAirplaneID(String id);
    List<AirplaneDTO> findByAirplaneName(String name);
    AirplaneDTO findByAirplaneIDAndAirplaneName(String id, String name);
}
