package com.mebaysan.rest_intro.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mebaysan.rest_intro.entity.Student;
import com.mebaysan.rest_intro.error.StudentNotFoundError;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentController {
    public static final String API_PATH = "/students";
    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = List.of(
                new Student("John", "Doe"),
                new Student("Jane", "Doe"),
                new Student("Alice", "Doe"),
                new Student("Bob", "Doe"));
    }

    @GetMapping(API_PATH)
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping(API_PATH + "/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundError("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }

}
