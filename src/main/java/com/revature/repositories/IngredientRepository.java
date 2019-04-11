package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{

	Ingredient findByIngredientNameIgnoreCase(String ingredientName);
	
	Ingredient findById(int id);
	
	Ingredient findByNdbno(String ndbno);
}
