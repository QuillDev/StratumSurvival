package tech.quilldev.Crafting.StratumRecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.SmithingRecipe;
import tech.quilldev.Crafting.StratumMaterial;

public class SmithNetheriteBattleAxe extends StratumRecipe{
    public SmithNetheriteBattleAxe(NamespacedKey key) {
        super(key);
    }

    @Override
    public Recipe getRecipe() {

        final var recipe = new SmithingRecipe(key,
                StratumMaterial.BATTLEAXE_NETHERITE,
                new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT,Material.IRON_INGOT),
                new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT)
        );
        return recipe;
    }
}
