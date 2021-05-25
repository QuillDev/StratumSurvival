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

public class IcepickRegistry extends MaterialRegistry {
    public IcepickRegistry() {
        super(MaterialKey.ICEPICK_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials(NamespacedKey key) {
        return new HashMap<>() {{
            final var icepickLore = Collections.singletonList(
                    Component.text("Great for breaking the ice!").color(TextColor.color(0x5FA5CB)).asComponent()
            );

            // Setup the common ice pick
            final var ICEPICK_WOODEN = new ItemStack(Material.WOODEN_PICKAXE);
            final var ICEPICK_WOODEN_META = ICEPICK_WOODEN.getItemMeta();
            ICEPICK_WOODEN_META.setCustomModelData(2);
            ICEPICK_WOODEN_META.setLocalizedName("Wooden Ice Pick");
            ICEPICK_WOODEN_META.lore(icepickLore);
            ICEPICK_WOODEN.setItemMeta(ICEPICK_WOODEN_META);
            // Setup the common ice pick
            final var ICEPICK_STONE = new ItemStack(Material.STONE_PICKAXE);
            final var ICEPICK_STONE_META = ICEPICK_STONE.getItemMeta();
            ICEPICK_STONE_META.setCustomModelData(2);
            ICEPICK_STONE_META.setLocalizedName("Stone Ice Pick");
            ICEPICK_STONE_META.lore(icepickLore);
            ICEPICK_STONE.setItemMeta(ICEPICK_STONE_META);

            //Golden crafting ice pick
            final var ICEPICK_GOLDEN = new ItemStack(Material.GOLDEN_PICKAXE);
            final var ICEPICK_GOLDEN_META = ICEPICK_GOLDEN.getItemMeta();
            ICEPICK_GOLDEN_META.setCustomModelData(2);
            ICEPICK_GOLDEN_META.setLocalizedName("Golden Ice Pick");
            ICEPICK_GOLDEN_META.lore(icepickLore);
            ICEPICK_GOLDEN.setItemMeta(ICEPICK_GOLDEN_META);

            // Iron crafting ice pick
            final var ICEPICK_IRON = new ItemStack(Material.IRON_PICKAXE);
            final var ICEPICK_IRON_META = ICEPICK_IRON.getItemMeta();
            ICEPICK_IRON_META.setCustomModelData(2);
            ICEPICK_IRON_META.setLocalizedName("Iron Ice Pick");
            ICEPICK_IRON_META.lore(icepickLore);
            ICEPICK_IRON.setItemMeta(ICEPICK_IRON_META);

            // Diamond crafting ice pick
            final var ICEPICK_DIAMOND = new ItemStack(Material.DIAMOND_PICKAXE);
            final var ICEPICK_DIAMOND_META = ICEPICK_DIAMOND.getItemMeta();
            ICEPICK_DIAMOND_META.setCustomModelData(2);
            ICEPICK_DIAMOND_META.setLocalizedName("Diamond Ice Pick");
            ICEPICK_DIAMOND_META.lore(icepickLore);
            ICEPICK_DIAMOND.setItemMeta(ICEPICK_DIAMOND_META);

            // Netherite crafting ice pick
            final var ICEPICK_NETHERITE = new ItemStack(Material.NETHERITE_PICKAXE);
            final var ICEPICK_NETHERITE_META = ICEPICK_NETHERITE.getItemMeta();
            ICEPICK_NETHERITE_META.setCustomModelData(2);
            ICEPICK_NETHERITE_META.setLocalizedName("Netherite Ice Pick");
            ICEPICK_NETHERITE_META.lore(icepickLore);
            ICEPICK_NETHERITE.setItemMeta(ICEPICK_NETHERITE_META);

            //Add all of the materials to the material manager
            putIfAbsent(StratumMaterial.ICEPICK_WOODEN.name(), ICEPICK_WOODEN);
            putIfAbsent(StratumMaterial.ICEPICK_STONE.name(), ICEPICK_STONE);
            putIfAbsent(StratumMaterial.ICEPICK_GOLDEN.name(), ICEPICK_GOLDEN);
            putIfAbsent(StratumMaterial.ICEPICK_IRON.name(), ICEPICK_IRON);
            putIfAbsent(StratumMaterial.ICEPICK_DIAMOND.name(), ICEPICK_DIAMOND);
            putIfAbsent(StratumMaterial.ICEPICK_NETHERITE.name(), ICEPICK_NETHERITE);

        }};
    }
}
