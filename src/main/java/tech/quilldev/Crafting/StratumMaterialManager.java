package tech.quilldev.Crafting;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import tech.quilldev.CustomItemsv2.BaseWeaponAttributes.BaseAttributesBattleaxes;
import tech.quilldev.CustomItemsv2.BaseWeaponAttributes.BaseAttributesDaggers;
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.CustomItemsv2.ItemHelpers.ItemRarity;
import tech.quilldev.StratumSurvival;

import java.util.*;


public class StratumMaterialManager {

    private final HashMap<String, ItemStack> stratumMaterials = new HashMap<>();
    private final ArrayList<ItemStack> geodeMaterials = new ArrayList<>();

    //Material Item Keys
    public NamespacedKey crystalKey;
    public NamespacedKey geodeKey;

    public StratumMaterialManager(Plugin plugin) {
        this.crystalKey = new NamespacedKey(plugin, "itemtype_crystal");
        this.geodeKey = new NamespacedKey(plugin, "itemtype_geode");
        registerShards(); //Setup Crafting Shards
        registerBattleaxes(); // Setup Battleaxe items
        registerGeodes(); // Setup Geodes
        registerDaggers(); // Setup daggers
    }

    //TODO: Break these up into different "WeaponRegistry" classes

    /**
     * Setup crafting crystals
     */
    private void registerShards() {
        final Component crystalLore = Component.text("Used for crafting");
        // Setup the common crystal
        final var SHARD_COMMON = new ItemStack(Material.EMERALD);
        final var SHARD_COMMON_META = SHARD_COMMON.getItemMeta();
        final var SHARD_COMMON_COLOR = ItemRarity.COMMON.getColor();
        SHARD_COMMON_META.setCustomModelData(1);
        SHARD_COMMON_META.displayName(Component.text("Common Shard").decorate(TextDecoration.BOLD).color(SHARD_COMMON_COLOR));
        SHARD_COMMON_META.lore(Collections.singletonList(crystalLore.color(SHARD_COMMON_COLOR)));
        SHARD_COMMON_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 1f);
        SHARD_COMMON_META.getPersistentDataContainer().set(crystalKey, PersistentDataType.FLOAT, 1f);
        SHARD_COMMON.setItemMeta(SHARD_COMMON_META);

        //Uncommon crafting crystal
        final var SHARD_UNCOMMON = new ItemStack(Material.EMERALD);
        final var SHARD_UNCOMMON_META = SHARD_UNCOMMON.getItemMeta();
        final var SHARD_UNCOMMON_COLOR = ItemRarity.UNCOMMON.getColor();
        SHARD_UNCOMMON_META.setCustomModelData(2);
        SHARD_UNCOMMON_META.displayName(Component.text("Uncommon Shard").decorate(TextDecoration.BOLD).color(SHARD_UNCOMMON_COLOR));
        SHARD_UNCOMMON_META.lore(Collections.singletonList(crystalLore.color(SHARD_UNCOMMON_COLOR)));
        SHARD_UNCOMMON_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 2f);
        SHARD_UNCOMMON_META.getPersistentDataContainer().set(crystalKey, PersistentDataType.FLOAT, 1f);
        SHARD_UNCOMMON.setItemMeta(SHARD_UNCOMMON_META);

        // Rare crafting crystal
        final var SHARD_RARE = new ItemStack(Material.EMERALD);
        final var SHARD_RARE_META = SHARD_RARE.getItemMeta();
        final var SHARD_RARE_COLOR = ItemRarity.RARE.getColor();
        SHARD_RARE_META.setCustomModelData(3);
        SHARD_RARE_META.displayName(Component.text("Rare Shard").decorate(TextDecoration.BOLD).color(SHARD_RARE_COLOR));
        SHARD_RARE_META.lore(Collections.singletonList(crystalLore.color(SHARD_RARE_COLOR)));
        SHARD_RARE_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 3f);
        SHARD_RARE_META.getPersistentDataContainer().set(crystalKey, PersistentDataType.FLOAT, 1f);
        SHARD_RARE.setItemMeta(SHARD_RARE_META);

        // Epic crafting crystal
        final var SHARD_EPIC = new ItemStack(Material.EMERALD);
        final var SHARD_EPIC_META = SHARD_EPIC.getItemMeta();
        final var SHARD_EPIC_COLOR = ItemRarity.EPIC.getColor();
        SHARD_EPIC_META.setCustomModelData(4);
        SHARD_EPIC_META.displayName(Component.text("Epic Shard").decorate(TextDecoration.BOLD).color(SHARD_EPIC_COLOR));
        SHARD_EPIC_META.lore(Collections.singletonList(crystalLore.color(SHARD_EPIC_COLOR)));
        SHARD_EPIC_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 4f);
        SHARD_EPIC_META.getPersistentDataContainer().set(crystalKey, PersistentDataType.FLOAT, 1f);
        SHARD_EPIC.setItemMeta(SHARD_EPIC_META);

        // Legendary crafting crystal
        final var SHARD_LEGENDARY = new ItemStack(Material.EMERALD);
        final var SHARD_LEGENDARY_META = SHARD_LEGENDARY.getItemMeta();
        final var SHARD_LEGENDARY_COLOR = ItemRarity.LEGENDARY.getColor();
        SHARD_LEGENDARY_META.setCustomModelData(5);
        SHARD_LEGENDARY_META.displayName(Component.text("Legendary Shard").decorate(TextDecoration.BOLD).color(SHARD_LEGENDARY_COLOR));
        SHARD_LEGENDARY_META.lore(Collections.singletonList(crystalLore.color(SHARD_LEGENDARY_COLOR)));
        SHARD_LEGENDARY_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 5f);
        SHARD_LEGENDARY_META.getPersistentDataContainer().set(crystalKey, PersistentDataType.FLOAT, 1f);
        SHARD_LEGENDARY.setItemMeta(SHARD_LEGENDARY_META);

        //Add all of the materials to the material manager
        stratumMaterials.putIfAbsent(StratumMaterial.SHARD_COMMON.name(), SHARD_COMMON);
        stratumMaterials.putIfAbsent(StratumMaterial.SHARD_UNCOMMON.name(), SHARD_UNCOMMON);
        stratumMaterials.putIfAbsent(StratumMaterial.SHARD_RARE.name(), SHARD_RARE);
        stratumMaterials.putIfAbsent(StratumMaterial.SHARD_EPIC.name(), SHARD_EPIC);
        stratumMaterials.putIfAbsent(StratumMaterial.SHARD_LEGENDARY.name(), SHARD_LEGENDARY);

    }

    private void registerGeodes() {

        final var geodeLore = Component.text("Click to reveal item");

        // Setup the common geode
        final var GEODE_COMMON = new ItemStack(Material.FLINT);
        final var GEODE_COMMON_META = GEODE_COMMON.getItemMeta();
        final var GEODE_COMMON_COLOR = ItemRarity.COMMON.getColor();
        GEODE_COMMON_META.setCustomModelData(1);
        GEODE_COMMON_META.displayName(Component.text("Common Geode").decorate(TextDecoration.BOLD).color(GEODE_COMMON_COLOR));
        GEODE_COMMON_META.lore(Collections.singletonList(geodeLore.color(GEODE_COMMON_COLOR)));
        GEODE_COMMON_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 1f);
        GEODE_COMMON_META.getPersistentDataContainer().set(geodeKey, PersistentDataType.FLOAT, 1f);
        GEODE_COMMON.setItemMeta(GEODE_COMMON_META);

        //Uncommon crafting geode
        final var GEODE_UNCOMMON = new ItemStack(Material.FLINT);
        final var GEODE_UNCOMMON_META = GEODE_UNCOMMON.getItemMeta();
        final var GEODE_UNCOMMON_COLOR = ItemRarity.UNCOMMON.getColor();
        GEODE_UNCOMMON_META.setCustomModelData(2);
        GEODE_UNCOMMON_META.displayName(Component.text("Uncommon Geode").decorate(TextDecoration.BOLD).color(GEODE_UNCOMMON_COLOR));
        GEODE_UNCOMMON_META.lore(Collections.singletonList(geodeLore.color(GEODE_UNCOMMON_COLOR)));
        GEODE_UNCOMMON_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 2f);
        GEODE_UNCOMMON_META.getPersistentDataContainer().set(geodeKey, PersistentDataType.FLOAT, 1f);
        GEODE_UNCOMMON.setItemMeta(GEODE_UNCOMMON_META);

        // Rare crafting geode
        final var GEODE_RARE = new ItemStack(Material.FLINT);
        final var GEODE_RARE_META = GEODE_RARE.getItemMeta();
        final var GEODE_RARE_COLOR = ItemRarity.RARE.getColor();
        GEODE_RARE_META.setCustomModelData(3);
        GEODE_RARE_META.displayName(Component.text("Rare Geode").decorate(TextDecoration.BOLD).color(GEODE_RARE_COLOR));
        GEODE_RARE_META.lore(Collections.singletonList(geodeLore.color(GEODE_RARE_COLOR)));
        GEODE_RARE_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 3f);
        GEODE_RARE_META.getPersistentDataContainer().set(geodeKey, PersistentDataType.FLOAT, 1f);
        GEODE_RARE.setItemMeta(GEODE_RARE_META);

        // Epic crafting geode
        final var GEODE_EPIC = new ItemStack(Material.FLINT);
        final var GEODE_EPIC_META = GEODE_EPIC.getItemMeta();
        final var GEODE_EPIC_COLOR = ItemRarity.EPIC.getColor();
        GEODE_EPIC_META.setCustomModelData(4);
        GEODE_EPIC_META.displayName(Component.text("Epic Geode").decorate(TextDecoration.BOLD).color(GEODE_EPIC_COLOR));
        GEODE_EPIC_META.lore(Collections.singletonList(geodeLore.color(GEODE_EPIC_COLOR)));
        GEODE_EPIC_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 4f);
        GEODE_EPIC_META.getPersistentDataContainer().set(geodeKey, PersistentDataType.FLOAT, 1f);
        GEODE_EPIC.setItemMeta(GEODE_EPIC_META);

        // Legendary crafting geode
        final var GEODE_LEGENDARY = new ItemStack(Material.FLINT);
        final var GEODE_LEGENDARY_META = GEODE_LEGENDARY.getItemMeta();
        final var GEODE_LEGENDARY_COLOR = ItemRarity.LEGENDARY.getColor();
        GEODE_LEGENDARY_META.setCustomModelData(5);
        GEODE_LEGENDARY_META.displayName(Component.text("Legendary Geode").decorate(TextDecoration.BOLD).color(GEODE_LEGENDARY_COLOR));
        GEODE_LEGENDARY_META.lore(Collections.singletonList(geodeLore.color(GEODE_LEGENDARY_COLOR)));
        GEODE_LEGENDARY_META.getPersistentDataContainer().set(ItemAttributes.levelKey, PersistentDataType.FLOAT, 5f);
        GEODE_LEGENDARY_META.getPersistentDataContainer().set(geodeKey, PersistentDataType.FLOAT, 1f);
        GEODE_LEGENDARY.setItemMeta(GEODE_LEGENDARY_META);

        //Add all of the materials to the material manager
        stratumMaterials.putIfAbsent(StratumMaterial.GEODE_COMMON.name(), GEODE_COMMON);
        stratumMaterials.putIfAbsent(StratumMaterial.GEODE_UNCOMMON.name(), GEODE_UNCOMMON);
        stratumMaterials.putIfAbsent(StratumMaterial.GEODE_RARE.name(), GEODE_RARE);
        stratumMaterials.putIfAbsent(StratumMaterial.GEODE_EPIC.name(), GEODE_EPIC);
        stratumMaterials.putIfAbsent(StratumMaterial.GEODE_LEGENDARY.name(), GEODE_LEGENDARY);
        geodeMaterials.addAll(
                Arrays.asList(
                        GEODE_COMMON,
                        GEODE_UNCOMMON,
                        GEODE_RARE,
                        GEODE_EPIC,
                        GEODE_LEGENDARY
                )
        );
    }

    private void registerDaggers() {

        //setup wooden battleaxe
        final var DAGGER_WOODEN = new ItemStack(Material.WOODEN_SWORD);
        final var DAGGER_WOODEN_META = DAGGER_WOODEN.getItemMeta();
        DAGGER_WOODEN_META.setCustomModelData(1);
        DAGGER_WOODEN_META.setLocalizedName("Wooden Dagger");
        DAGGER_WOODEN_META.displayName(Component.text(DAGGER_WOODEN_META.getLocalizedName()));
        DAGGER_WOODEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesDaggers.ATTACK_DAMAGE_WOOD);
        DAGGER_WOODEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesDaggers.ATTACK_SPEED);
        DAGGER_WOODEN.setItemMeta(DAGGER_WOODEN_META);

        //setup stone battleaxe
        final var DAGGER_STONE = new ItemStack(Material.STONE_SWORD);
        final var DAGGER_STONE_META = DAGGER_STONE.getItemMeta();
        DAGGER_STONE_META.setCustomModelData(1);
        DAGGER_STONE_META.setLocalizedName("Stone Dagger");
        DAGGER_STONE_META.displayName(Component.text(DAGGER_STONE_META.getLocalizedName()));
        DAGGER_STONE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesDaggers.ATTACK_DAMAGE_STONE);
        DAGGER_STONE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesDaggers.ATTACK_SPEED);
        DAGGER_STONE.setItemMeta(DAGGER_STONE_META);

        //setup iron battleaxe
        final var DAGGER_IRON = new ItemStack(Material.IRON_SWORD);
        final var DAGGER_IRON_META = DAGGER_IRON.getItemMeta();
        DAGGER_IRON_META.setCustomModelData(1);
        DAGGER_IRON_META.setLocalizedName("Iron Dagger");
        DAGGER_IRON_META.displayName(Component.text(DAGGER_IRON_META.getLocalizedName()));
        DAGGER_IRON_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesDaggers.ATTACK_DAMAGE_IRON);
        DAGGER_IRON_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesDaggers.ATTACK_SPEED);
        DAGGER_IRON.setItemMeta(DAGGER_IRON_META);

        //setup golden battleaxe
        final var DAGGER_GOLDEN = new ItemStack(Material.GOLDEN_SWORD);
        final var DAGGER_GOLDEN_META = DAGGER_GOLDEN.getItemMeta();
        DAGGER_GOLDEN_META.setCustomModelData(1);
        DAGGER_GOLDEN_META.setLocalizedName("Golden Dagger");
        DAGGER_GOLDEN_META.displayName(Component.text(DAGGER_GOLDEN_META.getLocalizedName()));
        DAGGER_GOLDEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesDaggers.ATTACK_DAMAGE_GOLD);
        DAGGER_GOLDEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesDaggers.ATTACK_SPEED);
        DAGGER_GOLDEN.setItemMeta(DAGGER_GOLDEN_META);

        //setup diamond battleaxe
        final var DAGGER_DIAMOND = new ItemStack(Material.DIAMOND_SWORD);
        final var DAGGER_DIAMOND_META = DAGGER_DIAMOND.getItemMeta();
        DAGGER_DIAMOND_META.setCustomModelData(1);
        DAGGER_DIAMOND_META.setLocalizedName("Diamond Dagger");
        DAGGER_DIAMOND_META.displayName(Component.text(DAGGER_DIAMOND_META.getLocalizedName()));
        DAGGER_DIAMOND_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesDaggers.ATTACK_DAMAGE_DIAMOND);
        DAGGER_DIAMOND_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesDaggers.ATTACK_SPEED);
        DAGGER_DIAMOND.setItemMeta(DAGGER_DIAMOND_META);

        //setup Netherite battleaxe
        final var DAGGER_NETHERITE = new ItemStack(Material.NETHERITE_SWORD);
        final var DAGGER_NETHERITE_META = DAGGER_NETHERITE.getItemMeta();
        DAGGER_NETHERITE_META.setCustomModelData(1);
        DAGGER_NETHERITE_META.setLocalizedName("Netherite Dagger");
        DAGGER_NETHERITE_META.displayName(Component.text(DAGGER_NETHERITE_META.getLocalizedName()));
        DAGGER_NETHERITE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesDaggers.ATTACK_DAMAGE_NETHERITE);
        DAGGER_NETHERITE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesDaggers.ATTACK_SPEED);
        DAGGER_NETHERITE.setItemMeta(DAGGER_NETHERITE_META);

        //Add battle axes to the stratum material manager
        stratumMaterials.putIfAbsent(StratumMaterial.DAGGER_WOODEN.name(), DAGGER_WOODEN);
        stratumMaterials.putIfAbsent(StratumMaterial.DAGGER_STONE.name(), DAGGER_STONE);
        stratumMaterials.putIfAbsent(StratumMaterial.DAGGER_IRON.name(), DAGGER_IRON);
        stratumMaterials.putIfAbsent(StratumMaterial.DAGGER_GOLDEN.name(), DAGGER_GOLDEN);
        stratumMaterials.putIfAbsent(StratumMaterial.DAGGER_DIAMOND.name(), DAGGER_DIAMOND);
        stratumMaterials.putIfAbsent(StratumMaterial.DAGGER_NETHERITE.name(), DAGGER_NETHERITE);
    }

    private void registerBattleaxes() {

        //setup wooden battleaxe
        final var BATTLEAXE_WOODEN = new ItemStack(Material.WOODEN_AXE);
        final var BATTLEAXE_WOODEN_META = BATTLEAXE_WOODEN.getItemMeta();
        BATTLEAXE_WOODEN_META.setCustomModelData(1);
        BATTLEAXE_WOODEN_META.setLocalizedName("Wooden Battleaxe");
        BATTLEAXE_WOODEN_META.displayName(Component.text(BATTLEAXE_WOODEN_META.getLocalizedName()));
        BATTLEAXE_WOODEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesBattleaxes.ATTACK_DAMAGE_WOOD);
        BATTLEAXE_WOODEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesBattleaxes.ATTACK_SPEED);
        BATTLEAXE_WOODEN.setItemMeta(BATTLEAXE_WOODEN_META);

        //setup stone battleaxe
        final var BATTLEAXE_STONE = new ItemStack(Material.STONE_AXE);
        final var BATTLEAXE_STONE_META = BATTLEAXE_STONE.getItemMeta();
        BATTLEAXE_STONE_META.setCustomModelData(1);
        BATTLEAXE_STONE_META.setLocalizedName("Stone Battleaxe");
        BATTLEAXE_STONE_META.displayName(Component.text(BATTLEAXE_STONE_META.getLocalizedName()));
        BATTLEAXE_STONE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesBattleaxes.ATTACK_DAMAGE_STONE);
        BATTLEAXE_STONE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesBattleaxes.ATTACK_SPEED);
        BATTLEAXE_STONE.setItemMeta(BATTLEAXE_STONE_META);

        //setup iron battleaxe
        final var BATTLEAXE_IRON = new ItemStack(Material.IRON_AXE);
        final var BATTLEAXE_IRON_META = BATTLEAXE_IRON.getItemMeta();
        BATTLEAXE_IRON_META.setCustomModelData(1);
        BATTLEAXE_IRON_META.setLocalizedName("Iron Battleaxe");
        BATTLEAXE_IRON_META.displayName(Component.text(BATTLEAXE_IRON_META.getLocalizedName()));
        BATTLEAXE_IRON_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesBattleaxes.ATTACK_DAMAGE_IRON);
        BATTLEAXE_IRON_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesBattleaxes.ATTACK_SPEED);
        BATTLEAXE_IRON.setItemMeta(BATTLEAXE_IRON_META);

        //setup golden battleaxe
        final var BATTLEAXE_GOLDEN = new ItemStack(Material.GOLDEN_AXE);
        final var BATTLEAXE_GOLDEN_META = BATTLEAXE_GOLDEN.getItemMeta();
        BATTLEAXE_GOLDEN_META.setCustomModelData(1);
        BATTLEAXE_GOLDEN_META.setLocalizedName("Golden Battleaxe");
        BATTLEAXE_GOLDEN_META.displayName(Component.text(BATTLEAXE_GOLDEN_META.getLocalizedName()));
        BATTLEAXE_GOLDEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesBattleaxes.ATTACK_DAMAGE_GOLD);
        BATTLEAXE_GOLDEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesBattleaxes.ATTACK_SPEED);
        BATTLEAXE_GOLDEN.setItemMeta(BATTLEAXE_GOLDEN_META);

        //setup diamond battleaxe
        final var BATTLEAXE_DIAMOND = new ItemStack(Material.DIAMOND_AXE);
        final var BATTLEAXE_DIAMOND_META = BATTLEAXE_DIAMOND.getItemMeta();
        BATTLEAXE_DIAMOND_META.setCustomModelData(1);
        BATTLEAXE_DIAMOND_META.setLocalizedName("Diamond Battleaxe");
        BATTLEAXE_DIAMOND_META.displayName(Component.text(BATTLEAXE_DIAMOND_META.getLocalizedName()));
        BATTLEAXE_DIAMOND_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesBattleaxes.ATTACK_DAMAGE_DIAMOND);
        BATTLEAXE_DIAMOND_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesBattleaxes.ATTACK_SPEED);
        BATTLEAXE_DIAMOND.setItemMeta(BATTLEAXE_DIAMOND_META);

        //setup Netherite battleaxe
        final var BATTLEAXE_NETHERITE = new ItemStack(Material.NETHERITE_AXE);
        final var BATTLEAXE_NETHERITE_META = BATTLEAXE_NETHERITE.getItemMeta();
        BATTLEAXE_NETHERITE_META.setCustomModelData(1);
        BATTLEAXE_NETHERITE_META.setLocalizedName("Netherite Battleaxe");
        BATTLEAXE_NETHERITE_META.displayName(Component.text(BATTLEAXE_NETHERITE_META.getLocalizedName()));
        BATTLEAXE_NETHERITE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesBattleaxes.ATTACK_DAMAGE_NETHERITE);
        BATTLEAXE_NETHERITE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesBattleaxes.ATTACK_SPEED);
        BATTLEAXE_NETHERITE.setItemMeta(BATTLEAXE_NETHERITE_META);

        //Add battle axes to the stratum material manager
        stratumMaterials.putIfAbsent(StratumMaterial.BATTLEAXE_WOODEN.name(), BATTLEAXE_WOODEN);
        stratumMaterials.putIfAbsent(StratumMaterial.BATTLEAXE_STONE.name(), BATTLEAXE_STONE);
        stratumMaterials.putIfAbsent(StratumMaterial.BATTLEAXE_IRON.name(), BATTLEAXE_IRON);
        stratumMaterials.putIfAbsent(StratumMaterial.BATTLEAXE_GOLDEN.name(), BATTLEAXE_GOLDEN);
        stratumMaterials.putIfAbsent(StratumMaterial.BATTLEAXE_DIAMOND.name(), BATTLEAXE_DIAMOND);
        stratumMaterials.putIfAbsent(StratumMaterial.BATTLEAXE_NETHERITE.name(), BATTLEAXE_NETHERITE);
    }

    public ItemStack getItem(StratumMaterial material) {
        return getItem(material.name());
    }

    public ItemStack getItem(Material material) {
        return getItem(material.name());
    }

    public ItemStack getItem(String key) {

        var item = stratumMaterials.get(key);

        //If the item does not exist yet, try to cache it
        if (item == null) {
            final var material = Material.getMaterial(key);

            //Return AIR if no item was found
            if (material == null) {
                return new ItemStack(Material.AIR);
            }
            item = new ItemStack(material);
            stratumMaterials.putIfAbsent(key, item); //Cache the item

            StratumSurvival.log(getClass(), "Cached material " + key);
        }

        if (item.getItemMeta().hasCustomModelData()) {
            System.out.println("SEARCHED FOR " + key + " " + item.getItemMeta().getCustomModelData());
        }

        return item.clone();
    }

    /**
     * Get the crystal corresponding with the given item level
     *
     * @param level to match crystals with
     * @return the crystal matching the given level
     */
    public ItemStack getCrystalForLevel(int level) {
        // Get the corresponding item based on the level
        return switch (level) {
            case 1 -> getItem(StratumMaterial.SHARD_COMMON);
            case 2 -> getItem(StratumMaterial.SHARD_UNCOMMON);
            case 3 -> getItem(StratumMaterial.SHARD_RARE);
            case 4 -> getItem(StratumMaterial.SHARD_EPIC);
            case 5, 6 -> getItem(StratumMaterial.SHARD_LEGENDARY);
            default -> null;
        };
    }

    public ArrayList<ItemStack> getGeodeMaterials() {
        return geodeMaterials;
    }
}
