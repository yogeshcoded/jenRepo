package com.example.studentapp.controller;

import com.example.studentapp.dtos.StudentDto;
import com.example.studentapp.exceptions.StudentNotFoundException;
import com.example.studentapp.services.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<String> registerStudent(@RequestBody StudentDto studentDto) {
        String student = "Student Register Id: " + studentService.createStudent(studentDto);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id) throws StudentNotFoundException {
        StudentDto studentDto = studentService.fetchOneStudent(id);
        return new ResponseEntity<>(studentDto, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto) throws StudentNotFoundException {
        StudentDto studentDto1 = studentService.updateStudent(studentDto);
        return new ResponseEntity<>(studentDto1, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudent()  {
        return new ResponseEntity<>(studentService.fetchAllStudent(), HttpStatus.OK);
    }

}
