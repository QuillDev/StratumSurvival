package tech.quilldev.Crafting.StratumRecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import tech.quilldev.Crafting.StratumMaterial;

public class CraftDiamondBattleAxe extends StratumRecipe{
    public CraftDiamondBattleAxe(NamespacedKey key) {
        super(key);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapedRecipe(key, StratumMaterial.BATTLEAXE_DIAMOND);
        recipe.shape("DDD", "DSD", ".S.");

        recipe.setIngredient('D', Material.DIAMOND);
        recipe.setIngredient('S', Material.STICK);
        return recipe;
    }
}
