package com.excilys.projectRecipe.DTO.mapper;

import com.excilys.projectRecipe.DTO.IngredientDTO;
import com.excilys.projectRecipe.model.Ingredient;

public class IngredientMapper {
   public  Ingredient DtoToIngredient(IngredientDTO ingredientDTO){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientDTO.getId());
        ingredient.setName(ingredientDTO.getName());
        return ingredient;
    }

    public IngredientDTO IngredientToDTO(Ingredient ingredient){
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setId(ingredient.getId());
        ingredientDTO.setName(ingredient.getName());
        return ingredientDTO;
    }

}
