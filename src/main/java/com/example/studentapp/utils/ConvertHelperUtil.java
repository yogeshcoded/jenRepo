package com.example.studentapp.utils;


import com.example.studentapp.dtos.StudentDto;
import com.example.studentapp.entitiy.Student;
import org.springframework.stereotype.Component;

@Component
public class ConvertHelperUtil {
    public Student convertEntity(StudentDto studentDto) {
        return Student.builder()
                .name(studentDto.getName())
                .course(studentDto.getCourse())
                .fee(studentDto.getFee())
                .build();
    }

    public StudentDto convertDTO(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .course(student.getCourse())
                .fee(student.getFee())
                .build();
    }

}
