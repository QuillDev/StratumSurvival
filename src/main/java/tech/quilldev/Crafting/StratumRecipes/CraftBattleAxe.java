package tech.quilldev.Crafting.StratumRecipes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class CraftBattleAxe extends StratumRecipe {
    public CraftBattleAxe(NamespacedKey key) {
        super(key);
    }

    @Override
    public Recipe getRecipe() {
        final var battleaxe = new ItemStack(Material.NETHERITE_AXE);
        final var battleaxeMeta = battleaxe.getItemMeta();
        battleaxeMeta.setCustomModelData(1);
        battleaxeMeta.setLocalizedName("Netherite Battleaxe");
        battleaxeMeta.displayName(Component.text("Netherite Battleaxe").style(Style.empty()));
        battleaxe.setItemMeta(battleaxeMeta);
        final var recipe = new ShapedRecipe(key, battleaxe);
        recipe.shape("NNN", "NSN", ".S.");
        recipe.setIngredient('N', Material.NETHERITE_INGOT);
        recipe.setIngredient('S', Material.STICK);
        return recipe;
    }
}
