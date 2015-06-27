package co.uk.foodco.recipes.service;

import co.uk.foodco.recipes.model.Recipes;

public interface RecipesService {

    Recipes listRecipes();

    Recipes listRecipes(int pageNo, int itemsPerPage);
}
