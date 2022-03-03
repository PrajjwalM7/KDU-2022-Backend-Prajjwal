package springboot.mapper;


import org.springframework.stereotype.Component;
import springboot.dto.AirplaneDTO;
import springboot.entity.Airplane;

@Component
public class AirplaneMapper {

    public AirplaneDTO fromEntity(Airplane airplane) {
        AirplaneDTO airplaneDTO = new AirplaneDTO();
        airplaneDTO.setAirplaneID(airplane.getAirplaneID());
        airplaneDTO.setAirplaneName(airplane.getAirplaneName());
        airplaneDTO.setBSeats(airplane.getBSeats());
        airplaneDTO.setFSeats(airplane.getFSeats());
        airplaneDTO.setESeats(airplane.getESeats());
        return airplaneDTO;
    }

    public Airplane toEntity(AirplaneDTO airplaneDTO) {
        Airplane airplane = new Airplane();
        airplane.setAirplaneID(airplaneDTO.getAirplaneID());
        airplane.setAirplaneName(airplaneDTO.getAirplaneName());
        airplane.setBSeats(airplaneDTO.getBSeats());
        airplane.setFSeats(airplaneDTO.getFSeats());
        airplane.setESeats(airplaneDTO.getESeats());
        return airplane;
    }
}
