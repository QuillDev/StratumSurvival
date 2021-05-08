package tech.quilldev.Crafting.StratumRecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.Crafting.StratumMaterialManager;

public class CraftGoldenBattleAxe extends StratumRecipe {
    public CraftGoldenBattleAxe(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapedRecipe(key,
                itemHelper.setCraftFormatting(materialManager.getItem(StratumMaterial.BATTLEAXE_GOLDEN))
        );
        recipe.shape("GGG", "GSG", ".S.");

        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('S', Material.STICK);
        return recipe;
    }
}
