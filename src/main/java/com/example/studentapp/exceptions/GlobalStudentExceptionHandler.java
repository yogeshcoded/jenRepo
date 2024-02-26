package com.example.studentapp.exceptions;

import com.example.studentapp.dtos.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalStudentExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleStudentNotFound(StudentNotFoundException studentNotFoundException) {
        return new ResponseEntity<>(
                ErrorDetails.builder()
                        .message(studentNotFoundException.getLocalizedMessage())
                        .statusCodeDescription(HttpStatus.NOT_FOUND.name())
                        .code(HttpStatus.NOT_FOUND.value())
                        .timestamp(Timestamp.valueOf(LocalDateTime.now()))
                        .build(), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ErrorDetails handleAllException(Exception e) {
        return ErrorDetails.builder()
                .message(e.getMessage())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

    }
}
