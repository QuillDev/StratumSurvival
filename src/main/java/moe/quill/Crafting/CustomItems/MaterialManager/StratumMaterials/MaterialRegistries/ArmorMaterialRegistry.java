package moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.BaseWeaponAttributes.BaseAttributesBoots;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.BaseWeaponAttributes.BaseAttributesHelmets;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.WeaponHelpers.ItemType;
import moe.quill.Utils.Serialization.StratumSerialization;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;

public class ArmorMaterialRegistry extends MaterialRegistry {
    public ArmorMaterialRegistry() {
        super(MaterialKey.ARMOR_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials(NamespacedKey itemKey) {
        return new HashMap<>() {{
            final var HELMET_LEATHER_LIGHT = new ItemStack(Material.LEATHER_HELMET);
            final var HELMET_LEATHER_LIGHT_META = HELMET_LEATHER_LIGHT.getItemMeta();
            HELMET_LEATHER_LIGHT_META.displayName(Component.text("Light Leather Helmet"));
            HELMET_LEATHER_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_LIGHT);
            HELMET_LEATHER_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_LIGHT);
            HELMET_LEATHER_LIGHT_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            HELMET_LEATHER_LIGHT.setItemMeta(HELMET_LEATHER_LIGHT_META);

            final var HELMET_LEATHER_HEAVY = new ItemStack(Material.LEATHER_HELMET);
            final var HELMET_LEATHER_HEAVY_META = HELMET_LEATHER_HEAVY.getItemMeta();
            HELMET_LEATHER_HEAVY_META.displayName(Component.text("Heavy Leather Helmet"));
            HELMET_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_LIGHT);
            HELMET_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_LIGHT);
            HELMET_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_HEAVY);
            HELMET_LEATHER_HEAVY_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            HELMET_LEATHER_HEAVY.setItemMeta(HELMET_LEATHER_HEAVY_META);

            final var BOOTS_LEATHER_LIGHT = new ItemStack(Material.LEATHER_BOOTS);
            final var BOOTS_LEATHER_LIGHT_META = BOOTS_LEATHER_LIGHT.getItemMeta();
            BOOTS_LEATHER_LIGHT_META.displayName(Component.text("Light Leather Boots"));
            BOOTS_LEATHER_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBoots.MOVE_SPEED_LIGHT);
            BOOTS_LEATHER_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesBoots.ARMOR_LIGHT);
            BOOTS_LEATHER_LIGHT_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            BOOTS_LEATHER_LIGHT.setItemMeta(BOOTS_LEATHER_LIGHT_META);

            final var BOOTS_LEATHER_HEAVY = new ItemStack(Material.LEATHER_BOOTS);
            final var BOOTS_LEATHER_HEAVY_META = BOOTS_LEATHER_HEAVY.getItemMeta();
            BOOTS_LEATHER_HEAVY_META.displayName(Component.text("Heavy Leather Boots"));
            BOOTS_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBoots.MOVE_SPEED_LIGHT);
            BOOTS_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesBoots.ARMOR_LIGHT);
            BOOTS_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesBoots.HEALTH_HEAVY);
            BOOTS_LEATHER_HEAVY_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            BOOTS_LEATHER_HEAVY.setItemMeta(BOOTS_LEATHER_HEAVY_META);

            put(StratumMaterial.HELMET_LEATHER_LIGHT.name(), HELMET_LEATHER_LIGHT);
            put(StratumMaterial.HELMET_LEATHER_HEAVY.name(), HELMET_LEATHER_HEAVY);
            put(StratumMaterial.BOOTS_LEATHER_LIGHT.name(), BOOTS_LEATHER_LIGHT);
            put(StratumMaterial.BOOTS_LEATHER_HEAVY.name(), BOOTS_LEATHER_HEAVY);
        }};
    }
}
