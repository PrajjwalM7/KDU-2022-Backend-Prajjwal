package springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="airplane")
public class Airplane {
    @Id
    @Column(name = "Code")
    private String airplaneID;

    @Column(name = "Name")
    private String airplaneName;

    @Column(name = "Bseats")
    private Integer bSeats;

    @Column(name = "Eseats")
    private Integer eSeats;

    @Column(name = "Fseats")
    private Integer fSeats;
}
