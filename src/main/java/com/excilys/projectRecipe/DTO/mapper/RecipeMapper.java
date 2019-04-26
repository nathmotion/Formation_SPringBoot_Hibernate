package com.excilys.projectRecipe.DTO.mapper;

import com.excilys.projectRecipe.DTO.RecipeDTO;
import com.excilys.projectRecipe.model.Recipe;

public class RecipeMapper {
    public Recipe DtoToRecipe(RecipeDTO recipeDTO){
        Recipe recipe = new Recipe();
        recipe.setId(recipeDTO.getId());
        recipe.setDescription(recipeDTO.getDescription());
        recipe.setInstructions(recipeDTO.getInstructions());
        recipe.setName(recipeDTO.getName());
        recipe.setRecipeIngredients(recipeDTO.getRecipeIngredients());
        return recipe;
    }

    public RecipeDTO RecipetoDTO(Recipe recipe){
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(recipe.getId());
        recipeDTO.setDescription(recipe.getDescription());
        recipeDTO.setInstructions(recipe.getInstructions());
        recipeDTO.setName(recipe.getName());
        recipeDTO.setRecipeIngredients(recipe.getRecipeIngredients());
        return recipeDTO;
    }
}
