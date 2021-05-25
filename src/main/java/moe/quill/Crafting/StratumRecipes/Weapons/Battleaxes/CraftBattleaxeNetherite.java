package moe.quill.Crafting.StratumRecipes.Weapons.Battleaxes;

import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.StratumRecipes.Weapons.AbstractRecipes.StratumSmithRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftBattleaxeNetherite extends StratumSmithRecipe {
    public CraftBattleaxeNetherite(StratumMaterialManager materialManager) {
        super(RecipeKey.RECIPE_BATTLEAXE_NETHERITE, materialManager, StratumMaterial.BATTLEAXE_DIAMOND, StratumMaterial.BATTLEAXE_NETHERITE);
    }
}
