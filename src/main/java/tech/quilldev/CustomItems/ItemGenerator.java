package tech.quilldev.CustomItems;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.ItemAttributes.DamageAttribute.DamageAttribute;
import tech.quilldev.ItemAttributes.ItemAttributes;
import tech.quilldev.ItemAttributes.UseAttribute.UseAttribute;
import tech.quilldev.Names.Names;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ItemGenerator {

    //static elements
    private final static Random rand = new Random();

    //Valid items that can be generated
    private final static ArrayList<Material> mats = new ArrayList<>(Arrays.asList(
            Material.DIAMOND_SWORD,
            Material.IRON_SWORD,
            Material.IRON_AXE,
            Material.WOODEN_AXE,
            Material.WOODEN_SWORD
    ));

    private final ArrayList<DamageAttribute> damageAttributes;
    private final ArrayList<UseAttribute> useAttributes;
    private final NamespacedKey levelKey;

    public ItemGenerator(ItemAttributes attributes) {
        this.damageAttributes = attributes.damageAttributes;
        this.useAttributes = attributes.useAttributes;
        this.levelKey = attributes.levelKey;
    }

    public ItemStack generateRandomItem(float oddsPerEnemy, float oddsPerRarity) {
        if (oddsPerEnemy < rand.nextFloat()) return null;
        //Create the item
        final var material = mats.get(rand.nextInt(mats.size()));
        final var item = new ItemStack(material); //create a new item stack
        final var meta = item.getItemMeta();


        //Generate the name
        final var nameCount = rand.nextInt(2) + 1;
        StringBuilder name = new StringBuilder();
        for (int index = 0; index < nameCount; index++) {
            name.append(Names.adjectives[rand.nextInt(Names.adjectives.length)]).append(" ");
        }
        name.append(item.getI18NDisplayName());
        meta.displayName(Component.text(name.toString()).color(TextColor.color(0xFF5E46)));

        //Start applying attributes
        final var data = meta.getPersistentDataContainer(); //Get the data container
        final var level = rollRarityLevel(6, oddsPerRarity);
        data.set(levelKey, PersistentDataType.INTEGER, level);

        //Clone the array to one we can safely modify
        var mods = new ArrayList<>(damageAttributes);

        var rarityLore = Component.text("Rarity Level: " + level);

        //Generate lore for the item
        final var loreList = new ArrayList<Component>(Collections.singletonList(rarityLore));

        //Start generating modifiers
        for (var i = 0; i < level; i++) {
            //Set the key for the given attribute
            final var attr = mods.get(rand.nextInt(mods.size()));
            final var key = attr.key;
            final var multiplier = rand.nextFloat();
            data.set(key, PersistentDataType.FLOAT, multiplier);

            //remove the attribute we found from the mod list so we don't get dupes
            mods.remove(attr);

            //Create the lore for the given item
            var modifierLore = attr.displayText.append(Component.text(": +" + Math.round((multiplier * 100)) + "%"));
            loreList.add(modifierLore);
        }

        //Set the lore of the item
        meta.lore(Collections.unmodifiableList(loreList));

        item.setItemMeta(meta);

        return item;
    }

    private int rollRarityLevel(int maxLevel, float chance) {
        var level = 1;
        for (; rand.nextFloat() < chance; level++) {
            if (level == maxLevel) break;
        }

        return level;
    }
}
