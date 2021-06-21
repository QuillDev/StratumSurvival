package moe.quill.stratumsurvival.Crafting;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import moe.quill.StratumCommonApi.Annotations.IgnoreDynamicLoading;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Recipes.Generators.Geodes.RecipeGenerator;
import moe.quill.stratumsurvival.Crafting.Recipes.StratumRecipe;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;

@Singleton
public class StratumCraftingManager {

    private final Plugin plugin;
    private final Server server;
    private final MaterialManager materialManager;
    private final HashMap<String, NamespacedKey> recipeKeys = new HashMap<>();
    private static final Reflections reflections = new Reflections("moe.quill.stratumsurvival");
    private static final Logger logger = LoggerFactory.getLogger(StratumCraftingManager.class.getSimpleName());

    @Inject
    public StratumCraftingManager(Plugin plugin, MaterialManager materialManager) {
        this.plugin = plugin;
        this.materialManager = materialManager;
        this.server = plugin.getServer();
    }


    /**
     * Attempt do dynamically load attributes based on their extension from the attribute class
     */
    public void loadRecipesDynamically() {

        reflections
                .getSubTypesOf(StratumRecipe.class)
                .stream()
                .filter(recipeClass -> !Modifier.isAbstract(recipeClass.getModifiers()))
                .filter(recipeClass -> !recipeClass.isAnnotationPresent(IgnoreDynamicLoading.class))
                .forEach(attrClass -> {
                    try {
                        final var recipe = attrClass
                                .getDeclaredConstructor(MaterialManager.class)
                                .newInstance(materialManager);
                        registerStratumRecipe(recipe);
                    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });

        reflections
                .getSubTypesOf(RecipeGenerator.class)
                .stream()
                .filter(generatorClass -> !Modifier.isAbstract(generatorClass.getModifiers()))
                .filter(generatorClass -> !generatorClass.isAnnotationPresent(IgnoreDynamicLoading.class))
                .forEach(generatorClass -> {
                    try {
                        final var recipe = generatorClass.getDeclaredConstructor(MaterialManager.class).newInstance(materialManager);
                        final var recipes = recipe.getRecipes();
                        recipes.forEach(this::registerStratumRecipe);
                    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }

    private void registerStratumRecipe(StratumRecipe recipe) {
        final var recipeKey = recipe.getRecipeKey();
        final var recipeNsKey = new NamespacedKey(plugin, recipeKey);
        server.addRecipe(recipe.getRecipe(recipeNsKey)); //Add the recipe to the server
        recipeKeys.put(recipeKey, recipeNsKey);
        logger.info(String.format("Added new recipe -> %s", recipe.getRecipeKey()));
    }

    public void disable() {

        recipeKeys.forEach((key, value) -> {
            server.removeRecipe(value);
            logger.info(String.format("Removed recipe -> %s", key));
        });
    }
}
