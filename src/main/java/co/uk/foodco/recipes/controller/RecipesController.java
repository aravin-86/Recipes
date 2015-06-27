package co.uk.foodco.recipes.controller;


import co.uk.foodco.recipes.model.Recipes;
import co.uk.foodco.recipes.service.RecipesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static co.uk.foodco.recipes.util.RecipesConstants.ITEMS_PER_PAGE;

@Controller
@RequestMapping("/recipes")
public class RecipesController {

    private static final Logger LOG = LoggerFactory.getLogger(RecipesController.class);

    @Value("#{defaultRecipesService}")
    private RecipesService recipesService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    Recipes list(@RequestParam(value = "pageNo", required = false) String pageNo) {
        LOG.debug("pageNo: " + pageNo);
        Recipes recipes = null;
        if (pageNo != null) {
            recipes = recipesService.listRecipes(Integer.parseInt(pageNo), ITEMS_PER_PAGE);
        } else {
            recipes = recipesService.listRecipes();
        }
        LOG.debug("Recipes Size: " + recipes.getRecipes().size());
        return recipes;
    }
}
