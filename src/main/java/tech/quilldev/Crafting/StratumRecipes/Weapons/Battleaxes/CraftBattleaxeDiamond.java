package tech.quilldev.Crafting.StratumRecipes.Weapons.Battleaxes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterialManager;
import tech.quilldev.Crafting.StratumRecipes.StratumRecipe;

public class CraftBattleaxeDiamond extends StratumRecipe {
    public CraftBattleaxeDiamond(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(StratumMaterial.BATTLEAXE_DIAMOND));
        recipe.shape("MMM", "MSM", ".S.");
        recipe.setIngredient('M', Material.DIAMOND);
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }
}
