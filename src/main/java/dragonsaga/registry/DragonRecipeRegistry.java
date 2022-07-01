package dragonsaga.registry;

import necesse.engine.registries.RecipeTechRegistry;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;

public class DragonRecipeRegistry {

    public static void Register() {
        Recipes.registerModRecipe(new Recipe(
                "namekianracechange",
                1,
                RecipeTechRegistry.NONE,
                new Ingredient[]{
                        new Ingredient("coin", 1)
                }
        ));

        Recipes.registerModRecipe(new Recipe(
                "demongihat",
                1,
                RecipeTechRegistry.NONE,
                new Ingredient[]{
                        new Ingredient("coin", 1)
                }
        ));
    }
}
