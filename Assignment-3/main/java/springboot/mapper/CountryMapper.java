package springboot.mapper;

import org.springframework.stereotype.Component;
import springboot.dto.CountryDTO;
import springboot.entity.Country;

@Component
public class CountryMapper {

    public CountryDTO fromEntity(Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountryCode(country.getCountryCode());
        countryDTO.setCountryName(country.getCountryName());
        return countryDTO;
    }

    public Country toEntity(CountryDTO countryDTO) {
        Country country = new Country();
        country.setCountryCode(countryDTO.getCountryCode());
        country.setCountryName(countryDTO.getCountryName());
        return country;
    }
}
