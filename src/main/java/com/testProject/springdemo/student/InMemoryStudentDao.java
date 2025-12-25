package com.testProject.springdemo.student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryStudentDao {

    private final List<Student> STUDENT=new ArrayList<>();
     
    public Student save(Student s){
        STUDENT.add(s);
        return s;  
    }

    
    public List<Student>findAllStudents(){
        return STUDENT;
    }

    public Student findByEmail(String email){
        return STUDENT.stream()
        .filter(s -> email.equals(s.getEmail()))
        .findFirst()
        .orElse(null);
        
    }   
    
    public Student update(Student s){
        var studentIndex =IntStream.range(0, STUDENT.size())
        .filter(index -> STUDENT.get(index).getEmail().equals(s.getEmail()))
        .findFirst()
        .orElse(-1);
        if ((studentIndex >- 1)) {
            STUDENT.set(studentIndex,s);
            return s;
        } else {
            return null;   
        }
    }   
    
    public void delete(String email){
        var student = findByEmail(email);
        if(student != null){
            STUDENT.remove(student);
        }
    
    }

}
