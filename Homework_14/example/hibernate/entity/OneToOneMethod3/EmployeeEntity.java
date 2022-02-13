package com.example.hibernate.entity.OneToOneMethod3;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="employee")
public class EmployeeEntity implements Serializable {
    @Id
    @Column(name="id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
        name = "emp_office",
        joinColumns = {
            @JoinColumn(name = "emp_id", referencedColumnName = "id") },
        inverseJoinColumns = {
            @JoinColumn(name = "office_id", referencedColumnName = "id") }
    )
    private OfficeEntity office;

}
