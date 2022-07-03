package dragonsaga.registry;

import necesse.engine.registries.RecipeTechRegistry;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;

public class DragonRecipeRegistry {

    public static void Register() {
        Recipes.registerModRecipe(new Recipe(
                "dragonhumanracechanget1",
                1,
                RecipeTechRegistry.NONE,
                new Ingredient[]{
                        new Ingredient("coin", 1)
                }
        ));

        Recipes.registerModRecipe(new Recipe(
                "dragonhumanracechanget2",
                1,
                RecipeTechRegistry.NONE,
                new Ingredient[]{
                        new Ingredient("coin", 1)
                }
        ));

        Recipes.registerModRecipe(new Recipe(
                "dragonhumanracechanget3",
                1,
                RecipeTechRegistry.NONE,
                new Ingredient[]{
                        new Ingredient("coin", 1)
                }
        ));

        Recipes.registerModRecipe(new Recipe(
                "medicalmachine",
                1,
                RecipeTechRegistry.NONE,
                new Ingredient[]{
                        new Ingredient("coin", 1)
                }
        ));
    }
}
