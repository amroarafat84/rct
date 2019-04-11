package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Ingredient;
import com.revature.service.IngredientService;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class IngredientController {
	
	@Autowired
	IngredientService iService;
	
	
	//return all ingredients
	@RequestMapping(value="/ingredients", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ingredient>> getAll(){
		return new ResponseEntity<List<Ingredient>>(iService.getAllIngredients(), HttpStatus.CREATED);
	}

}
