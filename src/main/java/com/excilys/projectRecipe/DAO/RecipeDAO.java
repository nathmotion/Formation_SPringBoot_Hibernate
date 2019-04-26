package com.excilys.projectRecipe.DAO;

import com.excilys.projectRecipe.model.Ingredient;
import com.excilys.projectRecipe.model.Recipe;
import com.excilys.projectRecipe.model.RecipeIngredient;
import com.excilys.projectRecipe.service.IngredientService;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class RecipeDAO {

    static final String GETALL = "SELECT r FROM Recipe r ";

    @PersistenceContext
    EntityManager em;

    IngredientDAO ingredientDAO;

    public RecipeDAO(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    public Optional<Recipe> getRecipeById(long id) {
        Session session = em.unwrap(Session.class);
        Optional<Recipe> optionalRecipe = Optional.of(session.get(Recipe.class, id));
        session.close();
        return optionalRecipe;
    }

    public List<Recipe> getAll() {
        return em.createQuery(GETALL).getResultList();
    }

    public long createRecipe(Recipe recipe) throws Exception {
        checkIngredient(recipe);
        Session session = em.unwrap(Session.class);
        Optional<Recipe> optionalRecipe = Optional.of((Recipe) session.save(recipe));
        session.close();
        if (optionalRecipe.isPresent()) {
            return optionalRecipe.get().getId();
        }
        throw new Exception();
    }

    public long addIngredients(List<RecipeIngredient> ingredients, long id) {
        Session session = em.unwrap(Session.class);
        Optional<Recipe> optionalRecipe = getRecipeById(id);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            Set<RecipeIngredient> setRI = recipe.getRecipeIngredients();

            ingredients.stream().forEach(r -> setRI.add(r));
            recipe.setRecipeIngredients(setRI);
            session.update(recipe);
            session.close();
            return recipe.getId();
        }
        return -1;
    }

    public void updateRecipe(Recipe recipe) {
        checkIngredient(recipe);
        Session session = em.unwrap(Session.class);
        session.update(recipe);
    }

    public void delete(Recipe recipe) {
        Session session = em.unwrap(Session.class);
        session.delete(recipe);
    }

    public void deleteById(long id) {
        Session session = em.unwrap(Session.class);
        Optional<Recipe> optionalRecipe = getRecipeById(id);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            session.delete(recipe);
        }
    }

    private void checkIngredient(Recipe recipe) {
        Set<RecipeIngredient> setRI = recipe.getRecipeIngredients();
        setRI.forEach(r -> {
                    if (!ingredientDAO.getbyid(r.getIngredient().getId()).isPresent()) {
                        System.out.println(" INGREDIENT INCONNU  " + r.getIngredient().getName());
                        Ingredient newIngredient = new Ingredient();
                        newIngredient.setName(r.getIngredient().getName());
                        ingredientDAO.create(newIngredient);
                    }
                }
        );
    }
}
