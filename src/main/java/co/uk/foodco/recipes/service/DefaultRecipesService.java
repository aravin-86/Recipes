package co.uk.foodco.recipes.service;

import co.uk.foodco.recipes.model.Recipes;
import co.uk.foodco.recipes.repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("defaultRecipesService")
public class DefaultRecipesService implements RecipesService {

    @Value("#{inMemoryRecipesRepositoryStub}")
    private RecipesRepository recipesRepository;

    @Override
    public Recipes listRecipes() {
        Recipes recipes = recipesRepository.findAll();
        recipes.setTotalItems(recipes.getRecipes().size());
        return recipes;
    }

    @Override
    public Recipes listRecipes(int pageNo, int itemsPerPage) {
        Recipes recipes = recipesRepository.findAll();
        int totalRecipes = recipes.getRecipes().size();
        recipes.setTotalItems(totalRecipes);

        int fromIndex = (pageNo - 1) * itemsPerPage;
        int toIndex = fromIndex + itemsPerPage;

        if (toIndex > totalRecipes) {
            toIndex = totalRecipes;
        }

        if (fromIndex < toIndex) {
            recipes.setRecipes(recipes.getRecipes().subList(fromIndex, toIndex));
        }

        return recipes;
    }

    public void setRecipesRepository(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }
}
