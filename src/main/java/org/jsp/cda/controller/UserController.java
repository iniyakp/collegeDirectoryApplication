package org.jsp.cda.controller;

import org.jsp.cda.dto.AuthUser;
import org.jsp.cda.entity.User;
import org.jsp.cda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	
	@Operation(summary = "This API will do login validation", description = "This API will do login validation by accepting a request body ie. AuthUser which has email and password as sates")
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> findUsernameAndPassword(@RequestBody AuthUser authUser ){
		return service.findUsernameAndPassword(authUser);
	}
	
	@Operation(summary = "This API will save the user entity",description = "This API will accept  a User JSON object ")
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return  service.saveUser(user);
	}
	
	@Operation(summary = "This API will find the user by id", description = "This API will accept a User JSON object and give the users based on ID")
	@ApiResponses(value = {@ApiResponse(responseCode ="200",description = "user found successfully"),@ApiResponse(responseCode = "404",description = "Invalid User Id unable to find")})
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findUserById(@PathVariable int id)
	{
		return service.findUserById(id);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllUser(){
		return service.findAllUser();
	}
	
	
	@PatchMapping("/{id}/otp/{otp}") //user id and otp we are getting
	public  ResponseEntity<?> verifyOTP(@PathVariable int id, @PathVariable int otp){
		return service.verifyOTP(id,otp);
	}
	
    @GetMapping("/email/{email}")
    public ResponseEntity<?> findUserByEmail(@PathVariable String email){
    	return service.findUserByEmail(email);
    }
}
