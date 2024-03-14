package com.testSpringBootTwo.courses;

import com.testSpringBootTwo.students.Students;
import com.testSpringBootTwo.students.StudentsDTO;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Data Transfer Object. Used for problems with infinite recursion when fetching
 * ManyToMany relationship
 */
@Data
public class CoursesDTO {

    private Integer id;
    private String name;
    private String YHP;
    private String description;
    private List<StudentsDTO> students;
}
