package moe.quill.Crafting.StratumRecipes.Generators.Geodes;

import moe.quill.Crafting.CustomItems.Attributes.ItemAttributes;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import org.bukkit.inventory.RecipeChoice;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

import java.util.HashSet;


public class GeodeRecipeGenerator extends RecipeGenerator {

    private final StratumMaterialManager materialManager;

    public GeodeRecipeGenerator(StratumMaterialManager materialManager) {
        this.materialManager = materialManager;
    }


    @Override
    public HashSet<StratumRecipe> getRecipes() {
        final var attributeLists = ItemAttributes.attributeCategories;
        return new HashSet<>() {{
            for (final var key : attributeLists.keySet()) {
                final var entry = attributeLists.get(key);
                final var choice = new RecipeChoice.ExactChoice(entry.itemStacks);

                add(new RecipeGeode(
                        "RECIPE_SMITH_GEODE_COMMON_" + key,
                        materialManager,
                        StratumMaterial.GEODE_COMMON,
                        StratumMaterial.SHARD_COMMON,
                        choice
                ));
                add(new RecipeGeode(
                        "RECIPE_SMITH_GEODE_UNCOMMON_" + key,
                        materialManager,
                        StratumMaterial.GEODE_UNCOMMON,
                        StratumMaterial.SHARD_UNCOMMON,
                        choice
                ));
                add(new RecipeGeode(
                        "RECIPE_SMITH_GEODE_RARE_" + key,
                        materialManager,
                        StratumMaterial.GEODE_RARE,
                        StratumMaterial.SHARD_RARE,
                        choice
                ));
                add(new RecipeGeode(
                        "RECIPE_SMITH_GEODE_EPIC_" + key,
                        materialManager,
                        StratumMaterial.GEODE_EPIC,
                        StratumMaterial.SHARD_EPIC,
                        choice
                ));
                add(new RecipeGeode(
                        "RECIPE_SMITH_GEODE_LEGENDARY_" + key,
                        materialManager,
                        StratumMaterial.GEODE_LEGENDARY,
                        StratumMaterial.SHARD_LEGENDARY,
                        choice
                ));
            }
        }};
    }
}
