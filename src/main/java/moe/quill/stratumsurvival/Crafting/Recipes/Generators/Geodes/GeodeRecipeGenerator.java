package moe.quill.stratumsurvival.Crafting.Recipes.Generators.Geodes;

import moe.quill.stratumsurvival.Crafting.Items.Attributes.ItemAttributes;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.inventory.RecipeChoice;

import java.util.HashSet;


public class GeodeRecipeGenerator extends RecipeGenerator {

    private final MaterialManager materialManager;

    public GeodeRecipeGenerator(MaterialManager materialManager) {
        this.materialManager = materialManager;
    }


    @Override
    public HashSet<StratumRecipe> getRecipes() {
        final var attributeLists = ItemAttributes.attributeCategories;
        return new HashSet<>() {{
            for (final var key : attributeLists.keySet()) {
                final var entry = attributeLists.get(key);
                if (entry.itemStacks.size() == 0) continue;
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
