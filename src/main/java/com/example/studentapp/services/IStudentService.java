package com.example.studentapp.services;



import com.example.studentapp.dtos.StudentDto;
import com.example.studentapp.exceptions.StudentNotFoundException;

import java.util.List;

public interface IStudentService {

     Long createStudent(StudentDto student);
     List<StudentDto> fetchAllStudent();
     StudentDto fetchOneStudent(Long id) throws StudentNotFoundException;
     StudentDto updateStudent(StudentDto studentDto) throws StudentNotFoundException;
     void removeStudent(Long id) throws Exception;

}
