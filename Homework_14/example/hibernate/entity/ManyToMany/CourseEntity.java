package com.example.hibernate.entity.ManyToMany;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "course")
public class CourseEntity implements Serializable {
    @Id
    @Column(name = "id")
    Long id;

    @ManyToMany(mappedBy = "likedCourses")
    Set<StudentEntity> likes;
}
