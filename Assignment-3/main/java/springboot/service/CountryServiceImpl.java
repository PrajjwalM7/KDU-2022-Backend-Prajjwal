package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dto.CountryDTO;
import springboot.mapper.CountryMapper;
import springboot.repository.CountryRepository;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryMapper countryMapper;

    public CountryDTO findByCountryCode(String code) {
        return countryMapper.fromEntity(countryRepository.findByCountryCode(code));
    }

    public CountryDTO findByCountryName(String name) {
        return countryMapper.fromEntity(countryRepository.findByCountryName(name));
    }

}
