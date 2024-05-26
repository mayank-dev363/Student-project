package com.springboot2.Service;

import com.springboot2.Model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
    public Student AddNewStudent(Student student);
    Student getStudentDetail(Integer id);
    Student AddUpdatedStudent(Student student);
    void DeleteStudentDetail(Integer id);
}
