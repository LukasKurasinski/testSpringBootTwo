package com.testSpringBootTwo.students_course;

import com.testSpringBootTwo.courses.Courses;
import com.testSpringBootTwo.courses.CoursesDTO;
import com.testSpringBootTwo.students.Students;
import com.testSpringBootTwo.students.StudentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentsCoursesService {
    @Autowired
    StudentsCoursesRepository studentsCoursesRepository;
    public List<StudentsCoursesDTO> getAllStudentsCourses(){
        return studentsCoursesRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public List<StudentsCoursesDTO> getAllStudentsCoursesByStudentsId(int id) {
        return studentsCoursesRepository.findAllByStudentsIdId(id).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    private StudentsCoursesDTO mapToDTO(StudentsCourses studentsCourses) {
        StudentsCoursesDTO dto = new StudentsCoursesDTO();
        dto.setId(studentsCourses.getId());
//        dto.setStudentsId(mapToDTO(studentsCourses.getStudentsId()).getId());
//        dto.setCoursesId(mapToDTO(studentsCourses.getCoursesId()).getId());
          dto.setStudentsId(mapToDTO(studentsCourses.getStudentsId()));
          dto.setCoursesId(mapToDTO(studentsCourses.getCoursesId()));
        return dto;
    }
    private CoursesDTO mapToDTO(Courses courses){
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setYHP(courses.getYHP());
        dto.setDescription(courses.getDescription());
        return dto;
    }
    private StudentsDTO mapToDTO(Students students){
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setEmail(students.getEmail());
        dto.setHobby(students.getHobby());
        dto.setPhone(students.getPhone());
        dto.setTown(students.getTown());
        dto.setFName(students.getFName());
        dto.setLName(students.getLName());
        dto.setPassword(students.getPassword());
        dto.setUsername(students.getUsername());
        return dto;
    }


}

