package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dto.FlightInstanceDTO;
import springboot.mapper.FlightInstanceMapper;
import springboot.repository.FlightInstanceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlightInstanceServiceImpl implements FlightInstanceService {
    @Autowired
    private FlightInstanceRepository flightInstanceRepository;

    @Autowired
    private FlightInstanceMapper flightInstanceMapper;

    public FlightInstanceDTO findByInstanceID(String Id) {
        return flightInstanceMapper.fromEntity(flightInstanceRepository.findByInstanceID(Id));
    }

    public List<FlightInstanceDTO> findByRouteID(String routeID) {
        return flightInstanceRepository.findByRouteID(routeID)
                .stream()
                .map(flightInstanceMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<FlightInstanceDTO> findByPlaneID(String planeID) {
        return flightInstanceRepository.findByPlaneID(planeID)
                .stream()
                .map(flightInstanceMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<FlightInstanceDTO> findByDeparture(String departure) {
        return flightInstanceRepository.findByDeparture(departure)
                .stream()
                .map(flightInstanceMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<FlightInstanceDTO> findByArrival(String arrival) {
        return flightInstanceRepository.findByArrival(arrival)
                .stream()
                .map(flightInstanceMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
