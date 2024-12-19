package org.jsp.cda.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.exceptionclasses.InvalidIdException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDao dao;

	@Override
	public ResponseEntity<?> saveDepartment(Department department) {
	  department=dao.saveDepartment(department);
	  return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Department Saved Sucessfully...").body(department).build());
	}

	@Override
	public ResponseEntity<?> findDepartmentById(int id) {
	Optional<Department> optional=	dao.findDepartmentById(id);
	if(optional.isEmpty()) 
		throw InvalidIdException.builder().message("Invalid Department Id. Unable to find..").build();
	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Department found successfully...").body(optional.get()).build());
	
	}

	@Override
	public ResponseEntity<?> findAllDepartments() {
	List<Department> departments=dao.findAllDepartments();
	if(departments.isEmpty()) {
		return null;
	}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("All Departments found successfully....").body(departments).build());
	}

	@Override
	public ResponseEntity<?> deleteDepartmentById(int id) {
		Optional<Department> optional=	dao.findDepartmentById(id);
		if(optional.isEmpty()) {
			throw InvalidIdException.builder().message("Invalid Department Id Unable to find..").build();
		}
		dao.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Department Deleted successfully...").body(null).build());
	}

	

	

}
