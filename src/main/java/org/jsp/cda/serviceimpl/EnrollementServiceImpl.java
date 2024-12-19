package org.jsp.cda.serviceimpl;

import java.util.Optional;

import org.jsp.cda.dao.CourseDao;
import org.jsp.cda.dao.EnrollmentDao;
import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Enrollment;
import org.jsp.cda.entity.User;
import org.jsp.cda.exceptionclasses.InvalidIdException;
import org.jsp.cda.service.EnrollementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnrollementServiceImpl implements EnrollementService {
	@Autowired
	private EnrollmentDao enrollmentdao;
//	@Autowired
//	private UserDao userdao;
//	@Autowired
//	private CourseDao coursedao;

	@Override
	public ResponseEntity<?> saveEnrollment(int sid, int cid) {
//	Optional<User> optional1= .findUserById(sid);
//	 Optional<Course> optional2= coursedao.findCourseById(cid);
//	 if(optional1.isEmpty()) 
//		 throw InvalidIdException.builder().message("Invalid UserId Exception..").build();
//	 if(optional2.isEmpty())
//		 throw InvalidIdException.builder().message("Invalid course Id Exception...").build();
//	User user= optional1.get();
//	Course course=optional2.get();
//	Enrollment enrollments=Enrollment.builder().course(course).
		return null;
	}

	
	

}
