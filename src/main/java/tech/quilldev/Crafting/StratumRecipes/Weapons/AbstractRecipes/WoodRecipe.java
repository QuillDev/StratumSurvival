package tech.quilldev.Crafting.StratumRecipes.Weapons.AbstractRecipes;

import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public interface WoodRecipe {

    RecipeChoice choice = new RecipeChoice.MaterialChoice(
            Material.OAK_PLANKS,
            Material.SPRUCE_PLANKS,
            Material.DARK_OAK_PLANKS,
            Material.BIRCH_PLANKS,
            Material.ACACIA_PLANKS,
            Material.CRIMSON_PLANKS,
            Material.JUNGLE_PLANKS,
            Material.WARPED_PLANKS
    );

    default RecipeChoice getMaterialChoice() {
        return choice;
    }
}
