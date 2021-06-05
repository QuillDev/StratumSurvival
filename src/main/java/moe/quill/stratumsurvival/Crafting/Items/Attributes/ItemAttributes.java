package moe.quill.stratumsurvival.Crafting.Items.Attributes;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes.BluntWeaponAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes.BowWeaponAttributes.BowWeaponAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.ToolAttributes.MiningAttributes.PickaxeAttributes.PickaxeAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.UseSpellAttributes;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemType;
import org.bukkit.inventory.ItemStack;
import org.burningwave.core.assembler.ComponentContainer;
import org.burningwave.core.assembler.ComponentSupplier;
import org.burningwave.core.classes.CacheableSearchConfig;
import org.burningwave.core.classes.ClassCriteria;
import org.burningwave.core.classes.ClassHunter;
import org.burningwave.core.classes.SearchConfig;
import org.burningwave.core.io.PathHelper;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Attr;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

@Singleton
public class ItemAttributes {
    //list of attributes
    private static final ArrayList<Attribute> attributes = new ArrayList<>();
    private static final Reflections reflections = new Reflections("moe.quill.stratumsurvival");
    private static final Logger logger = LoggerFactory.getLogger(ItemAttributes.class.getSimpleName());

    //Attribute categories
    public static final HashMap<String, ItemType> attributeCategories = new HashMap<>();

    private final MaterialManager materialManager;
    private final IKeyManager keyManager;
    private final ISerializer serializer;
    private final ItemLists itemLists;

    @Inject
    public ItemAttributes(
            MaterialManager materialManager,
            IKeyManager keyManager,
            ISerializer serializer,
            ItemLists itemLists
    ) {
        this.materialManager = materialManager;
        this.keyManager = keyManager;
        this.serializer = serializer;
        this.itemLists = itemLists;

        attributeCategories.putIfAbsent("WEAPON_BLUNT", new ItemType(itemLists.getBluntWeapons(), BluntWeaponAttribute.class));
        attributeCategories.putIfAbsent("WEAPON_BOW", new ItemType(itemLists.getBowWeapons(), BowWeaponAttribute.class));
        attributeCategories.putIfAbsent("TOOLS_PICKAXE", new ItemType(itemLists.getPickaxeItems(), PickaxeAttribute.class));
        attributeCategories.putIfAbsent("WEAPON_SPELL", new ItemType(itemLists.getSpellWeapons(), UseSpellAttributes.class));
        dynamicallyLoadAttributes();
    }

    /**
     * Attempt do dynamically load attributes based on their extension from the attribute class
     */
    private void dynamicallyLoadAttributes() {
        reflections
                .getSubTypesOf(Attribute.class)
                .stream()
                .filter(attrClass -> !Modifier.isAbstract(attrClass.getModifiers()))
                .forEach(attrClass -> {
                    try {
                        final var attr = attrClass
                                .getDeclaredConstructor(
                                        MaterialManager.class,
                                        IKeyManager.class,
                                        ISerializer.class,
                                        ItemLists.class
                                )
                                .newInstance(materialManager, keyManager, serializer, itemLists);
                        ItemAttributes.registerAll(attr);
                    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }

    /**
     * Register all of the given attributes to the
     *
     * @param newAttributes the new attributes to add
     */
    public static void registerAll(Attribute... newAttributes) {
        attributes.addAll(Arrays.asList(newAttributes));
        //Log the attributes that we just loaded
        Arrays.stream(newAttributes).forEach(attr -> {
            logger.info(String.format("Loaded attribute %s [key:%s]", attr.getClass().getSimpleName(), attr.key.name()));
        });
    }

    /**
     * Get all attributes of the given class type
     *
     * @param type of attributes to get.
     * @return an arraylist of attributes matching the given type
     */
    public ArrayList<Attribute> getAttributesOfType(Class<?> type) {
        final var attributeList = new ArrayList<Attribute>();
        final var uniqueList = new ArrayList<Attribute>();
        //Get all attributes and their children that are eligible to be added from this class
        attributes.forEach((attr) -> {
            if (!(type.isAssignableFrom(attr.getClass()))) return;
            attributeList.add(attr);
            attr.childAttributes.forEach((child) -> {
                attributeList.addAll(getAttributesOfType(child));
            });
        });

        //Get only unique attributes
        attributeList.forEach(attr -> {
            if (uniqueList.contains(attr)) return;
            uniqueList.add(attr);
        });

        return uniqueList;
    }

    /**
     * Get the attribute with the given key
     *
     * @param query to search for attributes that match it
     * @return a matching attribute
     */
    public static Attribute getAttribute(AttributeKey query) {
        return attributes
                .stream()
                .filter(attr -> attr.key.equals(query))
                .findFirst()
                .orElse(null);
    }

    /**
     * Get the item category matching the given query
     *
     * @param query to match with the category
     * @return the weapon category for the given string
     */
    public ItemType getWeaponCategory(String query) {
        final var key = attributeCategories
                .keySet()
                .stream()
                .filter(weaponKey -> weaponKey.equalsIgnoreCase(query))
                .findFirst()
                .orElse("");
        return attributeCategories.get(key);
    }

    public static ItemType getWeaponTypeFromItemStack(ItemStack queryStack) {

        for (final var key : attributeCategories.keySet()) {
            //Get the current entry
            final var entry = attributeCategories.get(key);

            //Loop through the item list
            for (final var item : entry.itemStacks) {
                //If the item is the same as the query stack, return it
                if (!item.equals(queryStack)) continue;
                return entry;
            }
        }

        //Otherwise return nothing
        return null;
    }
}
