package tech.quilldev.Crafting;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;

public class CustomCrafting {
    //idk where you would want this but its called in stratumsurvival
    public void registerCrafting(Plugin plugin){
        Bukkit.addRecipe(getCommonRecipe(plugin));
        Bukkit.addRecipe(getIronBattleaxeRecipe(plugin));
    }

    //this works but doesnt rename the item
    public ShapelessRecipe getCommonRecipe(Plugin plugin) {
        final var common_crystal = new ItemStack(Material.EMERALD);
        final var meta = common_crystal.getItemMeta();
        meta.setCustomModelData(1001);
        meta.displayName(Component.text("Common Shard"));
        common_crystal.setItemMeta(meta);


        final var recipe = new ShapelessRecipe(new NamespacedKey(plugin, "craft_test"), common_crystal);
        recipe.addIngredient(Material.EMERALD);
        return recipe;
    }

    //this one does not work
    public ShapedRecipe getIronBattleaxeRecipe(Plugin plugin) {
        final var iron_battleaxe = new ItemStack(Material.IRON_AXE);
        final var meta = iron_battleaxe.getItemMeta();
        meta.setCustomModelData(2001);
        iron_battleaxe.setItemMeta(meta);

        final var recipe = new ShapedRecipe(new NamespacedKey(plugin, "wooden_battleaxe_craft"), iron_battleaxe);
        recipe.shape("III", "ISI", " S ");

        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('S', Material.STICK);

        return recipe;
    }
}
