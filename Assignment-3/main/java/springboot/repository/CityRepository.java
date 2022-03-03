package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.City;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
    City findByCityCode(String code);
    List<City> findByCityName(String name);
    List<City> findByCountryCode(String countryCode);
}
