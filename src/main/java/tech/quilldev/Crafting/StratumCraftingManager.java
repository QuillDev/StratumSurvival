package tech.quilldev.Crafting;

import org.bukkit.Server;
import tech.quilldev.Crafting.StratumRecipes.StratumRecipe;
import tech.quilldev.StratumSurvival;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StratumCraftingManager {

    private final Server server;
    private final ArrayList<StratumRecipe> recipes = new ArrayList<>();
    private static final Logger logger = Logger.getLogger("Minecraft");

    public StratumCraftingManager(Server server) {
        this.server = server;
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
