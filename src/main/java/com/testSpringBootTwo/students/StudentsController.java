package com.testSpringBootTwo.students;

import com.testSpringBootTwo.courses.CoursesDTO;
import com.testSpringBootTwo.courses.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;
    @Autowired
    private CoursesService coursesService;

    /**
     * Returns Json with all students
     * @return
     */
    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> students(){
        //return new ResponseEntity<>(studentsService.getAllStudents(), HttpStatus.OK);
        System.out.println("TEST");
        return new ResponseEntity<>("TEST", HttpStatus.OK);

    }

    /**
     * Returns Json with a student having an id
     * @param id
     * @return
     */
    @GetMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Students> students(
            @PathVariable(value = "id", required = true ) Integer id){
            Optional<Students> students = studentsService.getStudentById(id);
            if(students.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
        return new ResponseEntity<>(students.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/students/{id}/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getCoursesByStudentsId(
            @PathVariable(value = "id", required = true ) Integer id){
        List<CoursesDTO> courses = coursesService.getCoursesByStudentsId(id);
        if(courses.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        System.out.println(courses.toString());
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }


    @PostMapping(value = "/createStudentForm")
    public ResponseEntity<Students> createStudentFrom(Students student){
        System.out.println(student);
        student = studentsService.saveStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PostMapping(value = "/removeStudentForm", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> removeStudentFrom(
            @RequestParam(value = "id") int id
    ){
        System.out.println(id);
        studentsService.removeStudentById(id);
        return new ResponseEntity<>(studentsService.getAllStudents(), HttpStatus.OK);
    }
    @PostMapping(value = "/createStudent")
    public ResponseEntity<Students> createStudent(@RequestBody() Students student){
        System.out.println(student);
        student = studentsService.saveStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

}
