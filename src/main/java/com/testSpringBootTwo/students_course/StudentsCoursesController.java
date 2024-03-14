package com.testSpringBootTwo.students_course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsCoursesController {

    @Autowired
    StudentsCoursesService studentsCoursesService;

    @GetMapping(value = "/studentsCourses")
    public ResponseEntity<List<StudentsCoursesDTO>> getAllStudentsCourses(){
        return new ResponseEntity<>(studentsCoursesService.getAllStudentsCourses(), HttpStatus.OK);
    }
    @GetMapping(value = "/studentsCourses/students/{id}")
    public ResponseEntity<List<StudentsCoursesDTO>> getAllStudentsCoursesByStudentsId(
            @PathVariable(value = "id") int id
    ){
        return new ResponseEntity<>(studentsCoursesService.getAllStudentsCoursesByStudentsId(id), HttpStatus.OK);
    }
}
