package springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name="instances")
public class FlightInstance {
    @Id
    @Column(name = "instance_id")
    private String instanceID;

    @Column(name = "route_id")
    private String routeID;

    @Column(name = "plane_id")
    private String planeID;

    @Column(name = "bseats")
    private Integer bSeats;

    @Column(name = "eseats")
    private Integer eSeats;

    @Column(name = "fseats")
    private Integer fSeats;

    @Column(name = "ecost")
    private Integer eCost;

    @Column(name = "bcost")
    private Integer bCost;

    @Column(name = "fcost")
    private Integer fCost;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Column(name = "departure")
    private Date departure;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Column(name = "arrival")
    private Date arrival;
}
