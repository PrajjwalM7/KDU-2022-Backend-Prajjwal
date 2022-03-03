package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dto.CityDTO;
import springboot.mapper.CityMapper;
import springboot.repository.CityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Autowired
    CityMapper cityMapper;

    public CityDTO findByCityCode(String code) {
        return cityMapper.fromEntity(cityRepository.findByCityCode(code));
    }

    public List<CityDTO> findByCityName(String name) {
        return cityRepository.findByCityName(name)
                .stream()
                .map(cityMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public List<CityDTO> findByCountryCode(String countryCode){
        return cityRepository.findByCountryCode(countryCode)
                .stream()
                .map(cityMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
