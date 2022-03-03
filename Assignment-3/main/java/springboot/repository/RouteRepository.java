package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.Route;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, String> {
    Route findByRouteID(String routeID);
    List<Route> findByAirlineCode(String airlineCode);
    List<Route> findByDepartureAirportCode(String departureAirportCode);
    List<Route> findByArrivalAirportCode(String arrivalAirportCode);
}
