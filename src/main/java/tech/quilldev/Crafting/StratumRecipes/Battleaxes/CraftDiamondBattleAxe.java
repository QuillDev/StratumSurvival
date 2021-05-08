package tech.quilldev.Crafting.StratumRecipes.Battleaxes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.Crafting.StratumMaterialManager;
import tech.quilldev.Crafting.StratumRecipes.StratumRecipe;

public class CraftDiamondBattleAxe extends StratumRecipe {
    public CraftDiamondBattleAxe(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapedRecipe(key,
                itemHelper.setCraftFormatting(materialManager.getItem(StratumMaterial.BATTLEAXE_DIAMOND))
        );
        recipe.shape("DDD", "DSD", ".S.");

        recipe.setIngredient('D', Material.DIAMOND);
        recipe.setIngredient('S', Material.STICK);
        return recipe;
    }
}
