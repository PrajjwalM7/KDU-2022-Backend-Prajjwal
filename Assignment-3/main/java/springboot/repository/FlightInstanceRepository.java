package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.FlightInstance;

import java.util.List;

@Repository
public interface FlightInstanceRepository extends JpaRepository<FlightInstance, String> {
    FlightInstance findByInstanceID(String Id);
    List<FlightInstance> findByRouteID(String routeID);
    List<FlightInstance> findByPlaneID(String planeID);
    List<FlightInstance> findByDeparture(String departure);
    List<FlightInstance> findByArrival(String arrival);
}
