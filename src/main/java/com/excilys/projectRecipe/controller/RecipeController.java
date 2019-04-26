package com.excilys.projectRecipe.controller;

import com.excilys.projectRecipe.DTO.RecipeDTO;
import com.excilys.projectRecipe.model.Ingredient;
import com.excilys.projectRecipe.model.Recipe;
import com.excilys.projectRecipe.model.RecipeIngredient;
import com.excilys.projectRecipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/recipes")
public class RecipeController {


    RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = "/")
    public List<Recipe> getAll() {
        return recipeService.getAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    RecipeDTO getRecipeById(@PathVariable(name = "id") Long id) {
        return recipeService.getRecipeById(id);
    }

    @PostMapping(value = "/")
    long createRecipe(@RequestBody RecipeDTO recipe) throws Exception {
        return recipeService.createRecipe(recipe);
    }

    @PutMapping(value = "/")
    void updateRecipe(@RequestBody RecipeDTO recipe) {
         recipeService.updateRecipe(recipe);
    }

    @PatchMapping(value = "/{id}", produces = "application/json")
    void addIngredients(@RequestBody List<RecipeIngredient> ingredients, @PathVariable(name = "id") Long id) {
         recipeService.addIngredients(ingredients, id);
    }

    @DeleteMapping(value = "/")
    void delete(@RequestBody RecipeDTO recipe) {
         recipeService.delete(recipe);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    void deleteById(@PathVariable(name = "id") Long id) {
         recipeService.deleteById(id);
    }


}
