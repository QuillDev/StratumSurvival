package moe.quill.CustomItems.MaterialManager.StratumMaterials;

import moe.quill.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries.*;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries.WeaponMaterialRegistries.BattleaxeMaterialRegistry;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries.WeaponMaterialRegistries.CutlassMaterialRegistry;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries.WeaponMaterialRegistries.DaggerMaterialRegistry;
import moe.quill.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries.WeaponMaterialRegistries.ScytheMaterialRegistry;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class StratumMaterialManager {

    private final HashMap<String, ItemStack> stratumMaterials = new HashMap<>();
    private final ArrayList<ItemStack> geodeMaterials = new ArrayList<>();
    private final HashMap<MaterialKey, NamespacedKey> keyMap = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(StratumMaterialManager.class.getSimpleName());

    public StratumMaterialManager(Plugin plugin) {
        //Register all of the material types
        registerAll(
                //Add weapon types
                new ScytheMaterialRegistry(new NamespacedKey(plugin, MaterialKey.SCYTHE_KEY.value)),
                new BattleaxeMaterialRegistry(new NamespacedKey(plugin, MaterialKey.BATTLEAXE_KEY.value)),
                new DaggerMaterialRegistry(new NamespacedKey(plugin, MaterialKey.DAGGER_KEY.value)),
                new CutlassMaterialRegistry(new NamespacedKey(plugin, MaterialKey.CUTLASS_KEY.value)),

                //Add crafting types
                new GeodeMaterialRegistry(new NamespacedKey(plugin, MaterialKey.GEODE_KEY.value)),
                new FragmentMaterialRegistry(new NamespacedKey(plugin, MaterialKey.FRAGMENT_KEY.value)),
                new ShardMaterialRegistry(new NamespacedKey(plugin, MaterialKey.SHARD_KEY.value)),
                new ChestMaterialRegister(new NamespacedKey(plugin, MaterialKey.CHEST_KEY.value))
        );


        //Populate the geode materials list
        geodeMaterials.addAll(
                Arrays.asList(
                        getItem(StratumMaterial.GEODE_COMMON),
                        getItem(StratumMaterial.GEODE_UNCOMMON),
                        getItem(StratumMaterial.GEODE_RARE),
                        getItem(StratumMaterial.GEODE_EPIC),
                        getItem(StratumMaterial.GEODE_LEGENDARY)
                )
        );
    }

    /**
     * Register all of the given materials to hte material registry
     *
     * @param registries to add to the manager
     */
    public void registerAll(MaterialRegistry... registries) {
        for (final var registry : registries) {
            final var registryMaterials = registry.getMaterials(); //get the material list
            final var registryKey = registry.getItemKey(); //get the key for this list
            registryMaterials.forEach(stratumMaterials::putIfAbsent); //add all of them to stratum materials
            final var materialKey = MaterialKey.getKeyFromValue(registryKey.value()); //get the material key for this keys value
            keyMap.putIfAbsent(materialKey, registryKey); // put the key into the key list
        }
    }

    /**
     * Return the namespaced key matching the given material key
     *
     * @param key to search for
     * @return the matching key
     */
    public NamespacedKey getNamespacedMaterialKey(MaterialKey key) {
        return keyMap.get(key);
    }
    //TODO: register geodes some other way

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

            logger.info("Cached material " + key);
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

    /**
     * Get the crystal corresponding with the given item level
     *
     * @param level to match crystals with
     * @return the crystal matching the given level
     */
    public ItemStack getFragmentForLevel(int level) {
        // Get the corresponding item based on the level
        return switch (level) {
            case 1 -> getItem(StratumMaterial.FRAGMENT_COMMON);
            case 2 -> getItem(StratumMaterial.FRAGMENT_UNCOMMON);
            case 3 -> getItem(StratumMaterial.FRAGMENT_RARE);
            case 4 -> getItem(StratumMaterial.FRAGMENT_EPIC);
            case 5, 6 -> getItem(StratumMaterial.FRAGMENT_LEGENDARY);
            default -> null;
        };
    }

    public ArrayList<ItemStack> getGeodeMaterials() {
        return geodeMaterials;
    }
}
