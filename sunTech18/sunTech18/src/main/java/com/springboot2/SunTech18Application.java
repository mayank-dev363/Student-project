package com.springboot2;

import com.springboot2.Model.Student;
import com.springboot2.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SunTech18Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SunTech18Application.class, args);
	}
   @Autowired
	StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		Student  student1=new Student("maynak","mayank@gmail.com","Kanpur");
		studentRepository.save(student1);
		Student  student2=new Student("mahima","mahima@gmail.com","gurgaon");
		studentRepository.save(student2);
		Student  student3=new Student("krishna","krishna@gmail.com","delhi");
		studentRepository.save(student3);

	}
}
