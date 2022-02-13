package com.example.hibernate.entity.ManyToMany;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name="student")
public class StudentEntity implements Serializable {
    @Id
    @Column(name="id")
    private long id;

    @ManyToMany
    @JoinTable(
            name = "course_like",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<CourseEntity> likedCourses;
}
