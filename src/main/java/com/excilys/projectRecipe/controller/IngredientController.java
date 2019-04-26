package com.excilys.projectRecipe.controller;

import com.excilys.projectRecipe.DTO.IngredientDTO;
import com.excilys.projectRecipe.service.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/ingredients")
public class IngredientController {

    IngredientService ingredientService;

    @GetMapping
    List<IngredientDTO> getall() {
        return ingredientService.getall();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    IngredientDTO getbyid(@PathVariable(name = "id") Long id) throws Exception {
        return ingredientService.getbyid(id);
    }

    @PostMapping()
    long create(@RequestBody IngredientDTO ingredientDTO) {
        System.out.println(" OCUOCUOUC");
        return ingredientService.create(ingredientDTO);
    }

    @PutMapping
    void updateIngredient(@RequestBody IngredientDTO ingredientDTO) {
        ingredientService.updateIngredient(ingredientDTO);
    }

    @DeleteMapping
    void delete(@RequestBody IngredientDTO ingredientDTO) {
        ingredientService.delete(ingredientDTO);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    void deleteById(@PathVariable(name = "id") Long id) {
        ingredientService.deleteById(id);
    }

}
