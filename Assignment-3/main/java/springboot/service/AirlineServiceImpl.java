package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dto.AirlineDTO;
import springboot.mapper.AirlineMapper;
import springboot.repository.AirlineRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AirlineServiceImpl implements AirlineService {
    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private AirlineMapper airlineMapper;

    @Override
    public List<AirlineDTO> findByAirlineName(String name) {
        return airlineRepository.findByAirlineName(name)
                .stream()
                .map(airlineMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AirlineDTO findByAirlineId(String id) {
        return airlineMapper.fromEntity(airlineRepository.findByAirlineId(id));
    }
}
