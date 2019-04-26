package com.excilys.projectRecipe.service;

import com.excilys.projectRecipe.DAO.IngredientDAO;
import com.excilys.projectRecipe.DTO.IngredientDTO;
import com.excilys.projectRecipe.DTO.mapper.IngredientMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    IngredientDAO ingredientDAO;

    public IngredientService(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    public List<IngredientDTO> getall() {
        return ingredientDAO.getall();
    }

    public IngredientDTO getbyid(long id) throws Exception {
        IngredientMapper ingredientMapper = new IngredientMapper();
        if (ingredientDAO.getbyid(id).isPresent()) {
            return ingredientMapper.IngredientToDTO(ingredientDAO.getbyid(id).get());
        }
        throw new Exception();
    }

    public long create(IngredientDTO ingredientDTO) {
        IngredientMapper ingredientMapper = new IngredientMapper();
        System.out.println(" OCUOCUOUC");
        return ingredientDAO.create(ingredientMapper.DtoToIngredient(ingredientDTO));
    }

    public void updateIngredient(IngredientDTO ingredientDTO) {
        IngredientMapper ingredientMapper = new IngredientMapper();
        ingredientDAO.updateIngredient(ingredientMapper.DtoToIngredient(ingredientDTO));
    }

    public void delete(IngredientDTO ingredientDTO) {
        IngredientMapper ingredientMapper = new IngredientMapper();
        ingredientDAO.delete(ingredientMapper.DtoToIngredient(ingredientDTO));
    }

    public void deleteById(long id) {
        ingredientDAO.deleteById(id);
    }
}



