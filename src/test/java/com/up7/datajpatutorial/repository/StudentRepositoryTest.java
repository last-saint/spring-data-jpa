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
    @Test
    public void printAllStudents_based_on_first_name(){
        String firstName = "jk";
        List<Student> studentList = studentRepository.findByStudentFirstName(firstName);
        System.out.println("students list with first name "+firstName+" = "+studentList);
    }

    @Test
    public void printAllStudents_based_on_a_substring_which_is_part_of_student_first_name(){
        String subString = "a";
        List<Student> studentList = studentRepository.findByStudentFirstNameContaining(subString);
        System.out.println("students list with given substring : "+subString+" , containing in a studentFirstName = "+studentList);
    }

    @Test
    public void printAllStudents_with_last_name_not_null(){
        List<Student> studentList = studentRepository.findByStudentLastNameNotNull();
        System.out.println("Students with last name not null = "+studentList);
    }

    @Test
    public void printAllStudents_based_on_guardian_name(){
        String guardianName = "def";
        List<Student> studentList = studentRepository.findByGuardianGuardianName(guardianName);
        System.out.println("students with guardian name = "+guardianName+" are = "+studentList);
    }
}