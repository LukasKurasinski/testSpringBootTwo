package com.testSpringBootTwo.courses;

import com.testSpringBootTwo.students.Students;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "courses")
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="YHP")
    private String YHP;
    @Column(name="description")
    private String description;
    //points to the property name in Students Entity
    @ManyToMany(mappedBy = "courses")
    Set<Students> students = new HashSet<>();

}
