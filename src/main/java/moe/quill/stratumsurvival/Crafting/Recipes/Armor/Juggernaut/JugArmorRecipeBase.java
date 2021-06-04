package moe.quill.stratumsurvival.Crafting.Recipes.Armor.Juggernaut;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.Armor.ArmorRecipeBase;
import moe.quill.stratumsurvival.Crafting.Recipes.RecipeKey;
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
