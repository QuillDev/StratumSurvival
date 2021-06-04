package moe.quill.stratumsurvival.Crafting.Recipes.Generators.Geodes;

import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;

import java.util.HashSet;

public abstract class RecipeGenerator {

    public RecipeGenerator() { }

    public abstract HashSet<StratumRecipe> getRecipes();
}
