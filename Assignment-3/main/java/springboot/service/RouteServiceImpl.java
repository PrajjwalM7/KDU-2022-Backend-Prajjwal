package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dto.RouteDTO;
import springboot.mapper.RouteMapper;
import springboot.repository.RouteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteMapper routeMapper;

    public RouteDTO findByRouteID(String routeID) {
        return routeMapper.fromEntity(routeRepository.findByRouteID(routeID));
    }

    public List<RouteDTO> findByAirlineCode(String airlineCode) {
        return routeRepository.findByAirlineCode(airlineCode)
                .stream()
                .map(routeMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<RouteDTO> findByDepartureAirportCode(String departureAirportCode) {
        return routeRepository.findByDepartureAirportCode(departureAirportCode)
                .stream()
                .map(routeMapper::fromEntity)
                .collect(Collectors.toList());
    }
    public List<RouteDTO> findByArrivalAirportCode(String arrivalAirportCode) {
        return routeRepository.findByArrivalAirportCode(arrivalAirportCode)
                .stream()
                .map(routeMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
