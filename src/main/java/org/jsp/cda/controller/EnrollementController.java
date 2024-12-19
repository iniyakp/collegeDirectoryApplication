package org.jsp.cda.controller;

import org.jsp.cda.service.EnrollementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollments")
public class EnrollementController 
{
	@Autowired
	private EnrollementService service;
	
	@PostMapping("/{sid}/{cid}")
	public ResponseEntity<?> saveEnrollment(@PathVariable int sid,@PathVariable int cid)
	{
		return service.saveEnrollment(sid,cid);
     }
}
