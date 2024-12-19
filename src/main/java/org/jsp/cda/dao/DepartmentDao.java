package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Department;

public interface DepartmentDao {

	Department saveDepartment(Department department);

	Optional<Department> findDepartmentById(int id);

	List<Department> findAllDepartments();

	void deleteById(int id);




}
