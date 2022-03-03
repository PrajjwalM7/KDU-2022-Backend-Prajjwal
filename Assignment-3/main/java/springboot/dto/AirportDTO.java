package springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AirportDTO implements Serializable {
    private String airportCode;
    private String cityCode;
    private String countryCode;
    private String airportName;
}
