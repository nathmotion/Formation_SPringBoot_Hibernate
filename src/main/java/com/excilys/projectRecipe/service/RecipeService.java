package com.excilys.projectRecipe.service;

import com.excilys.projectRecipe.DAO.RecipeDAO;
import com.excilys.projectRecipe.DTO.RecipeDTO;
import com.excilys.projectRecipe.DTO.mapper.RecipeMapper;
import com.excilys.projectRecipe.model.Recipe;
import com.excilys.projectRecipe.model.RecipeIngredient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    RecipeDAO recipeDAO;


    public RecipeService(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    public RecipeDTO getRecipeById(long id) {

        Optional<Recipe> optionalRecipe = recipeDAO.getRecipeById(id);
        if(optionalRecipe.isPresent()){
            RecipeMapper mapper= new RecipeMapper();
            return mapper.RecipetoDTO(optionalRecipe.get());
        }
        return null;
    }

    public List<Recipe> getAll() {
        return recipeDAO.getAll();
    }

    public long createRecipe(RecipeDTO recipeDTO) throws Exception {
        RecipeMapper mapper= new RecipeMapper();
        return recipeDAO.createRecipe(mapper.DtoToRecipe(recipeDTO));
    }

    public  void updateRecipe(RecipeDTO recipeDTO) {
        RecipeMapper mapper= new RecipeMapper();
        recipeDAO.updateRecipe(mapper.DtoToRecipe(recipeDTO));
    }

    public void addIngredients(List<RecipeIngredient> listRI, long id) {
         recipeDAO.addIngredients(listRI, id);
    }

    public void delete(RecipeDTO recipeDTO) {
        RecipeMapper mapper= new RecipeMapper();
        recipeDAO.delete(mapper.DtoToRecipe(recipeDTO));
    }

    public void deleteById(long id) {
         recipeDAO.deleteById(id);
    }
}
