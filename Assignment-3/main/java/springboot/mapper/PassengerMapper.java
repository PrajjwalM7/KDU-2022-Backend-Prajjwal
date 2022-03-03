package springboot.mapper;

import org.springframework.stereotype.Component;
import springboot.dto.PassengerDTO;
import springboot.entity.Passenger;

@Component
public class PassengerMapper {

    public PassengerDTO fromEntity(Passenger passenger) {
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setPassengerID(passenger.getPassengerID());
        passengerDTO.setPassengerName(passenger.getPassengerName());
        passengerDTO.setAge(passenger.getAge());
        passengerDTO.setCancelled(passenger.getCancelled());
        passengerDTO.setConfirmed(passenger.getConfirmed());
        passengerDTO.setEmailID(passenger.getEmailID());
        passengerDTO.setFlightInstanceID(passenger.getFlightInstanceID());
        passengerDTO.setPhone(passenger.getPhone());
        passengerDTO.setAge(passenger.getAge());
        passengerDTO.setUserID(passenger.getUserID());
        passengerDTO.setSeatNo(passenger.getSeatNo());
        passengerDTO.setType(passenger.getType());
        return passengerDTO;
    }

    public Passenger toEntity(PassengerDTO passengerDTO) {
        Passenger passenger = new Passenger();
        passenger.setPassengerID(passengerDTO.getPassengerID());
        passenger.setPassengerName(passengerDTO.getPassengerName());
        passenger.setAge(passengerDTO.getAge());
        passenger.setCancelled(passengerDTO.getCancelled());
        passenger.setConfirmed(passengerDTO.getConfirmed());
        passenger.setEmailID(passengerDTO.getEmailID());
        passenger.setFlightInstanceID(passengerDTO.getFlightInstanceID());
        passenger.setPhone(passengerDTO.getPhone());
        passenger.setAge(passengerDTO.getAge());
        passenger.setUserID(passengerDTO.getUserID());
        passenger.setSeatNo(passengerDTO.getSeatNo());
        passenger.setType(passengerDTO.getType());
        return passenger;
    }
}
