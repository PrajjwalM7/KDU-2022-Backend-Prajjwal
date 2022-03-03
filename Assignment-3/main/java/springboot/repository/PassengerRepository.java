package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.Passenger;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, String> {
    Passenger findByPassengerID(String id);
    List<Passenger> findByPassengerName(String name);
    List<Passenger> findByType(String type);
    List<Passenger> findByFlightInstanceID(String flightInstanceID);
    List<Passenger> findByPhone(Long phone);
    List<Passenger> findByEmailID(String email);
}
