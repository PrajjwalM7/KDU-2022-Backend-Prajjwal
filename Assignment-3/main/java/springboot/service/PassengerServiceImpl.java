package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dto.PassengerDTO;
import springboot.mapper.PassengerMapper;
import springboot.repository.PassengerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PassengerMapper passengerMapper;

    public PassengerDTO findByPassengerID(String id) {
        return passengerMapper.fromEntity(passengerRepository.findByPassengerID(id));
    }

    public List<PassengerDTO> findByPassengerName(String name) {
        return passengerRepository.findByPassengerName(name)
                .stream()
                .map(passengerMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<PassengerDTO> findByType(String type) {
        return passengerRepository.findByType(type)
                .stream()
                .map(passengerMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<PassengerDTO> findByFlightInstanceID(String flightInstanceID) {
        return passengerRepository.findByFlightInstanceID(flightInstanceID)
                .stream()
                .map(passengerMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<PassengerDTO> findByPhone(Long phone) {
        return passengerRepository.findByPhone(phone)
                .stream()
                .map(passengerMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<PassengerDTO> findByEmailID(String email) {
        return passengerRepository.findByEmailID(email)
                .stream()
                .map(passengerMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
