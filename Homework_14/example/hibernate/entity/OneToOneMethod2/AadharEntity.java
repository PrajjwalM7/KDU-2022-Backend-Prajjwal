package com.example.hibernate.entity.OneToOneMethod2;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="aadhar_details")
public class AadharEntity implements Serializable {
    @Id
    @Column(name = "aadhar_id")
    private long aadharId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "aadhar_id")
    private CitizenEntity citizen;

    @Column(name = "phone_no")
    private long phoneNo;
}
