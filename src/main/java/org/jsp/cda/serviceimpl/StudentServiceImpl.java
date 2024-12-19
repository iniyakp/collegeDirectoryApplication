package org.jsp.cda.serviceimpl;

import java.util.Optional;

import org.jsp.cda.dao.StudentDao;
import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.Student;
import org.jsp.cda.entity.User;
import org.jsp.cda.exceptionclasses.InvalidIdException;
import org.jsp.cda.exceptionclasses.InvalidStudentException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentdao;

	@Autowired
	private UserDao userDao;
	

	@Override
	public ResponseEntity<?> saveStudent(Student student, int id) {
		Optional<User> optional = userDao.findUserById(id);
		if(optional.isEmpty())
				throw InvalidIdException.builder().message("Invalid Student Id Unable to Save Student").build();
		student.setUser(optional.get());
		student=studentdao.saveStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Student Saved Successfully...").body(student).build());
	}


	@Override
	public ResponseEntity<?> findStudentById(int id) {
	Optional<Student> optional=	studentdao.findStudentById(id);
	if(optional.isEmpty()) 
		throw InvalidIdException.builder().message("Invlaid Student Id unable to find the Student Id").build();
	
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Stuent found successfully...").body(optional.get()).build());
	}


	@Override
	public ResponseEntity<?> findAllStudent() {
	List<Student> students=	studentdao.findAllStudent();
	if(students.isEmpty())
		throw InvalidStudentException.builder().message("No Students Are found in the database..").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("All the Students are found successfully...").body(students).build());
	}

}
