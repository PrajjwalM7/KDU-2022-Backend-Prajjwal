package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.RoutePlane;

import java.util.List;

@Repository
public interface RoutePlaneRepository extends JpaRepository<RoutePlane, String> {
    RoutePlane findByRouteID(String routeID);
    List<RoutePlane> findByAirplaneID(String airplaneID);
}
