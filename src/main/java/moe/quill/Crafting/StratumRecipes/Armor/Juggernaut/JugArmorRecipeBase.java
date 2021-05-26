package moe.quill.Crafting.StratumRecipes.Armor.Juggernaut;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Crafting.RecipeKey;
import moe.quill.Crafting.StratumRecipes.Armor.ArmorRecipeBase;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public abstract class JugArmorRecipeBase extends ArmorRecipeBase {

    public JugArmorRecipeBase(RecipeKey key, StratumMaterialManager materialManager, StratumMaterial choice, StratumMaterial result) {
        super(key, materialManager,
                new RecipeChoice.ExactChoice(materialManager.getItem(choice)),
                new RecipeChoice.MaterialChoice(Material.NAUTILUS_SHELL),
                3,
                result);
    }
}
