package moe.quill.stratumsurvival.Adventuring.Loot;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.GlobalKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.stratumsurvival.Expiramental.LevelTool;
import moe.quill.stratumsurvival.StratumSurvival;
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
public class LootManager implements LevelTool {

    private final MaterialManager materialManager;
    private final LootTables lootTables;
    private final ISerializer serializer;

    //NS Keys
    private final NamespacedKey lootChestKey;
    private final NamespacedKey levelKey;

    @Inject
    public LootManager(IKeyManager keyManager, MaterialManager materialManager, LootTables lootTables, ISerializer serializer) {
        this.materialManager = materialManager;
        this.lootTables = lootTables;
        this.lootChestKey = keyManager.getKey(MaterialKey.LOOT_CHEST_KEY);
        this.levelKey = keyManager.getKey(GlobalKey.LEVEL_KEY);
        this.serializer = serializer;
    }

    /**
     * Spawn loot with a random level @ the given location
     *
     * @param location to spawn loot at
     */
    public void spawnLoot(Location location) {
        spawnLoot(location, getRandomLevel(6, .38f));
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
        chestStandData.set(lootChestKey, PersistentDataType.BYTE_ARRAY, serializer.serializeBoolean(true));
        chestStandData.set(levelKey, PersistentDataType.BYTE_ARRAY, serializer.serializeFloat(level));
        chestStand.setAI(false);
        chestStand.setVisible(false);
        chestStand.setArms(false);
        chestStand.setItem(EquipmentSlot.HEAD, getChestForLevel(level));
        chestStand.setGravity(false);
        chestStand.setRotation(location.getYaw(), location.getPitch());
    }

    /**
     * Get the chest item stack for the given level
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
