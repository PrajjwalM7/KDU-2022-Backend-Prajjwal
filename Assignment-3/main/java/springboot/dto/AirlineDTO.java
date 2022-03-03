package springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AirlineDTO implements Serializable {
    private String airlineCode;
    private String airlineName;
}

