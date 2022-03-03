package springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoutePlaneDTO implements Serializable {
    private String routeID;
    private String airplaneID;
}