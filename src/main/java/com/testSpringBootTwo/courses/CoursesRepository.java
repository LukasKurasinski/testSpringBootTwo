package com.testSpringBootTwo.courses;

import com.testSpringBootTwo.students.Students;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoursesRepository  extends CrudRepository<Courses, Integer> {

    //we are in Courses its implied that we want to find courses by student id.
    List<Courses> findByStudentsId(int studentId);

    /*
    @Query("select c1_0.id,c1_0.YHP,c1_0.description,c1_0.name from courses c1_0 left join students_courses s1_0 on c1_0.id=s1_0.courses_id where s1_0.students_id=:studentId")
    List<Courses> findByStudentsId(@Param("studentId") int id);
 */
}
