package org.jsp.cda.service;

import org.jsp.cda.entity.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {

	ResponseEntity<?> saveStudent(Student student, int id);

	ResponseEntity<?> findStudentById(int id);

	ResponseEntity<?> findAllStudent();

}
