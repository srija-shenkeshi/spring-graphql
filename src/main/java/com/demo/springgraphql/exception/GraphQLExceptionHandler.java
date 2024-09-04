package com.demo.springgraphql.exception;

import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.execution.ErrorType;
import graphql.GraphQLError;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GraphQLExceptionHandler {

    @GraphQlExceptionHandler(StudentDoesNotExistException.class)
    public GraphQLError handleStudentDoesNotExistException(StudentDoesNotExistException e) {
        return GraphQLError.newError()
                .message(e.getMessage())
                .errorType(ErrorType.NOT_FOUND)
                .build();
    }

    @GraphQlExceptionHandler(StudentAlreadyExistException.class)
    public GraphQLError handleStudentAlreadyExistException(StudentAlreadyExistException e) {
        return GraphQLError.newError()
                .message(e.getMessage())
                .errorType(ErrorType.BAD_REQUEST)
                .build();
    }

}
