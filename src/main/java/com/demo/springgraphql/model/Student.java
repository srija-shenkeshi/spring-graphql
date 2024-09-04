package com.demo.springgraphql.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Builder
@Data
public class Student{

        @Id
        private String id;
        private String name;
        private String rollNo;
        private String grade;
        private String section;
        private Integer percentage;

}
