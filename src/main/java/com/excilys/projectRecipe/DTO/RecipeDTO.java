package com.excilys.projectRecipe.DTO;

import com.excilys.projectRecipe.model.Ingredient;
import com.excilys.projectRecipe.model.RecipeIngredient;

import javax.persistence.*;
import java.util.Set;

public class RecipeDTO {
     Long id;
     String name;
     String description;
     Set<RecipeIngredient> recipeIngredients;
     Set<String> instructions;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany
    public Set<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(Set<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    @OneToMany
    public Set<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(Set<String> instructions) {
        this.instructions = instructions;
    }
}
