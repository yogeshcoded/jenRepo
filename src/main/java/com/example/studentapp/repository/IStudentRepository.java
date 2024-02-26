package com.example.studentapp.repository;


import com.example.studentapp.entitiy.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {
}
