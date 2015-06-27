package co.uk.foodco.recipes.service;

import co.uk.foodco.recipes.builder.RecipeBuilder;
import co.uk.foodco.recipes.model.Recipes;
import co.uk.foodco.recipes.repository.RecipesRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * DefaultRecipesServiceTest
 *
 * @author Aravinthan Narasimhan
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultRecipesServiceTest {

    //System Under Test
    @InjectMocks
    private DefaultRecipesService recipesService;

    @Mock
    private RecipesRepository mockRecipesRepository;

    @Test
    public void testListRecipesWithNoRecipeInSystem() {
        when(mockRecipesRepository.findAll()).thenReturn(new Recipes());

        Recipes recipesOne = recipesService.listRecipes();
        Assert.assertNotNull(recipesOne);
        Assert.assertTrue(recipesOne.getRecipes().isEmpty());
        Assert.assertEquals(0, recipesOne.getTotalItems());

        Recipes recipesTwo = recipesService.listRecipes(1, 10);
        Assert.assertNotNull(recipesTwo);
        Assert.assertTrue(recipesTwo.getRecipes().isEmpty());
        Assert.assertEquals(0, recipesTwo.getTotalItems());

        Recipes recipesThree = recipesService.listRecipes(3, 11);
        Assert.assertNotNull(recipesThree);
        Assert.assertTrue(recipesThree.getRecipes().isEmpty());
        Assert.assertEquals(0, recipesThree.getTotalItems());
    }

    @Test
    public void testListRecipesWithOneRecipeInSystem() {
        Recipes recipes = new Recipes();
        recipes.setRecipes(RecipeBuilder.getOneRecipe());
        when(mockRecipesRepository.findAll()).thenReturn(recipes);

        Recipes recipesOne = recipesService.listRecipes();
        Assert.assertNotNull(recipesOne);
        Assert.assertEquals(1, recipesOne.getRecipes().size());
        Assert.assertEquals(1, recipesOne.getTotalItems());

        Recipes recipesTwo = recipesService.listRecipes(1, 1);
        Assert.assertNotNull(recipesTwo);
        Assert.assertEquals(1, recipesTwo.getRecipes().size());
        Assert.assertEquals(1, recipesTwo.getTotalItems());

        Recipes recipesThree = recipesService.listRecipes(2, 12);
        Assert.assertNotNull(recipesThree);
        Assert.assertEquals(1, recipesThree.getRecipes().size());
        Assert.assertEquals(1, recipesThree.getTotalItems());
    }

    @Test
    public void testListRecipesWithMultipleRecipesInSystem() {
        Recipes recipes = new Recipes();
        recipes.setRecipes(RecipeBuilder.getTwelveRecipes());
        when(mockRecipesRepository.findAll()).thenReturn(recipes);

        Recipes recipesOne = recipesService.listRecipes();
        Assert.assertNotNull(recipesOne);
        Assert.assertEquals(12, recipesOne.getRecipes().size());
        Assert.assertEquals(12, recipesOne.getTotalItems());

        recipes.setRecipes(RecipeBuilder.getTwelveRecipes());
        Recipes recipesTwo = recipesService.listRecipes(1, 10);
        Assert.assertNotNull(recipesTwo);
        Assert.assertEquals(10, recipesTwo.getRecipes().size());
        Assert.assertEquals(12, recipesTwo.getTotalItems());

        recipes.setRecipes(RecipeBuilder.getTwelveRecipes());
        Recipes recipesThree = recipesService.listRecipes(2, 10);
        Assert.assertNotNull(recipesThree);
        Assert.assertEquals(2, recipesThree.getRecipes().size());
        Assert.assertEquals(12, recipesThree.getTotalItems());

        recipes.setRecipes(RecipeBuilder.getTwelveRecipes());
        Recipes recipesFour = recipesService.listRecipes(3, 10);
        Assert.assertNotNull(recipesFour);
        Assert.assertEquals(12, recipesFour.getRecipes().size());
        Assert.assertEquals(12, recipesFour.getTotalItems());

        recipes.setRecipes(RecipeBuilder.getTwelveRecipes());
        Recipes recipesFive = recipesService.listRecipes(4, 3);
        Assert.assertNotNull(recipesFive);
        Assert.assertEquals(3, recipesFive.getRecipes().size());
        Assert.assertEquals(12, recipesFive.getTotalItems());

        //Can add more assertion to test are we getting the items from the right pages.
    }
}
