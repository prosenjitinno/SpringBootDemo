package com.example.SpringDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringDemo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
