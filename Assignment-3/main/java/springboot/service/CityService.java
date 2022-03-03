package springboot.service;

import springboot.dto.CityDTO;
import springboot.entity.City;

import java.util.List;

public interface CityService {
    CityDTO findByCityCode(String code);
    List<CityDTO> findByCityName(String name);
    List<CityDTO> findByCountryCode(String countryCode);
}
