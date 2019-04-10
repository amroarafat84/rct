package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
>>>>>>> 5e0bb82291f404d3038a70a126962ebc90149fe0
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
<<<<<<< HEAD
import com.revature.repositories.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value="/register", 
			method = RequestMethod.POST, 
			headers = {"content-type=application/json"})
	public User register(@RequestBody User user) {
		System.out.println(user);
		return userRepo.save(user); 
	}

=======
import com.revature.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService uService; //SHOULD BE SERVICE LAYER to follow best practices
	
	
	//ADD USER
	@RequestMapping(value="/register",
			method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> add(@RequestBody User user){
		user = uService.addUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> log(@RequestBody User user){
		user=uService.login(user);
		if(user!=null) {
		return new ResponseEntity<User>(user, HttpStatus.I_AM_A_TEAPOT);}
		else {return new ResponseEntity<User>(HttpStatus.NO_CONTENT);}
	}
>>>>>>> 5e0bb82291f404d3038a70a126962ebc90149fe0
}
