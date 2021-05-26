package moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries;

import moe.quill.Crafting.Items.Attributes.ItemAttributes;
import moe.quill.Crafting.Items.ItemHelpers.ItemRarity;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collections;
import java.util.HashMap;

public class GeodeMaterialRegistry extends MaterialRegistry {
    public GeodeMaterialRegistry() {
        super(MaterialKey.GEODE_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{
            final var geodeLore = Component.text("Click to reveal item");

            // Setup the common geode
            final var GEODE_COMMON = new ItemStack(Material.FLINT);
            final var GEODE_COMMON_META = GEODE_COMMON.getItemMeta();
            final var GEODE_COMMON_COLOR = ItemRarity.COMMON.getColor();
            GEODE_COMMON_META.setCustomModelData(1);
            GEODE_COMMON_META.displayName(Component.text("Common Geode").decorate(TextDecoration.BOLD).color(GEODE_COMMON_COLOR));
            GEODE_COMMON_META.lore(Collections.singletonList(geodeLore.color(GEODE_COMMON_COLOR)));
            GEODE_COMMON_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 1f);
            GEODE_COMMON.setItemMeta(GEODE_COMMON_META);

            //Uncommon crafting geode
            final var GEODE_UNCOMMON = new ItemStack(Material.FLINT);
            final var GEODE_UNCOMMON_META = GEODE_UNCOMMON.getItemMeta();
            final var GEODE_UNCOMMON_COLOR = ItemRarity.UNCOMMON.getColor();
            GEODE_UNCOMMON_META.setCustomModelData(2);
            GEODE_UNCOMMON_META.displayName(Component.text("Uncommon Geode").decorate(TextDecoration.BOLD).color(GEODE_UNCOMMON_COLOR));
            GEODE_UNCOMMON_META.lore(Collections.singletonList(geodeLore.color(GEODE_UNCOMMON_COLOR)));
            GEODE_UNCOMMON_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 2f);
            GEODE_UNCOMMON.setItemMeta(GEODE_UNCOMMON_META);

            // Rare crafting geode
            final var GEODE_RARE = new ItemStack(Material.FLINT);
            final var GEODE_RARE_META = GEODE_RARE.getItemMeta();
            final var GEODE_RARE_COLOR = ItemRarity.RARE.getColor();
            GEODE_RARE_META.setCustomModelData(3);
            GEODE_RARE_META.displayName(Component.text("Rare Geode").decorate(TextDecoration.BOLD).color(GEODE_RARE_COLOR));
            GEODE_RARE_META.lore(Collections.singletonList(geodeLore.color(GEODE_RARE_COLOR)));
            GEODE_RARE_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 3f);
            GEODE_RARE.setItemMeta(GEODE_RARE_META);

            // Epic crafting geode
            final var GEODE_EPIC = new ItemStack(Material.FLINT);
            final var GEODE_EPIC_META = GEODE_EPIC.getItemMeta();
            final var GEODE_EPIC_COLOR = ItemRarity.EPIC.getColor();
            GEODE_EPIC_META.setCustomModelData(4);
            GEODE_EPIC_META.displayName(Component.text("Epic Geode").decorate(TextDecoration.BOLD).color(GEODE_EPIC_COLOR));
            GEODE_EPIC_META.lore(Collections.singletonList(geodeLore.color(GEODE_EPIC_COLOR)));
            GEODE_EPIC_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 4f);
            GEODE_EPIC.setItemMeta(GEODE_EPIC_META);

            // Legendary crafting geode
            final var GEODE_LEGENDARY = new ItemStack(Material.FLINT);
            final var GEODE_LEGENDARY_META = GEODE_LEGENDARY.getItemMeta();
            final var GEODE_LEGENDARY_COLOR = ItemRarity.LEGENDARY.getColor();
            GEODE_LEGENDARY_META.setCustomModelData(5);
            GEODE_LEGENDARY_META.displayName(Component.text("Legendary Geode").decorate(TextDecoration.BOLD).color(GEODE_LEGENDARY_COLOR));
            GEODE_LEGENDARY_META.lore(Collections.singletonList(geodeLore.color(GEODE_LEGENDARY_COLOR)));
            GEODE_LEGENDARY_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 5f);
            GEODE_LEGENDARY.setItemMeta(GEODE_LEGENDARY_META);

            //Add all of the materials to the material manager
            putIfAbsent(StratumMaterial.GEODE_COMMON.name(), GEODE_COMMON);
            putIfAbsent(StratumMaterial.GEODE_UNCOMMON.name(), GEODE_UNCOMMON);
            putIfAbsent(StratumMaterial.GEODE_RARE.name(), GEODE_RARE);
            putIfAbsent(StratumMaterial.GEODE_EPIC.name(), GEODE_EPIC);
            putIfAbsent(StratumMaterial.GEODE_LEGENDARY.name(), GEODE_LEGENDARY);
        }};
    }
}
