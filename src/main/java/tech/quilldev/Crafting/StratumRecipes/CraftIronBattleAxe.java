package tech.quilldev.Crafting.StratumRecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import tech.quilldev.Crafting.StratumMaterial;

public class CraftIronBattleAxe extends StratumRecipe {
    public CraftIronBattleAxe(NamespacedKey key) {
        super(key);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapedRecipe(key, StratumMaterial.BATTLEAXE_IRON);
        recipe.shape("III", "ISI", ".S.");

        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('S', Material.STICK);
        return recipe;
    }
}
