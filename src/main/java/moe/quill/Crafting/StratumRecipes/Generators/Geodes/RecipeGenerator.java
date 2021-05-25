package moe.quill.Crafting.StratumRecipes.Generators.Geodes;

import moe.quill.Crafting.StratumRecipes.StratumRecipe;

import java.util.HashSet;

public abstract class RecipeGenerator {

    public RecipeGenerator() { }

    public abstract HashSet<StratumRecipe> getRecipes();
}
