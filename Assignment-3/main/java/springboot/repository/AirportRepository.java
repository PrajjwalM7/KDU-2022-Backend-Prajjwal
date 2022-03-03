package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.Airport;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {
    Airport findByAirportCode(String code);
    List<Airport> findByCityCode(String cityCode);
    List<Airport> findByCountryCode(String countryCode);
    List <Airport> findByAirportName(String name);
    Airport findByAirportCodeAndAirportName(String code, String name);
}
