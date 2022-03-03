package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dto.AirportDTO;
import springboot.mapper.AirportMapper;
import springboot.repository.AirportRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {
    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AirportMapper airportMapper;

    public AirportDTO findByAirportCode(String code) {
        return airportMapper.fromEntity(airportRepository.findByAirportCode(code));
    }

    public List<AirportDTO> findByCityCode(String cityCode) {
        return airportRepository.findByCityCode(cityCode)
                .stream()
                .map(airportMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<AirportDTO> findByCountryCode(String countryCode) {
        return airportRepository.findByCountryCode(countryCode)
                .stream()
                .map(airportMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<AirportDTO> findByAirportName(String name) {
        return airportRepository.findByAirportName(name)
                .stream()
                .map(airportMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public AirportDTO findByAirportCodeAndAirportName(String code, String name) {
        return airportMapper.fromEntity(airportRepository.findByAirportCodeAndAirportName(code, name));
    }
}
