package com.testSpringBootTwo.students_course;

import com.testSpringBootTwo.courses.Courses;
import com.testSpringBootTwo.courses.CoursesDTO;
import com.testSpringBootTwo.students.Students;
import com.testSpringBootTwo.students.StudentsDTO;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class StudentsCoursesDTO {

    private Integer id;
//    private Integer studentsId;
//    private Integer coursesId;
    private StudentsDTO studentsId;
    private CoursesDTO coursesId;

}
