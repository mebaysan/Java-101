package com.mebaysan.quick_start.dao;

import java.util.List;

import com.mebaysan.quick_start.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student fetchById(int id);

    int count();

    List<Student> filterLikeEmail(String email);

    void update(Student student);

    void deleteById(int id);
}