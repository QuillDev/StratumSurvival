package moe.quill.Crafting.Items.ItemHelpers;

import moe.quill.Crafting.GlobalKey;
import moe.quill.Crafting.Items.Attributes.Attribute;
import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.Attributes.ItemAttributes;
import moe.quill.Crafting.KeyManager;
import moe.quill.StratumSurvival;
import moe.quill.Utils.KeyUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ItemHelper {

    private static final Random rand = StratumSurvival.rand;

    private final KeyManager keyManager;

    //Keys we'll be working with
    private final NamespacedKey levelKey;
    private final NamespacedKey obfuscatedKey;
    private final NamespacedKey nameKey;

    public ItemHelper(KeyManager keyManager) {
        this.keyManager = keyManager;
        this.levelKey = keyManager.getNsKey(GlobalKey.LEVEL_KEY);
        this.obfuscatedKey = keyManager.getNsKey(GlobalKey.OBFUSCATED_KEY);
        this.nameKey = keyManager.getNsKey(GlobalKey.NAME_KEY);
    }

    /**
     * Re-roll the stats on the given item
     *
     * @param item to re-roll stats on
     */
    public void reRollItem(ItemStack item) {
        final var meta = item.getItemMeta();
        final var data = meta.getPersistentDataContainer();
        data.getKeys().forEach((key) -> {
            final var attr = ItemAttributes.getAttribute(KeyUtils.getAttributeKey(AttributeKey.class, key));
            if (attr == null) return;

            //Get the level of the item
            final var levelBytes = data.get(levelKey, PersistentDataType.BYTE_ARRAY);
            var level = (int) StratumSurvival.serializer.deserializeFloat(levelBytes);

            //Get the data and set each key with new values
            final var dataValue = generateDataValue(attr, level);
            data.set(keyManager.getNsKey(attr.key), PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeFloat(dataValue));
            setLoreFromItemKeys(meta);
            item.setItemMeta(meta);
        });
    }

    /**
     * Generate a valid data value using the level of the item and the attribute
     *
     * @param attribute to generate values for
     * @param level     of the attribute
     * @return a valid value for that item
     */
    public float generateDataValue(Attribute attribute, int level) {
        final var tempMax = attribute.scaleValue * level;
        final var min = attribute.minRoll;
        final var max = attribute.maxRoll;
        return (float) Math.min(Math.max((Math.random() * tempMax - min) + min, min), max);
    }

    /**
     * Get a random level for the item
     *
     * @return the level for the item
     */
    public int getRandomLevel(float levelRate, float maxLevel) {
        var level = 1;
        for (; level < maxLevel; level++) {
            if (levelRate < rand.nextFloat()) return level;
        }
        return level;
    }

    /**
     * Set lore of the item from the keys on that item
     *
     * @param meta of the item to set the lore of
     */
    public void setLoreFromItemKeys(ItemMeta meta) {

        final var data = meta.getPersistentDataContainer();
        if (data.getKeys().size() == 0) return;
        final var lore = new ArrayList<Component>();
        final var level = (int) StratumSurvival.serializer.deserializeFloat(data.get(levelKey, PersistentDataType.BYTE_ARRAY));
        lore.add(ItemRarity.getRarity(level).getName());
        for (final var key : data.getKeys()) {
            final var attr = ItemAttributes.getAttribute(KeyUtils.getAttributeKey(AttributeKey.class, key));
            if (attr == null) continue;
            //Get the value off of the item for the given attribute
            final var valueBytes = data.get(keyManager.getNsKey(attr.key), PersistentDataType.BYTE_ARRAY);
            final var value = StratumSurvival.serializer.deserializeFloat(valueBytes);
            if (Float.isNaN(value)) continue;
            lore.add(attr.lore.append(Component.text(attr.dataFormat(value))));
        }

        //TODO: FIND A COOL WAY TO DO THIS MAYBE
//        If the item already has lore, then merge the lore
//        if (meta.hasLore()) {
//            final var tempLoreList = meta.lore();
//            if (tempLoreList != null) {
//                tempLoreList.addAll(lore);
//                meta.lore(tempLoreList);
//                return;
//            }
//        }
        meta.lore(lore);
    }

    /**
     * Decrypt the given item and re-enable the attributes on it
     *
     * @param itemStack to decrypt
     */
    public void decryptItem(ItemStack itemStack) {
        //Get the meta from the item
        final var meta = itemStack.getItemMeta();
        setLoreFromItemKeys(meta);

        //Set the data on the item from the data keys
        final var data = meta.getPersistentDataContainer();
        if (data.getKeys().size() == 0) return;
        data.remove(obfuscatedKey);
        if (data.has(nameKey, PersistentDataType.BYTE_ARRAY)) {
            final var nameBytes = data.get(nameKey, PersistentDataType.BYTE_ARRAY);
            final var name = StratumSurvival.serializer.deserializeComponent(nameBytes);
            meta.displayName(name);
        }
        itemStack.setItemMeta(meta);
    }

    /**
     * Encrypt the given item hiding the name/lore and disabling all item keys
     *
     * @param itemStack to encrypt
     */
    public void encryptItem(ItemStack itemStack) {
        final var meta = itemStack.getItemMeta();
        meta.lore(Collections.singletonList(Component.text("????????").decorate(TextDecoration.OBFUSCATED)));
        meta.displayName(Component.text("?????????").decorate(TextDecoration.OBFUSCATED));
        final var data = meta.getPersistentDataContainer();
        data.set(obfuscatedKey, PersistentDataType.BYTE_ARRAY, StratumSurvival.serializer.serializeBoolean(true));
        itemStack.setItemMeta(meta);
    }

    /**
     * Get the first inventory item that matches the given item
     *
     * @param inventory to find first match in
     * @param itemQuery item to compare with the base item
     * @return the matching item if it's not null
     */
    public ItemStack getFirstInventoryMatch(Inventory inventory, ItemStack itemQuery) {
        final var items = inventory.getContents();
        for (final var item : items) {
            if (item == null) continue;
            final var itemClone = item.clone();
            itemClone.setAmount(itemQuery.getAmount());

            if (!(itemClone.equals(itemQuery))) continue;
            return item;
        }

        return null;
    }

    public ItemStack setCraftFormatting(ItemStack itemStack) {
        final var meta = itemStack.getItemMeta();
        meta.displayName(Component.text("\u00A7f" + meta.getLocalizedName()));
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
