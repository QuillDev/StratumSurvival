package tech.quilldev.Crafting;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.CustomItemsv2.ItemHelpers.ItemRarity;

import java.util.Collections;


public class StratumMaterial {

    //Material Item Stacks
    public static ItemStack SHARD_COMMON = null;
    public static ItemStack SHARD_UNCOMMON = null;
    public static ItemStack SHARD_RARE = null;
    public static ItemStack SHARD_EPIC = null;
    public static ItemStack SHARD_LEGENDARY = null;

    public static ItemStack BATTLEAXE_WOODEN = null;
    public static ItemStack BATTLEAXE_STONE = null;
    public static ItemStack BATTLEAXE_IRON = null;
    public static ItemStack BATTLEAXE_GOLDEN = null;
    public static ItemStack BATTLEAXE_DIAMOND = null;
    public static ItemStack BATTLEAXE_NETHERITE = null;

    //Material Item Keys
    public static NamespacedKey crystalKey = null;

    //Material Lore
    private static final Component crystalLore = Component.text("Used for crafting");

    public static void init(Plugin plugin) {
        crystalKey = new NamespacedKey(plugin, "itemtype_crystal");
        setupShards(); //Setup Crafting Shards
        setupBattleaxes(); // Setup Battleaxe items
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
        SHARD_COMMON_META.getPersistentDataContainer().set(crystalKey, PersistentDataType.FLOAT, 1f);
        SHARD_COMMON.setItemMeta(SHARD_COMMON_META);

        //Uncommon crafting crystal
        SHARD_UNCOMMON = new ItemStack(Material.EMERALD);
        final var SHARD_UNCOMMON_META = SHARD_UNCOMMON.getItemMeta();
        final var SHARD_UNCOMMON_COLOR = ItemRarity.UNCOMMON.getColor();
        SHARD_UNCOMMON_META.setCustomModelData(2);
        SHARD_UNCOMMON_META.displayName(Component.text("Uncommon Shard").decorate(TextDecoration.BOLD).color(SHARD_UNCOMMON_COLOR));
        SHARD_UNCOMMON_META.lore(Collections.singletonList(crystalLore.color(SHARD_UNCOMMON_COLOR)));
        SHARD_UNCOMMON_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 2f);
        SHARD_UNCOMMON_META.getPersistentDataContainer().set(crystalKey, PersistentDataType.FLOAT, 1f);
        SHARD_UNCOMMON.setItemMeta(SHARD_UNCOMMON_META);

        // Rare crafting crystal
        SHARD_RARE = new ItemStack(Material.EMERALD);
        final var SHARD_RARE_META = SHARD_RARE.getItemMeta();
        final var SHARD_RARE_COLOR = ItemRarity.RARE.getColor();
        SHARD_RARE_META.setCustomModelData(3);
        SHARD_RARE_META.displayName(Component.text("Rare Shard").decorate(TextDecoration.BOLD).color(SHARD_RARE_COLOR));
        SHARD_RARE_META.lore(Collections.singletonList(crystalLore.color(SHARD_RARE_COLOR)));
        SHARD_RARE_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 3f);
        SHARD_RARE_META.getPersistentDataContainer().set(crystalKey, PersistentDataType.FLOAT, 1f);
        SHARD_RARE.setItemMeta(SHARD_RARE_META);

        // Epic crafting crystal
        SHARD_EPIC = new ItemStack(Material.EMERALD);
        final var SHARD_EPIC_META = SHARD_EPIC.getItemMeta();
        final var SHARD_EPIC_COLOR = ItemRarity.EPIC.getColor();
        SHARD_EPIC_META.setCustomModelData(4);
        SHARD_EPIC_META.displayName(Component.text("Epic Shard").decorate(TextDecoration.BOLD).color(SHARD_EPIC_COLOR));
        SHARD_EPIC_META.lore(Collections.singletonList(crystalLore.color(SHARD_EPIC_COLOR)));
        SHARD_EPIC_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 4f);
        SHARD_EPIC_META.getPersistentDataContainer().set(crystalKey, PersistentDataType.FLOAT, 1f);
        SHARD_EPIC.setItemMeta(SHARD_EPIC_META);

        // Legendary crafting crystal
        SHARD_LEGENDARY = new ItemStack(Material.EMERALD);
        final var SHARD_LEGENDARY_META = SHARD_LEGENDARY.getItemMeta();
        final var SHARD_LEGENDARY_COLOR = ItemRarity.LEGENDARY.getColor();
        SHARD_LEGENDARY_META.setCustomModelData(5);
        SHARD_LEGENDARY_META.displayName(Component.text("Legendary Shard").decorate(TextDecoration.BOLD).color(SHARD_LEGENDARY_COLOR));
        SHARD_LEGENDARY_META.lore(Collections.singletonList(crystalLore.color(SHARD_LEGENDARY_COLOR)));
        SHARD_LEGENDARY_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 5f);
        SHARD_LEGENDARY_META.getPersistentDataContainer().set(crystalKey, PersistentDataType.FLOAT, 1f);
        SHARD_LEGENDARY.setItemMeta(SHARD_LEGENDARY_META);
    }

    private static void setupBattleaxes() {

        //setup wooden battleaxe
        BATTLEAXE_WOODEN = new ItemStack(Material.WOODEN_AXE);
        final var BATTLEAXE_WOODEN_META = BATTLEAXE_WOODEN.getItemMeta();
        BATTLEAXE_WOODEN_META.setCustomModelData(1);
        BATTLEAXE_WOODEN_META.displayName(Component.text("\u00A7fWooden Battleaxe"));
        BATTLEAXE_WOODEN.setItemMeta(BATTLEAXE_WOODEN_META);

        //setup stone battleaxe
        BATTLEAXE_STONE = new ItemStack(Material.STONE_AXE);
        final var BATTLEAXE_STONE_META = BATTLEAXE_STONE.getItemMeta();
        BATTLEAXE_STONE_META.setCustomModelData(1);
        BATTLEAXE_STONE_META.displayName(Component.text("\u00A7fStone Battleaxe"));
        BATTLEAXE_STONE.setItemMeta(BATTLEAXE_STONE_META);

        //setup iron battleaxe
        BATTLEAXE_IRON = new ItemStack(Material.IRON_AXE);
        final var BATTLEAXE_IRON_META = BATTLEAXE_IRON.getItemMeta();
        BATTLEAXE_IRON_META.setCustomModelData(1);
        BATTLEAXE_IRON_META.displayName(Component.text("\u00A7fIron Battleaxe"));
        BATTLEAXE_IRON.setItemMeta(BATTLEAXE_IRON_META);

        //setup golden battleaxe
        BATTLEAXE_GOLDEN = new ItemStack(Material.GOLDEN_AXE);
        final var BATTLEAXE_GOLDEN_META = BATTLEAXE_GOLDEN.getItemMeta();
        BATTLEAXE_GOLDEN_META.setCustomModelData(1);
        BATTLEAXE_GOLDEN_META.displayName(Component.text("\u00A7fGolden Battleaxe"));
        BATTLEAXE_GOLDEN.setItemMeta(BATTLEAXE_GOLDEN_META);

        //setup diamond battleaxe
        BATTLEAXE_DIAMOND = new ItemStack(Material.DIAMOND_AXE);
        final var BATTLEAXE_DIAMOND_META = BATTLEAXE_DIAMOND.getItemMeta();
        BATTLEAXE_DIAMOND_META.setCustomModelData(1);
        BATTLEAXE_DIAMOND_META.displayName(Component.text("\u00A7fDiamond Battleaxe"));
        BATTLEAXE_DIAMOND.setItemMeta(BATTLEAXE_DIAMOND_META);

        //setup netherite battleaxe
        BATTLEAXE_NETHERITE = new ItemStack(Material.NETHERITE_AXE);
        final var BATTLEAXE_NETHERITE_META = BATTLEAXE_NETHERITE.getItemMeta();
        BATTLEAXE_NETHERITE_META.setCustomModelData(1);
        BATTLEAXE_NETHERITE_META.displayName(Component.text("\u00A7fNetherite Battleaxe"));
        BATTLEAXE_NETHERITE.setItemMeta(BATTLEAXE_NETHERITE_META);
    }
}
