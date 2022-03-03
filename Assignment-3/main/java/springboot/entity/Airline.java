package springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="airlines")
public class Airline {
    @Id
    @Column(name = "Code")
    private String airlineId;

    @Column(name = "Name")
    private String airlineName;
}
