package com.example.hibernate.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "film")
@Data
public class FilmEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "film_id")
    private Long id;

    @NotEmpty(message = "Title can not be empty")
    private String title;
    private String description;
    @Column(name = "release_year")
    private Long year;
    private String rating;
}
