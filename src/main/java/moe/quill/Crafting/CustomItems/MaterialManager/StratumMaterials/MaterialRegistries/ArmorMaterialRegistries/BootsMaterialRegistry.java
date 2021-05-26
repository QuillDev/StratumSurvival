package moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries.ArmorMaterialRegistries;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.BaseArmorAttributes.BaseAttributesBoots;
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

public class BootsMaterialRegistry extends MaterialRegistry {
    public BootsMaterialRegistry() {
        super(MaterialKey.ARMOR_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{

            //LIGHT
            final var BOOTS_LEATHER_LIGHT = new ItemStack(Material.LEATHER_BOOTS);
            final var BOOTS_LEATHER_LIGHT_META = BOOTS_LEATHER_LIGHT.getItemMeta();
            BOOTS_LEATHER_LIGHT_META.displayName(Component.text("Light Leather Boots"));
            BOOTS_LEATHER_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBoots.MOVE_SPEED_LIGHT);
            BOOTS_LEATHER_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesBoots.ARMOR_LEATHER_LIGHT);
            BOOTS_LEATHER_LIGHT.setItemMeta(BOOTS_LEATHER_LIGHT_META);

            final var BOOTS_GOLDEN_LIGHT = new ItemStack(Material.GOLDEN_BOOTS);
            final var BOOTS_GOLDEN_LIGHT_META = BOOTS_GOLDEN_LIGHT.getItemMeta();
            BOOTS_GOLDEN_LIGHT_META.displayName(Component.text("Light Gold Boots"));
            BOOTS_GOLDEN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBoots.MOVE_SPEED_LIGHT);
            BOOTS_GOLDEN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesBoots.ARMOR_GOLDEN_LIGHT);
            BOOTS_GOLDEN_LIGHT.setItemMeta(BOOTS_GOLDEN_LIGHT_META);

            final var BOOTS_CHAIN_LIGHT = new ItemStack(Material.CHAINMAIL_BOOTS);
            final var BOOTS_CHAIN_LIGHT_META = BOOTS_CHAIN_LIGHT.getItemMeta();
            BOOTS_CHAIN_LIGHT_META.displayName(Component.text("Light Chainmail Boots"));
            BOOTS_CHAIN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBoots.MOVE_SPEED_LIGHT);
            BOOTS_CHAIN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesBoots.ARMOR_CHAIN_LIGHT);
            BOOTS_CHAIN_LIGHT.setItemMeta(BOOTS_CHAIN_LIGHT_META);

            final var BOOTS_IRON_LIGHT = new ItemStack(Material.IRON_BOOTS);
            final var BOOTS_IRON_LIGHT_META = BOOTS_IRON_LIGHT.getItemMeta();
            BOOTS_IRON_LIGHT_META.displayName(Component.text("Light Iron Boots"));
            BOOTS_IRON_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBoots.MOVE_SPEED_LIGHT);
            BOOTS_IRON_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesBoots.ARMOR_IRON_LIGHT);
            BOOTS_IRON_LIGHT.setItemMeta(BOOTS_IRON_LIGHT_META);

            final var BOOTS_DIAMOND_LIGHT = new ItemStack(Material.DIAMOND_BOOTS);
            final var BOOTS_DIAMOND_LIGHT_META = BOOTS_DIAMOND_LIGHT.getItemMeta();
            BOOTS_DIAMOND_LIGHT_META.displayName(Component.text("Light Diamond Boots"));
            BOOTS_DIAMOND_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBoots.MOVE_SPEED_LIGHT);
            BOOTS_DIAMOND_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesBoots.ARMOR_DIAMOND_LIGHT);
            BOOTS_DIAMOND_LIGHT.setItemMeta(BOOTS_DIAMOND_LIGHT_META);

            final var BOOTS_NETHERITE_LIGHT = new ItemStack(Material.NETHERITE_BOOTS);
            final var BOOTS_NETHERITE_LIGHT_META = BOOTS_NETHERITE_LIGHT.getItemMeta();
            BOOTS_NETHERITE_LIGHT_META.displayName(Component.text("Light Netherite Boots"));
            BOOTS_NETHERITE_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBoots.MOVE_SPEED_LIGHT);
            BOOTS_NETHERITE_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesBoots.ARMOR_NETHERITE_LIGHT);
            BOOTS_NETHERITE_LIGHT.setItemMeta(BOOTS_NETHERITE_LIGHT_META);

            //HEAVY
            final var BOOTS_LEATHER_HEAVY = new ItemStack(Material.LEATHER_BOOTS);
            final var BOOTS_LEATHER_HEAVY_META = BOOTS_LEATHER_HEAVY.getItemMeta();
            BOOTS_LEATHER_HEAVY_META.displayName(Component.text("Heavy Leather Boots"));
            BOOTS_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBoots.MOVE_SPEED_HEAVY);
            BOOTS_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesBoots.ARMOR_LEATHER_HEAVY);
            BOOTS_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesBoots.HEALTH_LEATHER_HEAVY);
            BOOTS_LEATHER_HEAVY.setItemMeta(BOOTS_LEATHER_HEAVY_META);

            final var BOOTS_GOLDEN_HEAVY = new ItemStack(Material.GOLDEN_BOOTS);
            final var BOOTS_GOLDEN_HEAVY_META = BOOTS_GOLDEN_HEAVY.getItemMeta();
            BOOTS_GOLDEN_HEAVY_META.displayName(Component.text("Heavy Golden Boots"));
            BOOTS_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBoots.MOVE_SPEED_HEAVY);
            BOOTS_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesBoots.ARMOR_GOLDEN_HEAVY);
            BOOTS_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesBoots.HEALTH_GOLD_HEAVY);
            BOOTS_GOLDEN_HEAVY.setItemMeta(BOOTS_GOLDEN_HEAVY_META);

            final var BOOTS_CHAIN_HEAVY = new ItemStack(Material.CHAINMAIL_BOOTS);
            final var BOOTS_CHAIN_HEAVY_META = BOOTS_CHAIN_HEAVY.getItemMeta();
            BOOTS_CHAIN_HEAVY_META.displayName(Component.text("Heavy Chainmail Boots"));
            BOOTS_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBoots.MOVE_SPEED_HEAVY);
            BOOTS_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesBoots.ARMOR_CHAIN_HEAVY);
            BOOTS_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesBoots.HEALTH_CHAIN_HEAVY);
            BOOTS_CHAIN_HEAVY.setItemMeta(BOOTS_CHAIN_HEAVY_META);

            final var BOOTS_IRON_HEAVY = new ItemStack(Material.IRON_BOOTS);
            final var BOOTS_IRON_HEAVY_META = BOOTS_IRON_HEAVY.getItemMeta();
            BOOTS_IRON_HEAVY_META.displayName(Component.text("Heavy Iron Boots"));
            BOOTS_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBoots.MOVE_SPEED_HEAVY);
            BOOTS_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesBoots.ARMOR_IRON_HEAVY);
            BOOTS_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesBoots.HEALTH_IRON_HEAVY);
            BOOTS_IRON_HEAVY.setItemMeta(BOOTS_IRON_HEAVY_META);

            final var BOOTS_DIAMOND_HEAVY = new ItemStack(Material.DIAMOND_BOOTS);
            final var BOOTS_DIAMOND_HEAVY_META = BOOTS_DIAMOND_HEAVY.getItemMeta();
            BOOTS_DIAMOND_HEAVY_META.displayName(Component.text("Heavy Diamond Boots"));
            BOOTS_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBoots.MOVE_SPEED_HEAVY);
            BOOTS_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesBoots.ARMOR_DIAMOND_HEAVY);
            BOOTS_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesBoots.HEALTH_DIAMOND_HEAVY);
            BOOTS_DIAMOND_HEAVY.setItemMeta(BOOTS_DIAMOND_HEAVY_META);

            final var BOOTS_NETHERITE_HEAVY = new ItemStack(Material.NETHERITE_BOOTS);
            final var BOOTS_NETHERITE_HEAVY_META = BOOTS_NETHERITE_HEAVY.getItemMeta();
            BOOTS_NETHERITE_HEAVY_META.displayName(Component.text("Heavy Netherite Boots"));
            BOOTS_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBoots.MOVE_SPEED_HEAVY);
            BOOTS_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesBoots.ARMOR_NETHERITE_HEAVY);
            BOOTS_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesBoots.HEALTH_NETHERITE_HEAVY);
            BOOTS_NETHERITE_HEAVY.setItemMeta(BOOTS_NETHERITE_HEAVY_META);

            //ADDING TO LIST
            put(StratumMaterial.BOOTS_LEATHER_LIGHT.name(), BOOTS_LEATHER_LIGHT);
            put(StratumMaterial.BOOTS_GOLDEN_LIGHT.name(), BOOTS_GOLDEN_LIGHT);
            put(StratumMaterial.BOOTS_CHAIN_LIGHT.name(), BOOTS_CHAIN_LIGHT);
            put(StratumMaterial.BOOTS_IRON_LIGHT.name(), BOOTS_IRON_LIGHT);
            put(StratumMaterial.BOOTS_DIAMOND_LIGHT.name(), BOOTS_DIAMOND_LIGHT);
            put(StratumMaterial.BOOTS_NETHERITE_LIGHT.name(), BOOTS_NETHERITE_LIGHT);

            put(StratumMaterial.BOOTS_LEATHER_HEAVY.name(), BOOTS_LEATHER_HEAVY);
            put(StratumMaterial.BOOTS_GOLDEN_HEAVY.name(), BOOTS_GOLDEN_HEAVY);
            put(StratumMaterial.BOOTS_CHAIN_HEAVY.name(), BOOTS_CHAIN_HEAVY);
            put(StratumMaterial.BOOTS_IRON_HEAVY.name(), BOOTS_IRON_HEAVY);
            put(StratumMaterial.BOOTS_DIAMOND_HEAVY.name(), BOOTS_DIAMOND_HEAVY);
            put(StratumMaterial.BOOTS_NETHERITE_HEAVY.name(), BOOTS_NETHERITE_HEAVY);

        }};
    }
}
