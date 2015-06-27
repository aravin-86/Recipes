package co.uk.foodco.recipes.repository;

import co.uk.foodco.recipes.builder.RecipeBuilder;
import co.uk.foodco.recipes.model.Recipe;
import co.uk.foodco.recipes.model.Recipes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("inMemoryRecipesRepositoryStub")
public class InMemoryRecipesRepositoryStub implements RecipesRepository {

    @Value("#{systemProperties['totalRecipes'] ?: 12}")
    private String totalRecipeToBuild;

    @Override
    public Recipes findAll() {
        List<Recipe> recipeList = RecipeBuilder.getTwelveRecipes();
        int totalRecipes = Integer.parseInt(totalRecipeToBuild);
        if (totalRecipes == 0) {
            recipeList = Collections.emptyList();
        } else if (totalRecipes > 0 && totalRecipes <= 10) {
            if (totalRecipes == 1) {
                recipeList = RecipeBuilder.getOneRecipe();
            } else if (totalRecipes == 3) {
                recipeList = RecipeBuilder.getThreeRecipes();
            } else {
                recipeList = RecipeBuilder.getTenRecipes();
            }
        }
        Recipes recipes = new Recipes();
        recipes.setRecipes(recipeList);
        return recipes;
    }
}
