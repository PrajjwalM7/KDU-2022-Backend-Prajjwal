package springboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="airports")
public class Airport {
    @Id
    @Column(name = "Code")
    private String airportCode;

    @Column(name="City_code")
    private String cityCode;

    @Column(name="Country_code")
    private String countryCode;

    @Column(name = "Name")
    private String airportName;
}
