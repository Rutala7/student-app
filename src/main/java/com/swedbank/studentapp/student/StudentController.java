package com.swedbank.studentapp.student;


import com.swedbank.studentapp.student.exception.StudentNotFoundException;
import com.swedbank.studentapp.student.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository repository;

    @GetMapping()
    public List<Student> all() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable final long id) {
        log.debug("Student: " + id);
        return new ResponseEntity<>(repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id)), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        repository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable final long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> replaceStudent(@RequestBody Student newStudent,
                                                  @PathVariable Long id) throws StudentNotFoundException {
        Student updatedStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        updatedStudent.setName(newStudent.getName());
        updatedStudent.setSurname(newStudent.getSurname());
        updatedStudent.setPersonalCode((newStudent.getPersonalCode()));
        repository.save(updatedStudent);
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping("/first")
    public Student getFirst() {
        return repository.getFirstStudent().get(0);
    }

    @GetMapping("/second")
    public Student getSecond() {
        return repository.getSecondStudent().get(0);
    }

    @GetMapping("/byname")
    public List<Student> getByName(@RequestParam() String name) {
        return repository.getByName(name);
    }
}
