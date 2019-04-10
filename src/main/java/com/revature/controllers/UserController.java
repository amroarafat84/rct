package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
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

}
