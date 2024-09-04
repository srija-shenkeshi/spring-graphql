package com.demo.springgraphql.controller;

import com.demo.springgraphql.exception.StudentAlreadyExistException;
import com.demo.springgraphql.exception.StudentDoesNotExistException;
import com.demo.springgraphql.model.Student;
import com.demo.springgraphql.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

    @MutationMapping("addStudentToDB")
    public Student addStudent(@Argument Student student) throws StudentAlreadyExistException {
        //log.info("entered addStudent method");
        return studentService.addStudent(student);
    }

    @QueryMapping
    public List<Student> getAllStudents(){
       // log.info("entered getAllStudent method");
        return studentService.getAllStudents();
    }

    @QueryMapping
    public Student getStudent(@Argument String rollNo) throws StudentDoesNotExistException {
        //log.info("entered getStudent method");
        Student student = studentService.getStudent(rollNo);
        if (student == null) {
            throw new StudentDoesNotExistException("Student Not Found with rollNo: " + rollNo);
        }
        return student;
    }

    @MutationMapping("updateStudent")
    public Student updateStudent(@Argument Student student) throws StudentDoesNotExistException {
        //log.info("entered updateStudent method");
        return studentService.updateStudent(student);

    }

    @MutationMapping("deleteStudent")
    public Boolean deleteStudent(@Argument String rollNo) throws StudentDoesNotExistException {
        //log.info("entered deleteStudent method");
        return studentService.deleteStudent(rollNo);
    }
}
