package io.matoshri.learn.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("FROM Student s WHERE s.studentName = :studentName")
    Optional<Student> findByStudentName(@Param("studentName") String studentName);

    @Query("FROM Student s WHERE s.studentEmail = :studentEmail")
    Optional<Student> findByStudentEmail(@Param("studentEmail") String studentEmail);
}
