package tech.quilldev.Crafting.StratumRecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.Crafting.StratumMaterialManager;

public class CraftBattleaxeWooden extends StratumRecipe {
    public CraftBattleaxeWooden(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager);
    }

    @Override
    public Recipe getRecipe() {
        final var recipe = new ShapedRecipe(key,
                itemHelper.setCraftFormatting(materialManager.getItem(StratumMaterial.BATTLEAXE_WOODEN))
        );
        recipe.shape("WWW", "WSW", ".S.");

        recipe.setIngredient('W', new RecipeChoice.MaterialChoice(
                Material.OAK_PLANKS,
                Material.SPRUCE_PLANKS,
                Material.DARK_OAK_PLANKS,
                Material.BIRCH_PLANKS,
                Material.ACACIA_PLANKS,
                Material.CRIMSON_PLANKS,
                Material.JUNGLE_PLANKS,
                Material.WARPED_PLANKS
        ));
        recipe.setIngredient('S', Material.STICK);
        return recipe;
    }
}
