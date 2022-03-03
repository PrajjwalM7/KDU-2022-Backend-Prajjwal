package springboot.mapper;

import org.springframework.stereotype.Component;
import springboot.dto.AirportDTO;
import springboot.entity.Airport;

@Component
public class AirportMapper {

    public AirportDTO fromEntity(Airport airport) {
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setAirportCode(airport.getAirportCode());
        airportDTO.setAirportName(airport.getAirportName());
        airport.setCityCode(airport.getCityCode());
        airport.setCountryCode(airport.getCountryCode());
        return airportDTO;
    }

    public Airport toEntity(AirportDTO airportDTO) {
        Airport airport = new Airport();
        airport.setAirportCode(airportDTO.getAirportCode());
        airport.setAirportName(airportDTO.getAirportName());
        return airport;
    }
}
