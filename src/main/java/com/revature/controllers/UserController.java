package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
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
		return new ResponseEntity<User>(user, HttpStatus.OK);}
		else {return new ResponseEntity<User>(HttpStatus.NO_CONTENT);}
	}
}
