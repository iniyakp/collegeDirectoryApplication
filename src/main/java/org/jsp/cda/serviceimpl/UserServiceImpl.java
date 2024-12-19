package org.jsp.cda.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.UserDao;
import org.jsp.cda.dto.AuthUser;
import org.jsp.cda.entity.User;
import org.jsp.cda.eum.UserStatus;
import org.jsp.cda.exceptionclasses.InvalidCredentialException;
import org.jsp.cda.exceptionclasses.InvalidIdException;
import org.jsp.cda.exceptionclasses.InvalidUserException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.UserService;
import org.jsp.cda.util.Myutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public ResponseEntity<?> findUsernameAndPassword(AuthUser authUser) {
	Optional<User> optional=dao.findUsernameAndPassword(authUser.getUsername(),authUser.getPassword());
	if(optional.isEmpty())
		throw InvalidCredentialException.builder().message("Invalid Username and Password..").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Login Successfull...").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> saveUser(User user) {
		user.setOtp(Myutil.getOtp());
		user=dao.saveUser(user);
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.addTo(user.getEmail());
			mimeMessageHelper.setSubject("Account Created");
			mimeMessageHelper.setText("<html><body style='backgroundcolor:cyan; color:crimson'><h1>"+user.getName()  +"Your CDA Account Has Been Created Successfully </h1><br><br><hr><br> Your OTP:  "+ user.getOtp()+"</body></html>",true);
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
        
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("User Saved Successfully...").body(user).build());
	}

	@Override
	public ResponseEntity<?> findUserById(int id) {
	 Optional<User> optional=dao.findUserById(id);
	 if(optional.isEmpty()) 
		 throw InvalidIdException.builder().message("Invalid User Id....").build();
	 return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("User found successfully...").body(optional.get()).build());
	}
	

	@Override
	public ResponseEntity<?> findAllUser() {
	List<User> users=dao.findAllUser();
	if(users.isEmpty()) 
		throw InvalidUserException.builder().message("No Users found in the Database..").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Users Find Successfully...").body(users).build());
	}
	

	@Override
	public ResponseEntity<?> verifyOTP(int id, int otp) {
		Optional<User>optional = dao.findUserById(id);
		if(optional.isEmpty()) 
			throw InvalidIdException.builder().message("Invalid User ID Unable To Verify the OTP").build();
		User user=optional.get();
		if(otp!=user.getOtp())
			throw new RuntimeException("Invalid OTP unable to verify the OTP");
		user.setStatus(UserStatus.ACTIVE);
		user  = dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("OTP verified successfully").body(user).build());
	}

	@Override
	public ResponseEntity<?> findUserByEmail(String email) {
	Optional<User> optional=dao.findUserByEmail(email);
	if(optional.isEmpty())
		throw  new RuntimeException(" Invalid email unable to find the email in database...");
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpstatus(HttpStatus.OK.value()).message("Email Found Successfully").body(optional.get()).build());
	}


}
