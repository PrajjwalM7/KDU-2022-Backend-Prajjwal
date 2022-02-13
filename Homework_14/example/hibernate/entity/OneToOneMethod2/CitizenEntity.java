package com.example.hibernate.entity.OneToOneMethod2;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="citizen")
@Data
public class CitizenEntity implements Serializable {
    @Id
    @Column(name = "aadhar_id")
    private long aadharID;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "citizen", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AadharEntity aadhar;
}
