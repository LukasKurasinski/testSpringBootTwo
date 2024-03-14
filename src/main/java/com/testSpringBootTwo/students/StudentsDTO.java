package com.testSpringBootTwo.students;

import com.testSpringBootTwo.courses.Courses;
import com.testSpringBootTwo.courses.CoursesDTO;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Data Transfer Object. Used for problems with infinite recursion when fetching
 * ManyToMany relationship
 */
@Data
public class StudentsDTO{
    private Integer id;
    private String fName;
    private String lName;
    private String town;
    private String hobby;
    private String email;
    private String phone;
    private String username;
    private String password;
    private List<CoursesDTO> courses;
}
