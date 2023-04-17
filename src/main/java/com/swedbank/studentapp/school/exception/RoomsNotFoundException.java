package com.swedbank.studentapp.school.exception;

public class RoomsNotFoundException extends RuntimeException {
    public RoomsNotFoundException(int id) {
        super("Could not find room id: " + id);
    }
}
