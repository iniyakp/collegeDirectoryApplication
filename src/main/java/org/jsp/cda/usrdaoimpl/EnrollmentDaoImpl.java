package org.jsp.cda.usrdaoimpl;

import org.jsp.cda.dao.EnrollmentDao;
import org.jsp.cda.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EnrollmentDaoImpl  implements EnrollmentDao{
	@Autowired
	private EnrollmentRepository repo;

}
