package moe.quill.Crafting;

import moe.quill.Crafting.StratumRecipes.Materials.GeodeRecipes.GeodeRecipeGenerator;
import moe.quill.Crafting.StratumRecipes.Materials.GeodeRecipes.RecipeGeode;
import moe.quill.Crafting.StratumRecipes.StratumRecipe;
import moe.quill.CustomItems.Attributes.ItemAttributes;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class StratumCraftingManager {

    private final Plugin plugin;
    private final Server server;
    private final ArrayList<StratumRecipe> recipes = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(StratumCraftingManager.class.getSimpleName());

    public StratumCraftingManager(Plugin plugin) {
        this.plugin = plugin;
        this.server = plugin.getServer();
    }

    public void registerDynamicRecipes(StratumMaterialManager materialManager) {
        final var geodeGenerator = new GeodeRecipeGenerator(materialManager, plugin);
        final var geodeRecipes = geodeGenerator.generateGeodeRecipes(ItemAttributes.attributeCategories);
        registerAll(geodeRecipes);
    }

    private void registerAll(ArrayList<RecipeGeode> geodeRecipes) {
        geodeRecipes.forEach(recipe -> {
            recipes.add(recipe);
            server.addRecipe(recipe.getRecipe());
            logger.info("Added recipe " + recipe.getKey());
        });
    }

    public void registerAll(StratumRecipe... recipesToAdd) {
        Arrays.stream(recipesToAdd).forEach(recipe -> {
            recipes.add(recipe);
            server.addRecipe(recipe.getRecipe());
            logger.info("Added recipe " + recipe.getKey());
        });
    }

    public void disable() {
        recipes.forEach(recipe -> {
            server.removeRecipe(recipe.getKey());
            logger.info("Removed recipe " + recipe.getKey());
        });
        recipes.clear();
    }


}
