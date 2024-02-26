package com.example.studentapp.exceptions;

public class StudentNotFoundException extends Exception {
   public StudentNotFoundException() {
    }

   public StudentNotFoundException(String message) {
        super(message);
    }

}
