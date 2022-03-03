package springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CityDTO implements Serializable {
    private String cityCode;
    private String cityName;
    private String countryCode;
}
