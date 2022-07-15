package dragonsaga.registry

import necesse.engine.registries.RecipeTechRegistry
import necesse.inventory.recipe.Ingredient
import necesse.inventory.recipe.Recipe
import necesse.inventory.recipe.Recipes

object DragonRecipeRegistry {

    fun RegisterAll() {
        Recipes.registerModRecipe(Recipe("humanrace-t1", 1, RecipeTechRegistry.NONE, arrayOf(Ingredient("coin", 1))))
        Recipes.registerModRecipe(Recipe("humanrace-t2", 1, RecipeTechRegistry.NONE, arrayOf(Ingredient("coin", 1))))
        Recipes.registerModRecipe(Recipe("humanrace-t3", 1, RecipeTechRegistry.NONE, arrayOf(Ingredient("coin", 1))))
        Recipes.registerModRecipe(Recipe("medicalmachine", 1, RecipeTechRegistry.NONE, arrayOf(Ingredient("coin", 1))))
    }
}