package springboot.service;

import springboot.dto.CountryDTO;
import springboot.entity.Country;

public interface CountryService {
    CountryDTO findByCountryCode(String code);
    CountryDTO findByCountryName(String name);
}
