package com.testSpringBootTwo.students_course;

import com.testSpringBootTwo.courses.Courses;
import com.testSpringBootTwo.students.Students;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "students_courses")
@Table(name = "students_courses")
public class StudentsCourses{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;

        @ManyToOne
        @JoinColumn(name = "students_id", referencedColumnName = "id" )
        private Students studentsId;

        @ManyToOne
        @JoinColumn(name = "courses_id", referencedColumnName = "id")
        private Courses coursesId;
}
