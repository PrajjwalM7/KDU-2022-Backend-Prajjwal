package springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="route_planes")
public class RoutePlane {
    @Id
    @Column(name = "route_id")
    private String routeID;

    @Column(name = "plane_id")
    private String airplaneID;

}
