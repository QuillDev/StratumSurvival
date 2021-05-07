package tech.quilldev.Crafting;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.CustomItemsv2.ItemGenerator.ItemRarity;

import java.util.Collections;


public class StratumMaterial {

    public static ItemStack SHARD_COMMON = null;
    public static ItemStack SHARD_UNCOMMON = null;
    public static ItemStack SHARD_RARE = null;
    public static ItemStack SHARD_EPIC = null;
    public static ItemStack SHARD_LEGENDARY = null;

    private static final Component crystalLore = Component.text("Used for common crafting");

    public static void init() {
        setupShards(); //Setup Crafting Shards
    }

    /**
     * Setup crafting crystals
     */
    private static void setupShards() {
        // Setup the common crystal
        SHARD_COMMON = new ItemStack(Material.EMERALD);
        final var SHARD_COMMON_META = SHARD_COMMON.getItemMeta();
        final var SHARD_COMMON_COLOR = ItemRarity.COMMON.getColor();
        SHARD_COMMON_META.setCustomModelData(1);
        SHARD_COMMON_META.displayName(Component.text("Common Shard").decorate(TextDecoration.BOLD).color(SHARD_COMMON_COLOR));
        SHARD_COMMON_META.lore(Collections.singletonList(crystalLore.color(SHARD_COMMON_COLOR)));
        SHARD_COMMON_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 1f);
        SHARD_COMMON.setItemMeta(SHARD_COMMON_META);

        //Uncommon crafting crystal
        SHARD_UNCOMMON = new ItemStack(Material.EMERALD);
        final var SHARD_UNCOMMON_META = SHARD_UNCOMMON.getItemMeta();
        final var SHARD_UNCOMMON_COLOR = ItemRarity.UNCOMMON.getColor();
        SHARD_UNCOMMON_META.setCustomModelData(2);
        SHARD_UNCOMMON_META.displayName(Component.text("Uncommon Shard").decorate(TextDecoration.BOLD).color(SHARD_UNCOMMON_COLOR));
        SHARD_UNCOMMON_META.lore(Collections.singletonList(crystalLore.color(SHARD_UNCOMMON_COLOR)));
        SHARD_UNCOMMON_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 2f);
        SHARD_UNCOMMON.setItemMeta(SHARD_UNCOMMON_META);

        // Rare crafting crystal
        SHARD_RARE = new ItemStack(Material.EMERALD);
        final var SHARD_RARE_META = SHARD_RARE.getItemMeta();
        final var SHARD_RARE_COLOR = ItemRarity.RARE.getColor();
        SHARD_RARE_META.setCustomModelData(3);
        SHARD_RARE_META.displayName(Component.text("Rare Shard").decorate(TextDecoration.BOLD).color(SHARD_RARE_COLOR));
        SHARD_RARE_META.lore(Collections.singletonList(crystalLore.color(SHARD_RARE_COLOR)));
        SHARD_RARE_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 3f);
        SHARD_RARE.setItemMeta(SHARD_RARE_META);

        // Epic crafting crystal
        SHARD_EPIC = new ItemStack(Material.EMERALD);
        final var SHARD_EPIC_META = SHARD_EPIC.getItemMeta();
        final var SHARD_EPIC_COLOR = ItemRarity.EPIC.getColor();
        SHARD_EPIC_META.setCustomModelData(4);
        SHARD_EPIC_META.displayName(Component.text("Epic Shard").decorate(TextDecoration.BOLD).color(SHARD_EPIC_COLOR));
        SHARD_EPIC_META.lore(Collections.singletonList(crystalLore.color(SHARD_EPIC_COLOR)));
        SHARD_EPIC_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 4f);
        SHARD_EPIC.setItemMeta(SHARD_EPIC_META);

        // Legendary crafting crystal
        SHARD_LEGENDARY = new ItemStack(Material.EMERALD);
        final var SHARD_LEGENDARY_META = SHARD_LEGENDARY.getItemMeta();
        final var SHARD_LEGENDARY_COLOR = ItemRarity.LEGENDARY.getColor();
        SHARD_LEGENDARY_META.setCustomModelData(5);
        SHARD_LEGENDARY_META.displayName(Component.text("Legendary Shard").decorate(TextDecoration.BOLD).color(SHARD_LEGENDARY_COLOR));
        SHARD_LEGENDARY_META.lore(Collections.singletonList(crystalLore.color(SHARD_LEGENDARY_COLOR)));
        SHARD_LEGENDARY_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 5f);
        SHARD_LEGENDARY.setItemMeta(SHARD_LEGENDARY_META);
    }
}
