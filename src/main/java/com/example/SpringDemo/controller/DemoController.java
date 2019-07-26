package com.example.SpringDemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringDemo.dao.StudentRepository;
import com.example.SpringDemo.entity.Student;
import com.example.SpringDemo.exception.ResourceNotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/students")
public class DemoController {

	@Autowired
	private StudentRepository studentRepo; 
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Spring Boot";
	}
	
	@RequestMapping("/getAll")
	public List<Student> getAllStudent(){
		return studentRepo.findAll();
	}
	
	@RequestMapping("/getById")
    public ResponseEntity<Student> getEmployeeById(@PathVariable(value = "id") Integer studentId)
            throws ResourceNotFoundException {
		
		Student std = studentRepo.findById(studentId)
		          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + studentId));
		        return ResponseEntity.ok().body(std);
	}
	
	@PostMapping("/createStudent")
    public Student createEmployee(@Valid @RequestBody Student student) {
        return studentRepo.save(student);
    }
	
	@DeleteMapping("/deleteStudent/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Integer studentId)
	         throws ResourceNotFoundException {
	        Student std = studentRepo.findById(studentId)
	       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + studentId));

	        studentRepo.delete(std);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	}
}
