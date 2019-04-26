package com.excilys.projectRecipe.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Recipe")
public class Recipe {
    private Long id;
    private String name;
    private String description;
    private Set<RecipeIngredient> recipeIngredients;
    private Set<String> instructions;


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

    @ManyToMany
    public Set<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(Set<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    @ElementCollection(targetClass = String.class)
    public Set<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(Set<String> instructions) {
        this.instructions = instructions;
    }
}
