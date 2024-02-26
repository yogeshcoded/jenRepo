package com.example.studentapp.services.impl;

import com.example.studentapp.dtos.StudentDto;
import com.example.studentapp.entitiy.Student;
import com.example.studentapp.exceptions.StudentNotFoundException;
import com.example.studentapp.repository.IStudentRepository;
import com.example.studentapp.services.IStudentService;
import com.example.studentapp.utils.ConvertHelperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;
    private final ConvertHelperUtil helperUtil;

    @Override
    public Long createStudent(StudentDto studentDto) {
            Student student=helperUtil.convertEntity(studentDto);
        return studentRepository.save(student).getId();

    }

    @Override
    public List<StudentDto> fetchAllStudent() {
              return studentRepository.findAll()
                                .stream()
                                .map(helperUtil::convertDTO)
                                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public StudentDto fetchOneStudent(Long id) throws StudentNotFoundException {
          return studentRepository.findById(id)
                             .map(helperUtil::convertDTO)
                             .orElseThrow(() -> new StudentNotFoundException("Given Student id not match our data"));

    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) throws StudentNotFoundException {
       return studentRepository.findById(studentDto.getId())
                               .map(existingStudent->studentRepository.save(helperUtil.convertEntity(studentDto)))
                               .map(helperUtil::convertDTO)
                               .orElseThrow(() -> new StudentNotFoundException("Given Student id not match our data"));

    }

    @Override
    public void removeStudent(Long id) throws Exception {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }else{
            throw new StudentNotFoundException("Given Student id not match our data");
        }


    }
}
