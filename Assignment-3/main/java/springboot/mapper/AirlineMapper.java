package springboot.mapper;

import org.springframework.stereotype.Component;
import springboot.dto.AirlineDTO;
import springboot.entity.Airline;

@Component
public class AirlineMapper {
    public AirlineDTO fromEntity(Airline airline) {
        AirlineDTO airlineDTO = new AirlineDTO();
        airlineDTO.setAirlineCode(airline.getAirlineId());
        airlineDTO.setAirlineName(airline.getAirlineName());
        return airlineDTO;
    }

    public Airline toEntity(AirlineDTO airlineDTO) {
        Airline airline = new Airline();
        airline.setAirlineId(airlineDTO.getAirlineCode());
        airline.setAirlineName(airlineDTO.getAirlineName());
        return airline;
    }
}
