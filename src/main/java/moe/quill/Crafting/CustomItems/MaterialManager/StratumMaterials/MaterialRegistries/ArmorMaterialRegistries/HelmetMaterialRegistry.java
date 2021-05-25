package moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries.ArmorMaterialRegistries;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.BaseArmorAttributes.BaseAttributesHelmets;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Utils.Serialization.StratumSerialization;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;

public class HelmetMaterialRegistry extends MaterialRegistry {
    public HelmetMaterialRegistry() {
        super(MaterialKey.ARMOR_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials(NamespacedKey itemKey) {
        return new HashMap<>() {{

            //LIGHT
            final var HELMET_LEATHER_LIGHT = new ItemStack(Material.LEATHER_HELMET);
            final var HELMET_LEATHER_LIGHT_META = HELMET_LEATHER_LIGHT.getItemMeta();
            HELMET_LEATHER_LIGHT_META.displayName(Component.text("Light Leather Helmet"));
            HELMET_LEATHER_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_LIGHT);
            HELMET_LEATHER_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_LEATHER_LIGHT);
            HELMET_LEATHER_LIGHT_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            HELMET_LEATHER_LIGHT.setItemMeta(HELMET_LEATHER_LIGHT_META);

            final var HELMET_GOLDEN_LIGHT = new ItemStack(Material.GOLDEN_HELMET);
            final var HELMET_GOLDEN_LIGHT_META = HELMET_GOLDEN_LIGHT.getItemMeta();
            HELMET_GOLDEN_LIGHT_META.displayName(Component.text("Light Gold Helmet"));
            HELMET_GOLDEN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_LIGHT);
            HELMET_GOLDEN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_GOLDEN_LIGHT);
            HELMET_GOLDEN_LIGHT_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            HELMET_GOLDEN_LIGHT.setItemMeta(HELMET_GOLDEN_LIGHT_META);

            final var HELMET_CHAIN_LIGHT = new ItemStack(Material.CHAINMAIL_HELMET);
            final var HELMET_CHAIN_LIGHT_META = HELMET_CHAIN_LIGHT.getItemMeta();
            HELMET_CHAIN_LIGHT_META.displayName(Component.text("Light Chainmail Helmet"));
            HELMET_CHAIN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_LIGHT);
            HELMET_CHAIN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_CHAIN_LIGHT);
            HELMET_CHAIN_LIGHT_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            HELMET_CHAIN_LIGHT.setItemMeta(HELMET_CHAIN_LIGHT_META);

            final var HELMET_IRON_LIGHT = new ItemStack(Material.IRON_HELMET);
            final var HELMET_IRON_LIGHT_META = HELMET_IRON_LIGHT.getItemMeta();
            HELMET_IRON_LIGHT_META.displayName(Component.text("Light Iron Helmet"));
            HELMET_IRON_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_LIGHT);
            HELMET_IRON_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_IRON_LIGHT);
            HELMET_IRON_LIGHT_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            HELMET_IRON_LIGHT.setItemMeta(HELMET_IRON_LIGHT_META);

            final var HELMET_DIAMOND_LIGHT = new ItemStack(Material.DIAMOND_HELMET);
            final var HELMET_DIAMOND_LIGHT_META = HELMET_DIAMOND_LIGHT.getItemMeta();
            HELMET_DIAMOND_LIGHT_META.displayName(Component.text("Light Diamond Helmet"));
            HELMET_DIAMOND_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_LIGHT);
            HELMET_DIAMOND_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_DIAMOND_LIGHT);
            HELMET_DIAMOND_LIGHT_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            HELMET_DIAMOND_LIGHT.setItemMeta(HELMET_DIAMOND_LIGHT_META);

            final var HELMET_NETHERITE_LIGHT = new ItemStack(Material.NETHERITE_HELMET);
            final var HELMET_NETHERITE_LIGHT_META = HELMET_NETHERITE_LIGHT.getItemMeta();
            HELMET_NETHERITE_LIGHT_META.displayName(Component.text("Light Netherite Helmet"));
            HELMET_NETHERITE_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_LIGHT);
            HELMET_NETHERITE_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_NETHERITE_LIGHT);
            HELMET_NETHERITE_LIGHT_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            HELMET_NETHERITE_LIGHT.setItemMeta(HELMET_NETHERITE_LIGHT_META);

            //HEAVY
            final var HELMET_LEATHER_HEAVY = new ItemStack(Material.LEATHER_HELMET);
            final var HELMET_LEATHER_HEAVY_META = HELMET_LEATHER_HEAVY.getItemMeta();
            HELMET_LEATHER_HEAVY_META.displayName(Component.text("Heavy Leather Helmet"));
            HELMET_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_HEAVY);
            HELMET_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_LEATHER_HEAVY);
            HELMET_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_LEATHER_HEAVY);
            HELMET_LEATHER_HEAVY_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            HELMET_LEATHER_HEAVY.setItemMeta(HELMET_LEATHER_HEAVY_META);

            final var HELMET_GOLDEN_HEAVY = new ItemStack(Material.GOLDEN_HELMET);
            final var HELMET_GOLDEN_HEAVY_META = HELMET_GOLDEN_HEAVY.getItemMeta();
            HELMET_GOLDEN_HEAVY_META.displayName(Component.text("Heavy Golden Helmet"));
            HELMET_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_HEAVY);
            HELMET_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_GOLDEN_HEAVY);
            HELMET_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_GOLD_HEAVY);
            HELMET_GOLDEN_HEAVY_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            HELMET_GOLDEN_HEAVY.setItemMeta(HELMET_GOLDEN_HEAVY_META);

            final var HELMET_CHAIN_HEAVY = new ItemStack(Material.CHAINMAIL_HELMET);
            final var HELMET_CHAIN_HEAVY_META = HELMET_CHAIN_HEAVY.getItemMeta();
            HELMET_CHAIN_HEAVY_META.displayName(Component.text("Heavy Chainmail Helmet"));
            HELMET_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_HEAVY);
            HELMET_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_CHAIN_HEAVY);
            HELMET_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_CHAIN_HEAVY);
            HELMET_CHAIN_HEAVY_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            HELMET_CHAIN_HEAVY.setItemMeta(HELMET_CHAIN_HEAVY_META);

            final var HELMET_IRON_HEAVY = new ItemStack(Material.IRON_HELMET);
            final var HELMET_IRON_HEAVY_META = HELMET_IRON_HEAVY.getItemMeta();
            HELMET_IRON_HEAVY_META.displayName(Component.text("Heavy Iron Helmet"));
            HELMET_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_HEAVY);
            HELMET_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_IRON_HEAVY);
            HELMET_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_IRON_HEAVY);
            HELMET_IRON_HEAVY_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            HELMET_IRON_HEAVY.setItemMeta(HELMET_IRON_HEAVY_META);

            final var HELMET_DIAMOND_HEAVY = new ItemStack(Material.DIAMOND_HELMET);
            final var HELMET_DIAMOND_HEAVY_META = HELMET_DIAMOND_HEAVY.getItemMeta();
            HELMET_DIAMOND_HEAVY_META.displayName(Component.text("Heavy Diamond Helmet"));
            HELMET_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_HEAVY);
            HELMET_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_DIAMOND_HEAVY);
            HELMET_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_DIAMOND_HEAVY);
            HELMET_DIAMOND_HEAVY_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            HELMET_DIAMOND_HEAVY.setItemMeta(HELMET_DIAMOND_HEAVY_META);

            final var HELMET_NETHERITE_HEAVY = new ItemStack(Material.NETHERITE_HELMET);
            final var HELMET_NETHERITE_HEAVY_META = HELMET_NETHERITE_HEAVY.getItemMeta();
            HELMET_NETHERITE_HEAVY_META.displayName(Component.text("Heavy Netherite Helmet"));
            HELMET_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_HEAVY);
            HELMET_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_NETHERITE_HEAVY);
            HELMET_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_NETHERITE_HEAVY);
            HELMET_NETHERITE_HEAVY_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            HELMET_NETHERITE_HEAVY.setItemMeta(HELMET_NETHERITE_HEAVY_META);

            //ADDING TO LIST
            put(StratumMaterial.HELMET_LEATHER_LIGHT.name(), HELMET_LEATHER_LIGHT);
            put(StratumMaterial.HELMET_GOLDEN_LIGHT.name(), HELMET_GOLDEN_LIGHT);
            put(StratumMaterial.HELMET_CHAIN_LIGHT.name(), HELMET_CHAIN_LIGHT);
            put(StratumMaterial.HELMET_IRON_LIGHT.name(), HELMET_IRON_LIGHT);
            put(StratumMaterial.HELMET_DIAMOND_LIGHT.name(), HELMET_DIAMOND_LIGHT);
            put(StratumMaterial.HELMET_NETHERITE_LIGHT.name(), HELMET_NETHERITE_LIGHT);

            put(StratumMaterial.HELMET_LEATHER_HEAVY.name(), HELMET_LEATHER_HEAVY);
            put(StratumMaterial.HELMET_GOLDEN_HEAVY.name(), HELMET_GOLDEN_HEAVY);
            put(StratumMaterial.HELMET_CHAIN_HEAVY.name(), HELMET_CHAIN_HEAVY);
            put(StratumMaterial.HELMET_IRON_HEAVY.name(), HELMET_IRON_HEAVY);
            put(StratumMaterial.HELMET_DIAMOND_HEAVY.name(), HELMET_DIAMOND_HEAVY);
            put(StratumMaterial.HELMET_NETHERITE_HEAVY.name(), HELMET_NETHERITE_HEAVY);

        }};
    }
}