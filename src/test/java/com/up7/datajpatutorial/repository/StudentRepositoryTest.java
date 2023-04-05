package com.up7.datajpatutorial.repository;

import com.up7.datajpatutorial.entity.Guardian;
import com.up7.datajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Guardian guardian = Guardian.builder()
                .guardianEmail("ghi@gmail.com")
                .guardianMobileNumber("9090808070")
                .guardianName("ghi")
                .build();
        Student student = Student.builder()
                .studentEmail("jkl@gmail.com")
                .studentFirstName("jk")
                .studentLastName("kl")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("students list = "+studentList);
    }
}