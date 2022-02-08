package com.example.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "actor")
@Data
public class ActorEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
