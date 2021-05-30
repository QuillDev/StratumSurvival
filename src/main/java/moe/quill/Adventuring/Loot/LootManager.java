package moe.quill.Adventuring.Loot;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import moe.quill.Crafting.GlobalKey;
import moe.quill.Crafting.Items.Attributes.ItemAttributes;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.KeyManager;

import moe.quill.StratumSurvival;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Random;

@Singleton
public class LootManager {

    private final MaterialManager materialManager;
    private final LootTables lootTables;
    private final Random rand = StratumSurvival.rand;

    //NS Keys
    private final NamespacedKey lootChestKey;
    private final NamespacedKey levelKey;

    @Inject
    public LootManager(KeyManager keyManager, MaterialManager materialManager, LootTables lootTables) {
        this.materialManager = materialManager;
        this.lootTables = lootTables;
        this.lootChestKey = keyManager.getNsKey(MaterialKey.LOOT_CHEST_KEY);
        this.levelKey = keyManager.getNsKey(GlobalKey.LEVEL_KEY);
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
        chestStandData.set(lootChestKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeBoolean(true));
        chestStandData.set(levelKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeFloat(level));
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
