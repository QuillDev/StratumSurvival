package tech.quilldev.Crafting.StratumRecipes.Weapons.Battleaxes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterialManager;
import tech.quilldev.Crafting.StratumRecipes.StratumRecipe;

public class CraftBattleaxeNetherite extends StratumRecipe {
    public CraftBattleaxeNetherite(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapelessRecipe(key, materialManager.getItem(StratumMaterial.BATTLEAXE_NETHERITE));
        recipe.addIngredient(1, materialManager.getItem(StratumMaterial.BATTLEAXE_DIAMOND));
        recipe.addIngredient(1, Material.NETHERITE_INGOT);

        return recipe;
    }
}
