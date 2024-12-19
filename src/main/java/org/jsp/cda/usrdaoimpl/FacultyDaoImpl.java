package org.jsp.cda.usrdaoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.FacultyDao;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FacultyDaoImpl implements FacultyDao{
	
	@Autowired
	private FacultyRepository repo;

	@Override
	public Faculty saveFaculty(Faculty faculty) {
		return repo.save(faculty);
	}

	@Override
	public Optional<Faculty> findFacultyById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Faculty> findAllFaculty() {
		return repo.findAll();
	}

}
