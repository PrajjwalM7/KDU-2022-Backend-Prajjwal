package springboot.mapper;

import org.springframework.stereotype.Component;
import springboot.dto.FlightInstanceDTO;
import springboot.entity.FlightInstance;

@Component
public class FlightInstanceMapper {

    public FlightInstanceDTO fromEntity(FlightInstance flightInstance) {
        FlightInstanceDTO flightInstanceDTO = new FlightInstanceDTO();
        flightInstanceDTO.setInstanceID(flightInstance.getInstanceID());
        flightInstanceDTO.setBSeats(flightInstance.getBSeats());
        flightInstanceDTO.setFSeats(flightInstance.getFSeats());
        flightInstanceDTO.setESeats(flightInstance.getESeats());
        flightInstanceDTO.setArrival(flightInstance.getArrival());
        flightInstanceDTO.setDeparture(flightInstance.getDeparture());
        flightInstanceDTO.setBCost(flightInstance.getBCost());
        flightInstanceDTO.setFCost(flightInstance.getFCost());
        flightInstanceDTO.setECost(flightInstance.getECost());
        flightInstanceDTO.setPlaneID(flightInstance.getPlaneID());
        return flightInstanceDTO;
    }

    public FlightInstance toEntity(FlightInstanceDTO flightInstanceDTO) {
        FlightInstance flightInstance = new FlightInstance();
        flightInstance.setInstanceID(flightInstanceDTO.getInstanceID());
        flightInstance.setBSeats(flightInstanceDTO.getBSeats());
        flightInstance.setFSeats(flightInstanceDTO.getFSeats());
        flightInstance.setESeats(flightInstanceDTO.getESeats());
        flightInstance.setArrival(flightInstanceDTO.getArrival());
        flightInstance.setDeparture(flightInstanceDTO.getDeparture());
        flightInstance.setBCost(flightInstanceDTO.getBCost());
        flightInstance.setFCost(flightInstanceDTO.getFCost());
        flightInstance.setECost(flightInstanceDTO.getECost());
        flightInstance.setPlaneID(flightInstanceDTO.getPlaneID());
        return flightInstance;
    }

}
