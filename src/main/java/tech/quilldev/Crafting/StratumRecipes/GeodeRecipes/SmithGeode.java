package tech.quilldev.Crafting.StratumRecipes.GeodeRecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.Crafting.StratumMaterialManager;
import tech.quilldev.Crafting.StratumRecipes.StratumRecipe;

public class SmithGeode extends StratumRecipe {

    public SmithGeode(NamespacedKey key, StratumMaterialManager materialManager) {
        super(key, materialManager);
    }

    @Override
    public Recipe getRecipe() {
        return new SmithingRecipe(key,
                itemHelper.setCraftFormatting(materialManager.getItem(StratumMaterial.GEODE_COMMON)),
                new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT, Material.IRON_INGOT),
                new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT)
        );
    }
}