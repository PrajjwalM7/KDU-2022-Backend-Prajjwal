package springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CountryDTO implements Serializable {
    private String countryCode;
    private String countryName;
}
