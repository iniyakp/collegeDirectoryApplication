package org.jsp.cda.usrdaoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl  implements DepartmentDao{
	@Autowired
	private DepartmentRepository repo;

	@Override
	public Department saveDepartment(Department department) {
		return repo.save(department);
	}

	@Override
	public Optional<Department> findDepartmentById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Department> findAllDepartments() {
		return repo.findAll();
	}

	@Override
	public void deleteById(int id) {
        repo.deleteById(id);		
	}





	

}
