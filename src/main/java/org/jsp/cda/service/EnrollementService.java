package org.jsp.cda.service;

import org.springframework.http.ResponseEntity;

public interface EnrollementService {


	ResponseEntity<?> saveEnrollment(int uid, int cid);

}
