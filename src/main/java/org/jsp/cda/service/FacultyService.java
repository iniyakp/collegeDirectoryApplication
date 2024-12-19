package org.jsp.cda.service;

import org.jsp.cda.entity.Faculty;
import org.springframework.http.ResponseEntity;

public interface FacultyService {

	ResponseEntity<?> saveFaculty(Faculty faculty);

	ResponseEntity<?> findFacultyById(int id);

	ResponseEntity<?> findAllFaculty();

}
