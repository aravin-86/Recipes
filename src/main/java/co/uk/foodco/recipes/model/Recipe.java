package co.uk.foodco.recipes.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Recipe
 *
 * @author Aravinthan Narasimhan
 */
public class Recipe {

    private String id;

    private String name;

    private int cookingMinutes;

    private List<String> mainIngredients = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(int cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }

    public List<String> getMainIngredients() {
        return mainIngredients;
    }

    public void setMainIngredients(List<String> mainIngredients) {
        this.mainIngredients = mainIngredients;
    }
}
