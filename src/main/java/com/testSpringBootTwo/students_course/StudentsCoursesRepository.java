package com.testSpringBootTwo.students_course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsCoursesRepository extends JpaRepository<StudentsCourses, Integer> {
    List<StudentsCourses> findAllByStudentsIdId(Integer id);

}
