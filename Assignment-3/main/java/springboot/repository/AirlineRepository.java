package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.Airline;

import java.util.List;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, String> {
    Airline findByAirlineId(String id);
    List<Airline> findByAirlineName(String name);
}
