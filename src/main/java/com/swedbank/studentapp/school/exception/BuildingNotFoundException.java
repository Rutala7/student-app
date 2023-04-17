package com.swedbank.studentapp.school.exception;

public class BuildingNotFoundException extends RuntimeException {
    public BuildingNotFoundException(int id) {
        super("Could not find building id: " + id);
    }
}
