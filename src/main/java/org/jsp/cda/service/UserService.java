package org.jsp.cda.service;

import org.jsp.cda.dto.AuthUser;
import org.jsp.cda.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService  {

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> findUserById(int id);

	ResponseEntity<?> findAllUser();

	ResponseEntity<?> findUsernameAndPassword(AuthUser authUser);

	ResponseEntity<?> verifyOTP(int id, int otp);


}