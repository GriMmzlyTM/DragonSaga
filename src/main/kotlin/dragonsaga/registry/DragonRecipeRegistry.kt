package dragonsaga.registry

import necesse.engine.registries.RecipeTechRegistry
import necesse.inventory.recipe.Ingredient
import necesse.inventory.recipe.Recipe
import necesse.inventory.recipe.Recipes

object DragonRecipeRegistry {

    fun RegisterAll() {
        Recipes.registerModRecipe(Recipe("dragonhumanracechanget1", 1, RecipeTechRegistry.NONE, arrayOf(Ingredient("coin", 1))))
        Recipes.registerModRecipe(Recipe("dragonhumanracechanget2", 1, RecipeTechRegistry.NONE, arrayOf(Ingredient("coin", 1))))
        Recipes.registerModRecipe(Recipe("dragonhumanracechanget3", 1, RecipeTechRegistry.NONE, arrayOf(Ingredient("coin", 1))))
        Recipes.registerModRecipe(Recipe("medicalmachine", 1, RecipeTechRegistry.NONE, arrayOf(Ingredient("coin", 1))))
    }
}