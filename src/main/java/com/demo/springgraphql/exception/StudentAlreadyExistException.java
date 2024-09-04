package com.demo.springgraphql.exception;

public class StudentAlreadyExistException extends Exception {
    public StudentAlreadyExistException(String s) {
        super(s);
    }
}
