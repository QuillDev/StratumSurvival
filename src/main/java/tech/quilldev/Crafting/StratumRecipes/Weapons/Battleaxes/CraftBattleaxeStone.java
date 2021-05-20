package tech.quilldev.Crafting.StratumRecipes.Weapons.Battleaxes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import tech.quilldev.Crafting.StratumRecipes.StratumRecipe;
import tech.quilldev.Crafting.StratumRecipes.Weapons.AbstractRecipes.CobbleRecipe;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterialManager;

public class CraftBattleaxeStone extends StratumRecipe implements CobbleRecipe {
    public CraftBattleaxeStone(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(StratumMaterial.BATTLEAXE_STONE));
        recipe.shape("MMM", "MSM", ".S.");
        recipe.setIngredient('M', getMaterialChoice());
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }
}
