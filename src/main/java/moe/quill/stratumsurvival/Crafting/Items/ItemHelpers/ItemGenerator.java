package moe.quill.stratumsurvival.Crafting.Items.ItemHelpers;

import com.google.inject.Inject;
import moe.quill.stratumsurvival.Crafting.GlobalKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.Attribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.ItemAttributes;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import moe.quill.stratumsurvival.Crafting.Items.ItemHelpers.ItemNames.ItemAdjectives;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemType;
import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.stratumsurvival.StratumSurvival;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class ItemGenerator {

    private final static Random rand = StratumSurvival.rand;
    private final ItemHelper itemHelper;
    private final IKeyManager keyManager;

    //Keys for generating Items
    private final NamespacedKey levelKey;
    private final NamespacedKey isCustomItemKey;
    private final NamespacedKey cooldownKey;
    private final NamespacedKey nameKey;

    @Inject
    public ItemGenerator(IKeyManager keyManager, ItemHelper itemHelper) {
        this.keyManager = keyManager;
        this.itemHelper = itemHelper;

        //setup keys
        this.levelKey = keyManager.getKey(GlobalKey.LEVEL_KEY);
        this.isCustomItemKey = keyManager.getKey(GlobalKey.IS_CUSTOM_KEY);
        this.cooldownKey = keyManager.getKey(GlobalKey.COOLDOWN_KEY);
        this.nameKey = keyManager.getKey(GlobalKey.NAME_KEY);

    }

    //TODO: Re-add generateItem
    public ItemStack generateItem(ItemStack item, int level) {
        final var weaponType = ItemAttributes.getWeaponTypeFromItemStack(item);
        if (weaponType == null) return null;

        final var attributes = getEligibleAttributes(ItemAttributes.getAttributesOfType(weaponType.type), level);
        final var useAttributes = getUseAttributes(attributes);
        final var meta = item.getItemMeta();
        final var data = meta.getPersistentDataContainer();
        final var lore = new ArrayList<Component>();
        final var rarity = ItemRarity.getRarity(level);

        // Set the name of the item
        final var name = generateRandomItemName(item).color(rarity.getColor());
        meta.displayName(name);
        lore.add(rarity.getName());

        //Add item attributes to the item
        final var maxIndex = Math.min(attributes.size(), level);
        for (var i = 0; (i < maxIndex); i++) {
            final var curAttr = attributes.get(rand.nextInt(attributes.size()));
            final var dataValue = itemHelper.generateDataValue(curAttr, level);
            data.set(keyManager.getKey(curAttr.key), PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeFloat(dataValue));
            lore.add(curAttr.lore.append(Component.text(curAttr.dataFormat(dataValue)))); // add lore to the item
            attributes.remove(curAttr); //remove the attribute we used

            //If the attribute just added was a use attribute, make it so we can't get any more
            if (UseAttribute.class.isAssignableFrom(curAttr.getClass())) {
                data.set(cooldownKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeLong(0L));
                attributes.removeAll(useAttributes);
            }
        }
        data.set(levelKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeFloat(level));
        data.set(nameKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeComponent(name));
        data.set(isCustomItemKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeBoolean(true));
        meta.lore(lore);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Generate a random item from the given weapon type
     *
     * @param itemType to generate from
     * @return the random weapon type
     */
    public ItemStack generateItem(ItemType itemType) {
        return generateItem(itemType, itemHelper.getRandomLevel(.45f, 6));
    }

    /**
     * Generates an item based on the given category
     *
     * @param itemType of attributes to be generated
     * @return an item created from that type
     */
    public ItemStack generateItem(ItemType itemType, int level) {
        final var materials = getMaterialsFromWeaponType(itemType, level);
        System.out.println(materials.size());
        final var mat = materials.get(rand.nextInt(materials.size()));
        //Create the item
        final var item = new ItemStack(mat);
        return generateItem(item, level);
    }

    public ArrayList<ItemStack> getMaterialsFromWeaponType(ItemType itemType, int level) {
        final var attributes = getEligibleAttributes(ItemAttributes.getAttributesOfType(itemType.type), level);
        return getEligibleItems(attributes);
    }


    public Component generateRandomItemName(ItemStack item) {
        final var nameCount = rand.nextInt(2) + 1;
        StringBuilder name = new StringBuilder();
        for (int index = 0; index < nameCount; index++) {
            name.append(ItemAdjectives.adjectives[rand.nextInt(ItemAdjectives.adjectives.length)]).append(" ");
        }
        final var meta = item.getItemMeta();

        if (meta.hasLocalizedName()) {
            name.append(meta.getLocalizedName());
        } else {
            name.append(item.getI18NDisplayName());
        }


        return Component.text(name.toString());
    }

    public ArrayList<Attribute> getEligibleAttributes(ArrayList<Attribute> attributes, int level) {
        return attributes.stream()
                .filter(attr -> level >= attr.getMinLevel())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Get use attributes from the given list
     *
     * @param attributes to get use attributes from
     * @return a list of use attributes
     */
    public ArrayList<Attribute> getUseAttributes(ArrayList<Attribute> attributes) {
        return attributes
                .stream()
                .filter(attr -> UseAttribute.class.isAssignableFrom(attr.getClass()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Generates a completely random item based on no category restraints
     *
     * @return a completely random item
     */
    public ItemStack generateItem() {
        return generateItem(getRandomCategory());
    }

    /**
     * Get a random item category out of the ones that are registered
     *
     * @return the item category that was randomly chosen
     */
    public ItemType getRandomCategory() {
        final var categories = ItemAttributes.attributeCategories;
        final var keys = new ArrayList<>(categories.keySet());
        return categories.get(keys.get(rand.nextInt(keys.size())));
    }

    /**
     * Get a list of eligible materials for the current attribute list
     *
     * @param attributes to get materials from
     * @return a list of eligible materials for those attributes
     */
    public ArrayList<ItemStack> getEligibleItems(ArrayList<Attribute> attributes) {
        final var materialBuffer = new ArrayList<ItemStack>();
        final var uniqueItems = new ArrayList<ItemStack>();
        attributes.forEach(attr -> {
            materialBuffer.addAll(attr.materials);
            final var mats = attr.materials;
        });
        materialBuffer.forEach(material -> {
            if (uniqueItems.contains(material)) return;
            uniqueItems.add(material);
        });

        return uniqueItems;
    }
}
