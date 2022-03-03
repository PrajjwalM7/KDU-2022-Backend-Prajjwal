package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
    Country findByCountryCode(String code);
    Country findByCountryName(String name);
}
