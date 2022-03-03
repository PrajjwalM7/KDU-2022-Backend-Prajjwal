package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.Airplane;

import java.util.List;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, String> {
    Airplane findByAirplaneID(String id);
    List<Airplane> findByAirplaneName(String name);
    Airplane findByAirplaneIDAndAirplaneName(String id, String name);
}
