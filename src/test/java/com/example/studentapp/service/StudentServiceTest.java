/*
package com.example.studentapp.service;

import com.example.studentapp.dtos.StudentDto;
import com.example.studentapp.entitiy.Student;
import com.example.studentapp.exceptions.StudentNotFoundException;
import com.example.studentapp.repository.IStudentRepository;
import com.example.studentapp.services.impl.StudentServiceImpl;
import com.example.studentapp.utils.ConvertHelperUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @InjectMocks
    private StudentServiceImpl service;
    @Mock 
    private IStudentRepository repository;
    @Mock
    private  ConvertHelperUtil helperUtil;
    StudentDto studentDto = null;
    Student student = null;

    @BeforeEach
    public void beforeEach() {
        studentDto = new StudentDto(1L,"Raja", "Java", 2500L);
        student = new Student(1L,"Raja", "Java", 2500L);

    }



    @Test
    void testFindStudent_Success() throws StudentNotFoundException {
        Long studentId = 1L;
        StudentDto expectedStudentDto = new StudentDto();
        expectedStudentDto.setId(studentId);

        // Mock behavior of repository and helperUtil
        Student existingStudent = new Student(); // Assuming Student entity exists
        existingStudent.setId(studentId);
        when(repository.findById(studentId)).thenReturn(java.util.Optional.of(existingStudent));
        when(helperUtil.convertDTO(existingStudent)).thenReturn(expectedStudentDto);

        // Call the method
        StudentDto fetchedStudentDto = service.fetchOneStudent(studentId);

        // Assertions
        assertNotNull(fetchedStudentDto);
        assertEquals(expectedStudentDto.getId(), fetchedStudentDto.getId());

    }
}
*/
