package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Course;

public interface CourseDao {

	Course saveCourse(Course course);

	Optional<Course> findCourseById(int id);

	List<Course> findAllCourses();

	void deleteCourseById(int id);

}
