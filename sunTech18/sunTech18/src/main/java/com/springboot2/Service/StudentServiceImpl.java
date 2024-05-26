package com.springboot2.Service;

import com.springboot2.Model.Student;
import com.springboot2.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student AddNewStudent(Student student) {
        return studentRepository.save(student);

    }

    @Override
    public Student getStudentDetail(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student AddUpdatedStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void DeleteStudentDetail(Integer id) {
         studentRepository.deleteById(id);
    }
}
