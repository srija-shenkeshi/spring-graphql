package com.demo.springgraphql.exception;

public class StudentDoesNotExistException extends Exception {
    public StudentDoesNotExistException(String s) {
        super(s);
    }
}
