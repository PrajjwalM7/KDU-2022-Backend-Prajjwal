package springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="city")
public class City {
    @Id
    @Column(name = "Code")
    private String cityCode;

    @Column(name = "Name")
    private String cityName;

    @Column(name = "country_code")
    private String countryCode;
}
