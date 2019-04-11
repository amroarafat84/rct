package com.revature.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Ingredient;
import com.revature.repositories.IngredientRepository;

@Service
@Transactional
public class IngredientService {

	@Autowired
	IngredientRepository iRepo;
	
	public List<Ingredient> getAllIngredients(){
		return iRepo.findAll();
	}
}
