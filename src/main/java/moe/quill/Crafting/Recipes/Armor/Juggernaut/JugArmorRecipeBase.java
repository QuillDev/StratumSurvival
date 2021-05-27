package moe.quill.Crafting.Recipes.Armor.Juggernaut;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.Recipes.RecipeKey;
import moe.quill.Crafting.Recipes.Armor.ArmorRecipeBase;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;

public abstract class JugArmorRecipeBase extends ArmorRecipeBase {

    public JugArmorRecipeBase(RecipeKey key, MaterialManager materialManager, StratumMaterial choice, StratumMaterial result) {
        super(key, materialManager,
                new RecipeChoice.ExactChoice(materialManager.getItem(choice)),
                new RecipeChoice.MaterialChoice(Material.NAUTILUS_SHELL),
                3,
                result);
    }
}
