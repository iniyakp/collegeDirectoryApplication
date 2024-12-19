package org.jsp.cda.usrdaoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.CourseDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl implements CourseDao {
	
	@Autowired
	private CourseRepository repo;

	@Override
	public Course saveCourse(Course course) {
		return repo.save(course);
	}

	@Override
	public Optional<Course> findCourseById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		return repo.findAll();
	}

	@Override
	public void deleteCourseById(int id) {
       repo.deleteById(id);		
	}

}
