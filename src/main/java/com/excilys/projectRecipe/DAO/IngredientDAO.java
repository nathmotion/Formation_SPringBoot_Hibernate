package com.excilys.projectRecipe.DAO;

import com.excilys.projectRecipe.DTO.IngredientDTO;
import com.excilys.projectRecipe.model.Ingredient;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientDAO {
    static final String GETALL = "SELECT r FROM Ingredient r ";

    @PersistenceContext
    EntityManager em;

    public List<IngredientDTO> getall() {
        return em.createQuery(GETALL).getResultList();
    }

    public Optional<Ingredient> getbyid(long id) {
        Session session = em.unwrap(Session.class);
        Optional<Ingredient> optionalIngredient = Optional.of(session.get(Ingredient.class, id));
        session.close();
        return optionalIngredient;
    }

    public long create(Ingredient ingredient) {
        Session session = em.unwrap(Session.class);
        Ingredient i = (Ingredient) session.save(ingredient);
        return i.getId();
    }

    public void updateIngredient(Ingredient ingredient) {
        Session session = em.unwrap(Session.class);
        session.update(ingredient);
    }


    public void delete(Ingredient ingredient) {
        Session session = em.unwrap(Session.class);
        session.delete(ingredient);
    }

    public void deleteById(long id) {
        Session session = em.unwrap(Session.class);
        Optional<Ingredient> optionalIngredient = getbyid(id);
        if (optionalIngredient.isPresent()) {
            Ingredient i = optionalIngredient.get();
            session.delete(i);
        }
    }
}
