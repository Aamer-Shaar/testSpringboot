package com.testProject.springdemo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
     public List<Student> findAllStudents(){
        return List.of(
          new Student("Aamer","Shaar",LocalDate.now(),"aamer.shaar.2004@gmail.com",21),

          new Student("Student2","Shaar",LocalDate.now(),"yamen.shaar.2004@gmail.com",16)
        );
    }

}
