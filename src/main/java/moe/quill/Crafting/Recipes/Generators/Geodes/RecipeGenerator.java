package moe.quill.Crafting.Recipes.Generators.Geodes;

import moe.quill.Crafting.Recipes.StratumRecipe;

import java.util.HashSet;

public abstract class RecipeGenerator {

    public RecipeGenerator() { }

    public abstract HashSet<StratumRecipe> getRecipes();
}
