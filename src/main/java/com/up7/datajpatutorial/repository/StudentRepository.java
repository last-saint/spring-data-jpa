package com.up7.datajpatutorial.repository;

import com.up7.datajpatutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByStudentFirstName(String studentFirstName);

    List<Student> findByStudentFirstNameContaining(String subString);

    List<Student> findByStudentLastNameNotNull();

    List<Student> findByGuardianGuardianName(String guardianName);
}
