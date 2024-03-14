package com.testSpringBootTwo.students;

import com.testSpringBootTwo.courses.Courses;
import com.testSpringBootTwo.courses.CoursesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentsService {
    @Autowired
    StudentsRepository studentsRepository;

    public List<StudentsDTO> getAllStudents(){
        //List<StudentsDTO> dto = new ArrayList<StudentsDTO>();
        //List<Students> iterator = studentsRepository.findAll();
        //while (iterator.hasNext()){
            //dto.add(iterateToDTO(iterator.next()));
        //}

        return studentsRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public Optional<Students> getStudentById(int id){
        return studentsRepository.findById(id);
    }
    public Students saveStudent(Students students){
        return studentsRepository.save(students);
    }
    public void removeStudentById(int id){
        studentsRepository.deleteById(id);
    }
    public List<StudentsDTO> getStudentsByCoursesId(int coursesID){

        return studentsRepository.findByCoursesId(coursesID).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    /**
     * This method is needed to avoid circular querries
     * DTO map methods are used as a middle man between the querry result
     * and data return to client. This middle man makes t possible to have
     * a bigger control over what client sees and in what format
     * @param courses
     * @return
     */
    private CoursesDTO mapToDTO(Courses courses){
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setYHP(courses.getYHP());
        dto.setDescription(courses.getDescription());
        return dto;
    }
    /**
     * This method is needed to avoid circular querries
     * DTO map methods are used as a middle man between the querry result
     * and data return to client. This middle man makes t possible to have
     * a bigger control over what client sees and in what format
     * @param students
     * @return
     */
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
        dto.setCourses(students.getCourses().stream().map(this::mapToDTO).collect(Collectors.toList()));

        return dto;
    }

    private CoursesDTO iterateToDTO(Courses courses){
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setYHP(courses.getYHP());
        dto.setDescription(courses.getDescription());
        //List<StudentsDTO> studentsList = new ArrayList<StudentsDTO>();
        //Iterator<Students> iterator = courses.getStudents().iterator();
        //while (iterator.hasNext()){studentsList.add(iterateToDTO(iterator.next()));}
        //dto.setStudents(studentsList);
        return dto;
    }
    private StudentsDTO iterateToDTO(Students students){
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setFName(students.getFName());
        dto.setLName(students.getLName());
        dto.setEmail(students.getEmail());
        dto.setHobby(students.getHobby());
        dto.setPhone(students.getPhone());
        dto.setTown(students.getTown());
        dto.setPassword(students.getPassword());
        dto.setUsername(students.getUsername());

        List<CoursesDTO> courseList = new ArrayList<>();
        Iterator<Courses> iterator = students.getCourses().iterator();
        while (iterator.hasNext()){courseList.add(iterateToDTO(iterator.next()));}
        dto.setCourses(courseList);
        return dto;
    }

}
