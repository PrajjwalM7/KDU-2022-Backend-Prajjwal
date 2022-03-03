package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dto.AirplaneDTO;
import springboot.entity.Airplane;
import springboot.mapper.AirplaneMapper;
import springboot.repository.AirplaneRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AirplaneServiceImpl implements AirplaneService {
    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private AirplaneMapper airplaneMapper;

    public AirplaneDTO findByAirplaneID(String id) {
        return airplaneMapper.fromEntity(airplaneRepository.findByAirplaneID(id));
    }

    public List<AirplaneDTO> findByAirplaneName(String name) {
        return airplaneRepository.findAll().stream()
                .map(airplaneMapper::fromEntity)
                .collect(Collectors.toList());
    }
    public AirplaneDTO findByAirplaneIDAndAirplaneName(String id, String name) {
        return airplaneMapper.fromEntity(airplaneRepository.findByAirplaneIDAndAirplaneName(id, name));
    }
}
