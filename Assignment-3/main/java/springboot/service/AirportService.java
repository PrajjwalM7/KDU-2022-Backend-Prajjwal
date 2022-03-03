package springboot.service;

import springboot.dto.AirportDTO;
import springboot.entity.Airport;

import java.util.List;

public interface AirportService {
    AirportDTO findByAirportCode(String code);
    List<AirportDTO> findByCityCode(String cityCode);
    List<AirportDTO> findByCountryCode(String countryCode);
    List <AirportDTO> findByAirportName(String name);
    AirportDTO findByAirportCodeAndAirportName(String code, String name);
}
