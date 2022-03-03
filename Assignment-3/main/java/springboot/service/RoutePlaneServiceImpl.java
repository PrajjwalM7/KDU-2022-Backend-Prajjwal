package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dto.RoutePlaneDTO;
import springboot.mapper.RoutePlaneMapper;
import springboot.repository.RoutePlaneRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoutePlaneServiceImpl implements RoutePlaneService {
    @Autowired
    private RoutePlaneRepository routePlaneRepository;

    @Autowired
    private RoutePlaneMapper routePlaneMapper;

    public RoutePlaneDTO findByRouteID(String routeID) {
        return routePlaneMapper.fromEntity(routePlaneRepository.findByRouteID(routeID));
    }

    public List<RoutePlaneDTO> findByAirplaneID(String airplaneID) {
        return routePlaneRepository.findByAirplaneID(airplaneID)
                .stream()
                .map(routePlaneMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
