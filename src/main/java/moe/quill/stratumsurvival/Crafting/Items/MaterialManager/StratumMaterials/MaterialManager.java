package moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.stratumsurvival.Crafting.KeyManager;
import moe.quill.stratumsurvival.StratumSurvival;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Singleton
public class MaterialManager {

    private final HashMap<String, ItemStack> stratumMaterials = new HashMap<>();
    private final ArrayList<ItemStack> geodeMaterials = new ArrayList<>();
    private static final Reflections reflections = new Reflections("moe.quill.stratumsurvival");
    private static final Logger logger = LoggerFactory.getLogger(MaterialManager.class.getSimpleName());

    private final Plugin plugin;
    private final KeyManager keyManager;

    @Inject
    public MaterialManager(Plugin plugin, KeyManager keyManager) {
        this.plugin = plugin;
        this.keyManager = keyManager;

        //Register all of the material types
        registerMaterialsDynamically();

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
     * Dynamically register materials using reflection
     */
    public void registerMaterialsDynamically() {
        reflections
                .getSubTypesOf(MaterialRegistry.class)
                .stream()
                .filter(registryClass -> !Modifier.isAbstract(registryClass.getModifiers()))
                .forEach(registryClass -> {
                    try {
                        final var registry = registryClass.getDeclaredConstructor(KeyManager.class).newInstance(keyManager);
                        registerAll(registry);
                    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }

    /**
     * Register all of the given materials to hte material registry
     *
     * @param registries to add to the manager
     */
    public void registerAll(MaterialRegistry... registries) {
        for (final var registry : registries) {

            final var registryKey = new NamespacedKey(plugin, registry.getMaterialKey().name());
            final var materialKey = registry.getMaterialKey();
            final var registryMaterials = registry.getMaterials(); //get the material list
            registryMaterials.forEach(stratumMaterials::putIfAbsent); //add all of them to stratum materials

            //Set that items key for each item in the map
            registryMaterials.values().forEach(item -> {
                        final var meta = item.getItemMeta();
                        final var data = meta.getPersistentDataContainer();
                        data.set(registryKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeBoolean(true));
                        item.setItemMeta(meta);
                    }
            );
        }
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

    public HashMap<String, ItemStack> getStratumMaterials() {
        return stratumMaterials;
    }
}
