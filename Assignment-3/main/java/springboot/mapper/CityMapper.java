package springboot.mapper;

import org.springframework.stereotype.Component;
import springboot.dto.CityDTO;
import springboot.entity.City;

@Component
public class CityMapper {

    public CityDTO fromEntity(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setCityCode(city.getCityCode());
        cityDTO.setCityName(city.getCityName());
        cityDTO.setCountryCode(city.getCountryCode());
        return cityDTO;
    }

    public City fromEntity(CityDTO cityDTO) {
        City city = new City();
        city.setCityCode(cityDTO.getCityCode());
        city.setCityName(cityDTO.getCityName());
        city.setCountryCode(cityDTO.getCountryCode());
        return city;
    }
}
