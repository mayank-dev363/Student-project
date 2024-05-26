package com.springboot2.controller;

import com.springboot2.Model.Student;
import com.springboot2.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class springBootController {
    public springBootController(StudentService studentService) {
        this.studentService = studentService;
    }

    private StudentService studentService;

    @GetMapping("/")
    public String welcome(){
          return "index";
    }
    @GetMapping("/students")
    public String getStudents(Model model){
        model.addAttribute("students",studentService.getAllStudent());
        return "index";
    }
    @GetMapping("/students/new")
    public String addStudent(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "student_form";
    }
    @PostMapping("/students")
    public String addNewStudent(@ModelAttribute("students") Student student){
        studentService.AddNewStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students/update/{id}")
    public String updateStudent(@PathVariable Integer id,Model model){
        model.addAttribute("student",studentService.getStudentDetail(id));
        return "edit";
    }
    @PostMapping("/student/{id}")
    public String storeUpdatedStudent(@PathVariable Integer id,@ModelAttribute Student student ,Model model){
        Student st=studentService.getStudentDetail(id);
        st.setName(student.getName());
        st.setEmail(student.getEmail());
        st.setCity(student.getCity());

        model.addAttribute("student",studentService.AddUpdatedStudent(st));
        return "redirect:/students";
    }
    @GetMapping("/students/{id}")
    public String DeleteStudent(@PathVariable Integer id,Model model){
        studentService.DeleteStudentDetail(id);
        return "redirect:/students";
    }
}
