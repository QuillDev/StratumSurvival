package tech.quilldev.Crafting;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;

public class CraftTest {

    public ShapelessRecipe getRecipe(Plugin plugin) {
        final var item = new ItemStack(Material.EMERALD);
        final var meta = item.getItemMeta();
        meta.setCustomModelData(1);
        item.setItemMeta(meta);

        final var recipe = new ShapelessRecipe(new NamespacedKey(plugin, "craft_test"), item);
        recipe.addIngredient(Material.EMERALD);
        return recipe;
    }
}
