package moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries;

import moe.quill.Crafting.CustomItems.Attributes.ItemAttributes;
import moe.quill.Crafting.CustomItems.ItemHelpers.ItemRarity;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collections;
import java.util.HashMap;

public class FragmentMaterialRegistry extends MaterialRegistry {
    public FragmentMaterialRegistry() {
        super(MaterialKey.FRAGMENT_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{
            final Component fragmentLore = Component.text("Combine 9 of these for a shard!");
            // Setup the common fragment
            final var FRAGMENT_COMMON = new ItemStack(Material.IRON_NUGGET);
            final var FRAGMENT_COMMON_META = FRAGMENT_COMMON.getItemMeta();
            final var FRAGMENT_COMMON_COLOR = ItemRarity.COMMON.getColor();
            FRAGMENT_COMMON_META.setCustomModelData(1);
            FRAGMENT_COMMON_META.displayName(Component.text("Common Fragment").decorate(TextDecoration.BOLD).color(FRAGMENT_COMMON_COLOR));
            FRAGMENT_COMMON_META.lore(Collections.singletonList(fragmentLore.color(FRAGMENT_COMMON_COLOR)));
            FRAGMENT_COMMON_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 1f);
            FRAGMENT_COMMON.setItemMeta(FRAGMENT_COMMON_META);

            //Uncommon crafting fragment
            final var FRAGMENT_UNCOMMON = new ItemStack(Material.IRON_NUGGET);
            final var FRAGMENT_UNCOMMON_META = FRAGMENT_UNCOMMON.getItemMeta();
            final var FRAGMENT_UNCOMMON_COLOR = ItemRarity.UNCOMMON.getColor();
            FRAGMENT_UNCOMMON_META.setCustomModelData(2);
            FRAGMENT_UNCOMMON_META.displayName(Component.text("Uncommon Fragment").decorate(TextDecoration.BOLD).color(FRAGMENT_UNCOMMON_COLOR));
            FRAGMENT_UNCOMMON_META.lore(Collections.singletonList(fragmentLore.color(FRAGMENT_UNCOMMON_COLOR)));
            FRAGMENT_UNCOMMON_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 2f);
            FRAGMENT_UNCOMMON.setItemMeta(FRAGMENT_UNCOMMON_META);

            // Rare crafting fragment
            final var FRAGMENT_RARE = new ItemStack(Material.IRON_NUGGET);
            final var FRAGMENT_RARE_META = FRAGMENT_RARE.getItemMeta();
            final var FRAGMENT_RARE_COLOR = ItemRarity.RARE.getColor();
            FRAGMENT_RARE_META.setCustomModelData(3);
            FRAGMENT_RARE_META.displayName(Component.text("Rare Fragment").decorate(TextDecoration.BOLD).color(FRAGMENT_RARE_COLOR));
            FRAGMENT_RARE_META.lore(Collections.singletonList(fragmentLore.color(FRAGMENT_RARE_COLOR)));
            FRAGMENT_RARE_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 3f);
            FRAGMENT_RARE.setItemMeta(FRAGMENT_RARE_META);

            // Epic crafting fragment
            final var FRAGMENT_EPIC = new ItemStack(Material.IRON_NUGGET);
            final var FRAGMENT_EPIC_META = FRAGMENT_EPIC.getItemMeta();
            final var FRAGMENT_EPIC_COLOR = ItemRarity.EPIC.getColor();
            FRAGMENT_EPIC_META.setCustomModelData(4);
            FRAGMENT_EPIC_META.displayName(Component.text("Epic Fragment").decorate(TextDecoration.BOLD).color(FRAGMENT_EPIC_COLOR));
            FRAGMENT_EPIC_META.lore(Collections.singletonList(fragmentLore.color(FRAGMENT_EPIC_COLOR)));
            FRAGMENT_EPIC_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 4f);
            FRAGMENT_EPIC.setItemMeta(FRAGMENT_EPIC_META);

            // Legendary crafting fragment
            final var FRAGMENT_LEGENDARY = new ItemStack(Material.IRON_NUGGET);
            final var FRAGMENT_LEGENDARY_META = FRAGMENT_LEGENDARY.getItemMeta();
            final var FRAGMENT_LEGENDARY_COLOR = ItemRarity.LEGENDARY.getColor();
            FRAGMENT_LEGENDARY_META.setCustomModelData(5);
            FRAGMENT_LEGENDARY_META.displayName(Component.text("Legendary Fragment").decorate(TextDecoration.BOLD).color(FRAGMENT_LEGENDARY_COLOR));
            FRAGMENT_LEGENDARY_META.lore(Collections.singletonList(fragmentLore.color(FRAGMENT_LEGENDARY_COLOR)));
            FRAGMENT_LEGENDARY_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 5f);
            FRAGMENT_LEGENDARY.setItemMeta(FRAGMENT_LEGENDARY_META);

            //Add all of the materials to the material manager
            putIfAbsent(StratumMaterial.FRAGMENT_COMMON.name(), FRAGMENT_COMMON);
            putIfAbsent(StratumMaterial.FRAGMENT_UNCOMMON.name(), FRAGMENT_UNCOMMON);
            putIfAbsent(StratumMaterial.FRAGMENT_RARE.name(), FRAGMENT_RARE);
            putIfAbsent(StratumMaterial.FRAGMENT_EPIC.name(), FRAGMENT_EPIC);
            putIfAbsent(StratumMaterial.FRAGMENT_LEGENDARY.name(), FRAGMENT_LEGENDARY);
        }};
    }
}
