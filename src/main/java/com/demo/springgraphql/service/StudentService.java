package com.demo.springgraphql.service;

import com.demo.springgraphql.exception.StudentAlreadyExistException;
import com.demo.springgraphql.exception.StudentDoesNotExistException;
import com.demo.springgraphql.model.Student;
import com.demo.springgraphql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student) throws StudentAlreadyExistException {
        Optional<Student> student1 = studentRepository.findByRollNo(student.getRollNo());
        if (student1.isPresent()) {
            throw new StudentAlreadyExistException("Student already exists with rollNo: " + student.getRollNo());
        } else {
            studentRepository.insert(student);
            return student;
        }

    }

    public Student getStudent(String rollNo){
        return studentRepository.findByRollNo(rollNo)
                .orElse(null);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public boolean deleteStudent(String rollNo) throws StudentDoesNotExistException {
        Optional<Student> student = studentRepository.findByRollNo(rollNo);
        if (student.isPresent()) {
            studentRepository.deleteByRollNo(rollNo);
            return true;
        } else {
            throw new StudentDoesNotExistException("No student found with rollNo: " + rollNo);
        }
    }

    public Student updateStudent(Student student) throws StudentDoesNotExistException {

        return studentRepository.findById(student.getId())
                .map(existingStudent -> {
                    Optional.ofNullable(student.getName()).ifPresent(existingStudent::setName);
                    Optional.ofNullable(student.getRollNo()).ifPresent(existingStudent::setRollNo);
                    Optional.ofNullable(student.getGrade()).ifPresent(existingStudent::setGrade);
                    Optional.ofNullable(student.getSection()).ifPresent(existingStudent::setSection);
                    Optional.ofNullable(student.getPercentage()).ifPresent(existingStudent::setPercentage);
                    return studentRepository.save(existingStudent);
                })
                .orElseThrow(() -> new StudentDoesNotExistException("Student with ID " + student.getId() + " not found."));
    }


}
