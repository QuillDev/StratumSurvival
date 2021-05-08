package tech.quilldev.Crafting.StratumRecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import tech.quilldev.Crafting.StratumMaterial;

public class CraftGoldenBattleAxe extends StratumRecipe{
    public CraftGoldenBattleAxe(NamespacedKey key) {
        super(key);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapedRecipe(key, StratumMaterial.BATTLEAXE_GOLDEN);
        recipe.shape("GGG", "GSG", ".S.");

        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('S', Material.STICK);
        return recipe;
    }
}
