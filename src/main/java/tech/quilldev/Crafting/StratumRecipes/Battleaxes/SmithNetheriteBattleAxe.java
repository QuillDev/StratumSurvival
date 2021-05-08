package tech.quilldev.Crafting.StratumRecipes.Battleaxes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.Crafting.StratumMaterialManager;
import tech.quilldev.Crafting.StratumRecipes.StratumRecipe;

public class SmithNetheriteBattleAxe extends StratumRecipe {
    public SmithNetheriteBattleAxe(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager);
    }

    @Override
    public Recipe getRecipe() {

        return new SmithingRecipe(key,
                itemHelper.setCraftFormatting(materialManager.getItem(StratumMaterial.BATTLEAXE_NETHERITE)),
                new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT, Material.IRON_INGOT),
                new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT)
        );
    }
}
