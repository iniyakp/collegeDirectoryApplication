package org.jsp.cda.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.FacultyDao;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.exceptionclasses.InvalidIdException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService{
	
	@Autowired
	private FacultyDao dao;

	@Override
	public ResponseEntity<?> saveFaculty(Faculty faculty) {
		faculty=dao.saveFaculty(faculty);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Faculty Saved Successfully...").body(faculty).build());
		
	}

	@Override
	public ResponseEntity<?> findFacultyById(int id) {
	Optional<Faculty> optional=	dao.findFacultyById(id);
	if(optional.isEmpty()) 
		throw InvalidIdException.builder().message("Invlaid Id unbale to find...").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Faculty found successfully...").body(optional.get()).build());
	
	}

	@Override
	public ResponseEntity<?> findAllFaculty() {
	List<Faculty> faculties=dao.findAllFaculty();
	if(faculties.isEmpty()) {
		return null;
	}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Faculties found successfully...").body(faculties).build());
	}
	
	
	

}
