package moe.quill.Adventuring.Loot;

import moe.quill.Crafting.CustomItems.Attributes.ItemAttributes;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import moe.quill.Utils.Serialization.StratumSerialization;
import moe.quill.StratumSurvival;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.Random;

public class LootManager {

    private final StratumMaterialManager materialManager;
    private final NamespacedKey lootChestKey;
    private final LootTables lootTables;
    private static final Random rand = StratumSurvival.rand;

    public LootManager(Plugin plugin, StratumMaterialManager materialManager) {
        this.materialManager = materialManager;
        this.lootChestKey = new NamespacedKey(plugin, "loot_chest_key");
        this.lootTables = new LootTables(materialManager);
        plugin.getServer().getPluginManager().registerEvents(new LootListener(this), plugin);
    }

    /**
     * Spawn loot with a random level @ the given location
     *
     * @param location to spawn loot at
     */
    public void spawnLoot(Location location) {
        spawnLoot(location, getRandomLevel());
    }

    /**
     * Spawn loot with the given level @ the given location
     *
     * @param location to spawn the loot at
     * @param level    of the loot
     */
    public void spawnLoot(Location location, int level) {
        final var spawnLocation = new Location(location.getWorld(), location.getX(), location.getY() - 1.475, location.getZ());
        final var chestStand = (ArmorStand) location.getWorld().spawnEntity(spawnLocation, EntityType.ARMOR_STAND);
        final var chestStandData = chestStand.getPersistentDataContainer();
        chestStandData.set(lootChestKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
        chestStandData.set(ItemAttributes.levelKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeFloat(level));
        chestStand.setAI(false);
        chestStand.setVisible(false);
        chestStand.setArms(false);
        chestStand.setItem(EquipmentSlot.HEAD, getChestForLevel(level));
        chestStand.setGravity(false);
        chestStand.setRotation(location.getYaw(), location.getPitch());
    }

    /**
     * Get a random loot level
     *
     * @return a random loot level
     */
    private int getRandomLevel() {
        int level = 1;
        for (; level < 6; level++) {
            if (.38 < rand.nextFloat()) {
                break;
            }
        }

        return level;
    }

    /**
     * Get the chest itemstack for the given level
     *
     * @param level of the chest
     * @return the chest stack
     */
    public ItemStack getChestForLevel(int level) {
        return switch (level) {
            case 1 -> materialManager.getItem(StratumMaterial.CHEST_COMMON);
            case 2 -> materialManager.getItem(StratumMaterial.CHEST_UNCOMMON);
            case 3 -> materialManager.getItem(StratumMaterial.CHEST_RARE);
            case 4 -> materialManager.getItem(StratumMaterial.CHEST_EPIC);
            case 5, 6 -> materialManager.getItem(StratumMaterial.CHEST_LEGENDARY);
            default -> materialManager.getItem(Material.AIR);
        };
    }

    /**
     * Get the key for loot chests
     *
     * @return the loot chest key
     */
    public NamespacedKey getLootChestKey() {
        return lootChestKey;
    }


    public LootTables getLootTables() {
        return lootTables;
    }
}
