package tech.quilldev.Crafting.StratumRecipes.Weapons.Battleaxes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import tech.quilldev.Crafting.StratumRecipes.Weapons.AbstractRecipes.WoodRecipe;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterialManager;
import tech.quilldev.Crafting.StratumRecipes.StratumRecipe;

public class CraftBattleaxeWooden extends StratumRecipe implements WoodRecipe {
    public CraftBattleaxeWooden(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapedRecipe(key, materialManager.getItem(StratumMaterial.BATTLEAXE_WOODEN));
        recipe.shape("MMM", "MSM", ".S.");
        recipe.setIngredient('M', getMaterialChoice());
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }
}
