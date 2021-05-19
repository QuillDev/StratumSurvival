package tech.quilldev.Crafting;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import tech.quilldev.Crafting.StratumRecipes.Materials.GeodeRecipes.GeodeRecipeGenerator;
import tech.quilldev.Crafting.StratumRecipes.Materials.GeodeRecipes.RecipeGeode;
import tech.quilldev.Crafting.StratumRecipes.StratumRecipe;
import tech.quilldev.CustomItemsv2.Attributes.ItemAttributes;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterialManager;
import tech.quilldev.StratumSurvival;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class StratumCraftingManager {

    private final Plugin plugin;
    private final Server server;
    private final ArrayList<StratumRecipe> recipes = new ArrayList<>();
    private static final Logger logger = Logger.getLogger("Minecraft");

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
            StratumSurvival.log(getClass(), "Added recipe " + recipe.getKey());
        });
    }

    public void registerAll(StratumRecipe... recipesToAdd) {
        Arrays.stream(recipesToAdd).forEach(recipe -> {
            recipes.add(recipe);
            server.addRecipe(recipe.getRecipe());
            StratumSurvival.log(getClass(), "Added recipe " + recipe.getKey());
        });
    }

    public void disable() {
        recipes.forEach(recipe -> {
            server.removeRecipe(recipe.getKey());
            StratumSurvival.log(getClass(), "Removed recipe " + recipe.getKey());
        });
        recipes.clear();
    }


}
