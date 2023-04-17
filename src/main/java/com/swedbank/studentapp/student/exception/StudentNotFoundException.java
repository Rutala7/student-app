package com.swedbank.studentapp.student.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(long id) {
        super("Could not find student id: " + id);
    }
}
