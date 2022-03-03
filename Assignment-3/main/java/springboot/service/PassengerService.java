package springboot.service;

import springboot.dto.PassengerDTO;
import springboot.entity.Passenger;

import java.util.List;

public interface PassengerService {
    PassengerDTO findByPassengerID(String id);
    List<PassengerDTO> findByPassengerName(String name);
    List<PassengerDTO> findByType(String type);
    List<PassengerDTO> findByFlightInstanceID(String flightInstanceID);
    List<PassengerDTO> findByPhone(Long phone);
    List<PassengerDTO> findByEmailID(String email);
}
