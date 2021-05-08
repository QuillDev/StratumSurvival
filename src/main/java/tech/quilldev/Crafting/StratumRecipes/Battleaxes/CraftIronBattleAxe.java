package tech.quilldev.Crafting.StratumRecipes.Battleaxes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.Crafting.StratumMaterialManager;
import tech.quilldev.Crafting.StratumRecipes.StratumRecipe;

public class CraftIronBattleAxe extends StratumRecipe {
    public CraftIronBattleAxe(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapedRecipe(key,
                itemHelper.setCraftFormatting(materialManager.getItem(StratumMaterial.BATTLEAXE_IRON))
        );
        recipe.shape("III", "ISI", ".S.");

        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('S', Material.STICK);
        return recipe;
    }
}
