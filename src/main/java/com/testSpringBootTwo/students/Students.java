package com.testSpringBootTwo.students;

import com.testSpringBootTwo.courses.Courses;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "students")
@Table(name = "students")
public class Students {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="fName")
    private String fName;
    @Column(name="lName")
    private String lName;
    @Column(name="town")
    private String town;
    @Column(name="hobby")
    private String hobby;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="students_courses",
            joinColumns = @JoinColumn(name = "students_id"), inverseJoinColumns = @JoinColumn(name = "courses_id"))
    private Set<Courses> courses = new HashSet<>();

}
