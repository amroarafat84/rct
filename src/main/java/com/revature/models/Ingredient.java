package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="INGREDIENT")
public class Ingredient {
	
	@Id
	@Column(name="INGREDIENT_ID")
	@GeneratedValue(generator="INGREDIENT_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="INGREDIENT_SEQ_GEN", sequenceName="INGREDIENT_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="INGREDIENT_NAME", nullable=false)
	private String ingredientName;
	
	@Column(name="INGREDIENT_NDBNO", nullable=false)
	private int ndbno;
	
	public Ingredient() { }

	public Ingredient(String ingredientName, int ndbno) {
		super();
		this.ingredientName = ingredientName;
		this.ndbno = ndbno;
	}

	public Ingredient(int id, String ingredientName, int ndbno) {
		super();
		this.id = id;
		this.ingredientName = ingredientName;
		this.ndbno = ndbno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getNdbno() {
		return ndbno;
	}

	public void setNdbno(int ndbno) {
		this.ndbno = ndbno;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", ingredientName=" + ingredientName + ", ndbno=" + ndbno + "]";
	}
}
