package springboot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="passenger")
public class Passenger {
    @Id
    @Column(name = "passenger_id")
    private String passengerID;

    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name = "type")
    private String type;

    @Column(name = "seat_no")
    private String seatNo;

    @Column(name = "user_id")
    private String userID;

    @Column(name = "Flight_inst_ID")
    private String flightInstanceID;

    @Column(name = "email")
    private String emailID;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "confirmed")
    private Boolean confirmed;

    @Column(name = "cancelled")
    private Boolean cancelled;
}
