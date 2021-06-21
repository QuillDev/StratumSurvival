package moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
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

    private static final Logger logger = LoggerFactory.getLogger(MaterialManager.class.getSimpleName());
    private static final Reflections reflections = new Reflections("moe.quill.stratumsurvival");

    private final Plugin plugin;
    private final IKeyManager keyManager;
    private final ISerializer serializer;

    @Inject
    public MaterialManager(Plugin plugin, IKeyManager keyManager, ISerializer serializer) {
        this.plugin = plugin;
        this.keyManager = keyManager;
        this.serializer = serializer;

        System.out.println();
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
                .filter(enemyClass -> !Modifier.isAbstract(enemyClass.getModifiers()))
                .forEach(registryClass -> {
                    try {
                        final var registry = registryClass.getDeclaredConstructor(
                                IKeyManager.class,
                                ISerializer.class
                        ).newInstance(keyManager, serializer);
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

            final var registryMaterials = registry.getMaterials(); //get the material list
            registry.applyMarkerKeys(registryMaterials); //apply the marker keys to each material

            registryMaterials.forEach((key, itm) -> {
                stratumMaterials.putIfAbsent(key, itm);
                logger.info(String.format("Created material -> %s", key));
            }); //add all of them to stratum materials

            //Set that items key for each item in the map
//            registryMaterials.values().forEach(item -> {
//                        final var meta = item.getItemMeta();
//                        final var data = meta.getPersistentDataContainer();
//                        data.set(registryKey, PersistentDataType.BYTE_ARRAY, serializer.serializeBoolean(true));
//                        item.setItemMeta(meta);
//                    }
//            );
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
