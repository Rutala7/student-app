package com.swedbank.studentapp;

import com.swedbank.studentapp.errors.ErrorMessage;
import com.swedbank.studentapp.school.exception.BuildingNotFoundException;
import com.swedbank.studentapp.school.exception.RoomsNotFoundException;
import com.swedbank.studentapp.student.exception.StudentNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorMessage> studentNotFoundException(StudentNotFoundException ex, WebRequest request){
        ErrorMessage error = ErrorMessage.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build();

        log.warn(error.toString());
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BuildingNotFoundException.class)
    public ResponseEntity<ErrorMessage> buildingNotFoundException(BuildingNotFoundException ex, WebRequest request){
        ErrorMessage error = ErrorMessage.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build();

        log.warn(error.toString());
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoomsNotFoundException.class)
    public ResponseEntity<ErrorMessage> roomsNotFoundException(RoomsNotFoundException ex, WebRequest request){
        ErrorMessage error = ErrorMessage.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build();

        log.warn(error.toString());
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    }
}
