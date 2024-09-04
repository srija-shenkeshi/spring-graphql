package com.demo.springgraphql.repository;

import com.demo.springgraphql.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findByRollNo(String rollNo);
    void deleteByRollNo(String rollNo);

}
