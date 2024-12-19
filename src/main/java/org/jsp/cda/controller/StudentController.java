package org.jsp.cda.controller;

import org.jsp.cda.entity.Student;
import org.jsp.cda.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/{id}")
	public ResponseEntity<?> saveStudent(@RequestBody Student student,@PathVariable int id){
		return service.saveStudent(student,id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findStudentById(@PathVariable int id)
	{
		return service.findStudentById(id);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllStudent(){
		return service.findAllStudent();
	}

}
