package tech.quilldev.CustomItemsV1;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItemsV1.ItemAttributes.Attribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.OnHitAttribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.ItemAttributes;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnUseAttributes.OnUseAttribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.ToolAttributes.ToolAttribute;
import tech.quilldev.CustomItemsv2.ItemHelpers.ItemNames.ItemAdjectives;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class ItemGenerator {

    //static elements
    private final static Random rand = new Random();

    private final ArrayList<OnHitAttribute> onHitAttributes;
    private final ArrayList<OnUseAttribute> onUseAttributes;
    private final ArrayList<ToolAttribute> toolAttributes;
    private final NamespacedKey levelKey;

    public ItemGenerator(ItemAttributes attributes) {
        this.onHitAttributes = attributes.onHitAttributes;
        this.onUseAttributes = attributes.onUseAttributes;
        this.toolAttributes = attributes.toolAttributes;
        this.levelKey = attributes.levelKey;
    }

    public ItemStack generateItem(ArrayList<Attribute> attributes, int level) {
        //Create the item
        if (attributes.isEmpty()) return null;
        final var mats = attributes.get(0).materials;
        final var material = mats.get(rand.nextInt(mats.size()));
        final var item = new ItemStack(material); //create a new item stack
        final var meta = item.getItemMeta();


        //Generate the name
        final var nameCount = rand.nextInt(2) + 1;
        StringBuilder name = new StringBuilder();
        for (int index = 0; index < nameCount; index++) {
            name.append(ItemAdjectives.adjectives[rand.nextInt(ItemAdjectives.adjectives.length)]).append(" ");
        }
        name.append(item.getI18NDisplayName());
        meta.displayName(Component.text(name.toString()).color(TextColor.color(0xFF5E46)));

        //Start applying attributes
        final var data = meta.getPersistentDataContainer(); //Get the data container
        data.set(levelKey, PersistentDataType.INTEGER, level);

        //Clone the array to one we can safely modify
        var mods = new ArrayList<>(attributes);

        var rarityLore = Component.text("Rarity Level: " + level);

        //Generate lore for the item
        final var loreList = new ArrayList<Component>(Collections.singletonList(rarityLore));

        //Start generating modifiers
        for (var i = 0; i < level; i++) {
            if (mods.isEmpty()) break;
            //Set the key for the given attribute
            final var attr = mods.get(rand.nextInt(mods.size()));
            final var key = attr.key;
            final var multiplier = rand.nextFloat();

            //Ugly way to handle but fuggit, we're getting dirty
            if (PersistentDataType.STRING.equals(attr.dataType)) {
                data.set(key, PersistentDataType.STRING, "TRUE");
            } else if (PersistentDataType.FLOAT.equals(attr.dataType)) {
                data.set(key, PersistentDataType.FLOAT, multiplier);
            } else {
                System.out.println("Unexpected Data Type!");
            }

            //remove the attribute we found from the mod list so we don't get dupes
            mods.remove(attr);

            //Create the lore for the given item
            var modifierLore = attr.displayText
                    .append(
                            (PersistentDataType.FLOAT.equals(attr.dataType) ?
                                    Component.text(":" + Math.round((multiplier * 100)) + "%")
                                    : Component.text("")
                            ));
            loreList.add(modifierLore);
        }

        //Set the lore of the item
        meta.lore(Collections.unmodifiableList(loreList));

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack generateRandomItem(ArrayList<Attribute> attributes, float oddsPerEnemy, float oddsPerRarity) {
        if (oddsPerEnemy < rand.nextFloat()) return null;
        return generateItem(attributes, rollRarityLevel(6, oddsPerRarity));
    }


    public ItemStack generateRandomWeapon(float oddsPerEnemy, float oddsPerRarity) {
        return generateRandomItem(generifyAttributeList(onHitAttributes), oddsPerEnemy, oddsPerRarity);
    }

    public ItemStack generateRandomTool(float oddsPerEnemy, float oddsPerRarity) {
        return generateRandomItem(generifyAttributeList(toolAttributes), oddsPerEnemy, oddsPerRarity);
    }

    private ArrayList<Attribute> generifyAttributeList(ArrayList<?> objects) {
        return objects
                .stream()
                .map(obj -> (Attribute) obj)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private int rollRarityLevel(int maxLevel, float chance) {
        var level = 1;
        for (; rand.nextFloat() < chance; level++) {
            if (level == maxLevel) break;
        }

        return level;
    }
}
