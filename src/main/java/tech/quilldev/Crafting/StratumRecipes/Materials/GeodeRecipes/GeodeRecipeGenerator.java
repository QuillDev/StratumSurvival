package tech.quilldev.Crafting.StratumRecipes.Materials.GeodeRecipes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.plugin.Plugin;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterialManager;
import tech.quilldev.CustomItemsv2.MaterialManager.WeaponType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GeodeRecipeGenerator {

    private final StratumMaterialManager materialManager;
    private final Plugin plugin;

    public GeodeRecipeGenerator(StratumMaterialManager materialManager, Plugin plugin) {
        this.materialManager = materialManager;
        this.plugin = plugin;
    }

    public ArrayList<RecipeGeode> generateGeodeRecipes(HashMap<String, WeaponType> attributeLists) {

        final var recipeList = new ArrayList<RecipeGeode>();

        for (final var key : attributeLists.keySet()) {
            final var entry = attributeLists.get(key);
            final var choice = new RecipeChoice.ExactChoice(entry.itemStacks);

            recipeList.addAll(
                    Arrays.asList(
                            new RecipeGeode(
                                    new NamespacedKey(plugin, "recipe_smith_geode_common_" + key),
                                    materialManager,
                                    StratumMaterial.GEODE_COMMON,
                                    StratumMaterial.SHARD_COMMON,
                                    choice
                            ),
                            new RecipeGeode(
                                    new NamespacedKey(plugin, "recipe_smith_geode_uncommon_" + key),
                                    materialManager,
                                    StratumMaterial.GEODE_UNCOMMON,
                                    StratumMaterial.SHARD_UNCOMMON,
                                    choice
                            ),
                            new RecipeGeode(
                                    new NamespacedKey(plugin, "recipe_smith_geode_rare_" + key),
                                    materialManager,
                                    StratumMaterial.GEODE_RARE,
                                    StratumMaterial.SHARD_RARE,
                                    choice
                            ),
                            new RecipeGeode(
                                    new NamespacedKey(plugin, "recipe_smith_geode_epic_" + key),
                                    materialManager,
                                    StratumMaterial.GEODE_EPIC,
                                    StratumMaterial.SHARD_EPIC,
                                    choice
                            ),
                            new RecipeGeode(
                                    new NamespacedKey(plugin, "recipe_smith_geode_legendary_" + key),
                                    materialManager,
                                    StratumMaterial.GEODE_LEGENDARY,
                                    StratumMaterial.SHARD_LEGENDARY,
                                    choice
                            )
                    )
            );
        }

        return recipeList;
    }
}