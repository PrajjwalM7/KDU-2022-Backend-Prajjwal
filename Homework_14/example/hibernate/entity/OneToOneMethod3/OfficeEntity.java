package com.example.hibernate.entity.OneToOneMethod3;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="office")
public class OfficeEntity implements Serializable {
    @Id
    @Column(name = "id")
    private int id;

    @OneToOne(mappedBy = "office")
    private EmployeeEntity emp;

    @Column(name = "location")
    private String location;
}
