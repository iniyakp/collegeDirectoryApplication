package org.jsp.cda.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.CourseDao;
import org.jsp.cda.dao.FacultyDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.exceptionclasses.InvalidIdException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao coursedao;
	
	@Autowired
	private FacultyDao facultydao;

	@Override
	public ResponseEntity<?> saveCourse(Course course) {
	course=	coursedao.saveCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Course saved successfully...").body(course).build());
	}

	@Override
	public ResponseEntity<?> findCourseById(int id) {
	Optional<Course> optional=	coursedao.findCourseById(id);
	if(optional.isEmpty()) 
		throw InvalidIdException.builder().message("Invalid Id unable to finde the courses..").build();
	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Course found successfully..").body(optional.get()).build());
	
	}

	@Override
	public ResponseEntity<?> findAllCourses() {
	List<Course> courses=coursedao.findAllCourses();
	if(courses.isEmpty()) {
		return null;
	}
	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Courses found successfully...").body(courses).build());
	
}

	@Override
	public ResponseEntity<?> deleteCourseById(int id) {
		Optional<Course> optional=coursedao.findCourseById(id);
		if(optional.isEmpty()) {
			throw InvalidIdException.builder().message("Invalid Id Unable to find..").build();
		}
		coursedao.deleteCourseById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Courses deleted successfully....").body(null).build());
	}

	@Override
	public ResponseEntity<?> assignFacultyToCourse(int id, int fid) {
		Optional<Faculty> optional1=facultydao.findFacultyById(fid);
		if(optional1.isEmpty()) 
			throw new RuntimeException("Invlaid Faculty Id :"+fid);
		Optional<Course> optional2=coursedao.findCourseById(id);
		if(optional2.isEmpty())
			throw new RuntimeException("Invalid Course Id:"+id);
		Faculty faculty=optional1.get();
		Course course=optional2.get();
		course.setFaculty(faculty);
		course=coursedao.saveCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Faculty Assigned Successfully").body(course).build());
	}
	

}
