package tech.quilldev.Crafting.StratumRecipes.Weapons.Daggers;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import tech.quilldev.Crafting.StratumRecipes.StratumRecipe;
import tech.quilldev.Crafting.StratumRecipes.Weapons.AbstractRecipes.CobbleRecipe;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterialManager;

public class CraftDaggerStone extends StratumRecipe implements CobbleRecipe {
    public CraftDaggerStone(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(StratumMaterial.DAGGER_STONE));
        recipe.shape("...", ".M.", "S..");
        recipe.setIngredient('M', getMaterialChoice());
        recipe.setIngredient('S', Material.STICK);
        return recipe;
    }
}
