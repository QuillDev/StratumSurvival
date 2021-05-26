package moe.quill.Crafting.Recipes.Weapons.AbstractRecipes;

import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public interface StoneRecipe {

    RecipeChoice choice = new RecipeChoice.MaterialChoice(
            Material.COBBLESTONE,
            Material.BASALT,
            Material.MOSSY_COBBLESTONE,
            Material.STONE,
            Material.BLACKSTONE
    );

    default RecipeChoice getMaterialChoice() {
        return choice;
    }
}
