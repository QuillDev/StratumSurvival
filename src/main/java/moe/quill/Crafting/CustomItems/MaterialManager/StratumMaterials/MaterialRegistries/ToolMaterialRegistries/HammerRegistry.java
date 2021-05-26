package moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries.ToolMaterialRegistries;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.HashMap;

public class HammerRegistry extends MaterialRegistry {
    public HammerRegistry() {
        super(MaterialKey.HAMMER_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{
            final var icepickLore = Collections.singletonList(
                    Component.text("Great for breaking the ice!").color(TextColor.color(0x5FA5CB)).asComponent()
            );

            // Setup the common ice pick
            final var HAMMER_WOODEN = new ItemStack(Material.WOODEN_PICKAXE);
            final var HAMMER_WOODEN_META = HAMMER_WOODEN.getItemMeta();
            HAMMER_WOODEN_META.setCustomModelData(1);
            HAMMER_WOODEN_META.setLocalizedName("Wooden Hammer");
            HAMMER_WOODEN_META.lore(icepickLore);
            HAMMER_WOODEN.setItemMeta(HAMMER_WOODEN_META);
            // Setup the common ice pick
            final var HAMMER_STONE = new ItemStack(Material.STONE_PICKAXE);
            final var HAMMER_STONE_META = HAMMER_STONE.getItemMeta();
            HAMMER_STONE_META.setCustomModelData(1);
            HAMMER_STONE_META.setLocalizedName("Stone Hammer");
            HAMMER_STONE_META.lore(icepickLore);
            HAMMER_STONE.setItemMeta(HAMMER_STONE_META);

            //Golden crafting ice pick
            final var HAMMER_GOLDEN = new ItemStack(Material.GOLDEN_PICKAXE);
            final var HAMMER_GOLDEN_META = HAMMER_GOLDEN.getItemMeta();
            HAMMER_GOLDEN_META.setCustomModelData(1);
            HAMMER_GOLDEN_META.setLocalizedName("Golden Hammer");
            HAMMER_GOLDEN_META.lore(icepickLore);
            HAMMER_GOLDEN.setItemMeta(HAMMER_GOLDEN_META);

            // Iron crafting ice pick
            final var HAMMER_IRON = new ItemStack(Material.IRON_PICKAXE);
            final var HAMMER_IRON_META = HAMMER_IRON.getItemMeta();
            HAMMER_IRON_META.setCustomModelData(1);
            HAMMER_IRON_META.setLocalizedName("Iron Hammer");
            HAMMER_IRON_META.lore(icepickLore);
            HAMMER_IRON.setItemMeta(HAMMER_IRON_META);

            // Diamond crafting ice pick
            final var HAMMER_DIAMOND = new ItemStack(Material.DIAMOND_PICKAXE);
            final var HAMMER_DIAMOND_META = HAMMER_DIAMOND.getItemMeta();
            HAMMER_DIAMOND_META.setCustomModelData(1);
            HAMMER_DIAMOND_META.setLocalizedName("Diamond Hammer");
            HAMMER_DIAMOND_META.lore(icepickLore);
            HAMMER_DIAMOND.setItemMeta(HAMMER_DIAMOND_META);

            // Netherite crafting ice pick
            final var HAMMER_NETHERITE = new ItemStack(Material.NETHERITE_PICKAXE);
            final var HAMMER_NETHERITE_META = HAMMER_NETHERITE.getItemMeta();
            HAMMER_NETHERITE_META.setCustomModelData(1);
            HAMMER_NETHERITE_META.setLocalizedName("Netherite Hammer");
            HAMMER_NETHERITE_META.lore(icepickLore);
            HAMMER_NETHERITE.setItemMeta(HAMMER_NETHERITE_META);

            //Add all of the materials to the material manager
            putIfAbsent(StratumMaterial.HAMMER_WOODEN.name(), HAMMER_WOODEN);
            putIfAbsent(StratumMaterial.HAMMER_STONE.name(), HAMMER_STONE);
            putIfAbsent(StratumMaterial.HAMMER_GOLDEN.name(), HAMMER_GOLDEN);
            putIfAbsent(StratumMaterial.HAMMER_IRON.name(), HAMMER_IRON);
            putIfAbsent(StratumMaterial.HAMMER_DIAMOND.name(), HAMMER_DIAMOND);
            putIfAbsent(StratumMaterial.HAMMER_NETHERITE.name(), HAMMER_NETHERITE);
        }};
    }
}
