package moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.ArmorMaterialRegistries;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.BaseArmorAttributes.BaseAttributesLeggings;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class LeggingsMaterialRegistry extends MaterialRegistry {
    public LeggingsMaterialRegistry(KeyManager keyManager) {
        super(keyManager, MaterialKey.ARMOR_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{

            //LIGHT
            final var LEGGINGS_LEATHER_LIGHT = new ItemStack(Material.LEATHER_LEGGINGS);
            final var LEGGINGS_LEATHER_LIGHT_META = LEGGINGS_LEATHER_LIGHT.getItemMeta();
            LEGGINGS_LEATHER_LIGHT_META.displayName(Component.text("Light Leather Leggings"));
            LEGGINGS_LEATHER_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_LIGHT);
            LEGGINGS_LEATHER_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_LEATHER_LIGHT);
            LEGGINGS_LEATHER_LIGHT.setItemMeta(LEGGINGS_LEATHER_LIGHT_META);

            final var LEGGINGS_GOLDEN_LIGHT = new ItemStack(Material.GOLDEN_LEGGINGS);
            final var LEGGINGS_GOLDEN_LIGHT_META = LEGGINGS_GOLDEN_LIGHT.getItemMeta();
            LEGGINGS_GOLDEN_LIGHT_META.displayName(Component.text("Light Gold Leggings"));
            LEGGINGS_GOLDEN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_LIGHT);
            LEGGINGS_GOLDEN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_GOLDEN_LIGHT);
            LEGGINGS_GOLDEN_LIGHT.setItemMeta(LEGGINGS_GOLDEN_LIGHT_META);

            final var LEGGINGS_CHAIN_LIGHT = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            final var LEGGINGS_CHAIN_LIGHT_META = LEGGINGS_CHAIN_LIGHT.getItemMeta();
            LEGGINGS_CHAIN_LIGHT_META.displayName(Component.text("Light Chainmail Leggings"));
            LEGGINGS_CHAIN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_LIGHT);
            LEGGINGS_CHAIN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_CHAIN_LIGHT);
            LEGGINGS_CHAIN_LIGHT.setItemMeta(LEGGINGS_CHAIN_LIGHT_META);

            final var LEGGINGS_IRON_LIGHT = new ItemStack(Material.IRON_LEGGINGS);
            final var LEGGINGS_IRON_LIGHT_META = LEGGINGS_IRON_LIGHT.getItemMeta();
            LEGGINGS_IRON_LIGHT_META.displayName(Component.text("Light Iron Leggings"));
            LEGGINGS_IRON_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_LIGHT);
            LEGGINGS_IRON_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_IRON_LIGHT);
            LEGGINGS_IRON_LIGHT.setItemMeta(LEGGINGS_IRON_LIGHT_META);

            final var LEGGINGS_DIAMOND_LIGHT = new ItemStack(Material.DIAMOND_LEGGINGS);
            final var LEGGINGS_DIAMOND_LIGHT_META = LEGGINGS_DIAMOND_LIGHT.getItemMeta();
            LEGGINGS_DIAMOND_LIGHT_META.displayName(Component.text("Light Diamond Leggings"));
            LEGGINGS_DIAMOND_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_LIGHT);
            LEGGINGS_DIAMOND_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_DIAMOND_LIGHT);
            LEGGINGS_DIAMOND_LIGHT.setItemMeta(LEGGINGS_DIAMOND_LIGHT_META);

            final var LEGGINGS_NETHERITE_LIGHT = new ItemStack(Material.NETHERITE_LEGGINGS);
            final var LEGGINGS_NETHERITE_LIGHT_META = LEGGINGS_NETHERITE_LIGHT.getItemMeta();
            LEGGINGS_NETHERITE_LIGHT_META.displayName(Component.text("Light Netherite Leggings"));
            LEGGINGS_NETHERITE_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_LIGHT);
            LEGGINGS_NETHERITE_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_NETHERITE_LIGHT);
            LEGGINGS_NETHERITE_LIGHT.setItemMeta(LEGGINGS_NETHERITE_LIGHT_META);

            //HEAVY
            final var LEGGINGS_LEATHER_HEAVY = new ItemStack(Material.LEATHER_LEGGINGS);
            final var LEGGINGS_LEATHER_HEAVY_META = LEGGINGS_LEATHER_HEAVY.getItemMeta();
            LEGGINGS_LEATHER_HEAVY_META.displayName(Component.text("Heavy Leather Leggings"));
            LEGGINGS_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_HEAVY);
            LEGGINGS_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_LEATHER_HEAVY);
            LEGGINGS_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesLeggings.HEALTH_LEATHER_HEAVY);
            LEGGINGS_LEATHER_HEAVY.setItemMeta(LEGGINGS_LEATHER_HEAVY_META);

            final var LEGGINGS_GOLDEN_HEAVY = new ItemStack(Material.GOLDEN_LEGGINGS);
            final var LEGGINGS_GOLDEN_HEAVY_META = LEGGINGS_GOLDEN_HEAVY.getItemMeta();
            LEGGINGS_GOLDEN_HEAVY_META.displayName(Component.text("Heavy Golden Leggings"));
            LEGGINGS_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_HEAVY);
            LEGGINGS_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_GOLDEN_HEAVY);
            LEGGINGS_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesLeggings.HEALTH_GOLD_HEAVY);
            LEGGINGS_GOLDEN_HEAVY.setItemMeta(LEGGINGS_GOLDEN_HEAVY_META);

            final var LEGGINGS_CHAIN_HEAVY = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            final var LEGGINGS_CHAIN_HEAVY_META = LEGGINGS_CHAIN_HEAVY.getItemMeta();
            LEGGINGS_CHAIN_HEAVY_META.displayName(Component.text("Heavy Chainmail Leggings"));
            LEGGINGS_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_HEAVY);
            LEGGINGS_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_CHAIN_HEAVY);
            LEGGINGS_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesLeggings.HEALTH_CHAIN_HEAVY);
            LEGGINGS_CHAIN_HEAVY.setItemMeta(LEGGINGS_CHAIN_HEAVY_META);

            final var LEGGINGS_IRON_HEAVY = new ItemStack(Material.IRON_LEGGINGS);
            final var LEGGINGS_IRON_HEAVY_META = LEGGINGS_IRON_HEAVY.getItemMeta();
            LEGGINGS_IRON_HEAVY_META.displayName(Component.text("Heavy Iron Leggings"));
            LEGGINGS_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_HEAVY);
            LEGGINGS_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_IRON_HEAVY);
            LEGGINGS_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesLeggings.HEALTH_IRON_HEAVY);
            LEGGINGS_IRON_HEAVY.setItemMeta(LEGGINGS_IRON_HEAVY_META);

            final var LEGGINGS_DIAMOND_HEAVY = new ItemStack(Material.DIAMOND_LEGGINGS);
            final var LEGGINGS_DIAMOND_HEAVY_META = LEGGINGS_DIAMOND_HEAVY.getItemMeta();
            LEGGINGS_DIAMOND_HEAVY_META.displayName(Component.text("Heavy Diamond Leggings"));
            LEGGINGS_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_HEAVY);
            LEGGINGS_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_DIAMOND_HEAVY);
            LEGGINGS_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesLeggings.HEALTH_DIAMOND_HEAVY);
            LEGGINGS_DIAMOND_HEAVY.setItemMeta(LEGGINGS_DIAMOND_HEAVY_META);

            final var LEGGINGS_NETHERITE_HEAVY = new ItemStack(Material.NETHERITE_LEGGINGS);
            final var LEGGINGS_NETHERITE_HEAVY_META = LEGGINGS_NETHERITE_HEAVY.getItemMeta();
            LEGGINGS_NETHERITE_HEAVY_META.displayName(Component.text("Heavy Netherite Leggings"));
            LEGGINGS_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_HEAVY);
            LEGGINGS_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_NETHERITE_HEAVY);
            LEGGINGS_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesLeggings.HEALTH_NETHERITE_HEAVY);
            LEGGINGS_NETHERITE_HEAVY.setItemMeta(LEGGINGS_NETHERITE_HEAVY_META);

            //JUG
            final var LEGGINGS_LEATHER_JUG = new ItemStack(Material.LEATHER_LEGGINGS);
            final var LEGGINGS_LEATHER_JUG_META = LEGGINGS_LEATHER_JUG.getItemMeta();
            LEGGINGS_LEATHER_JUG_META.displayName(Component.text("Juggernaut Leather Leggings"));
            LEGGINGS_LEATHER_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_JUG);
            LEGGINGS_LEATHER_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_LEATHER_JUG);
            LEGGINGS_LEATHER_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesLeggings.HEALTH_LEATHER_JUG);
            LEGGINGS_LEATHER_JUG.setItemMeta(LEGGINGS_LEATHER_JUG_META);

            final var LEGGINGS_GOLDEN_JUG = new ItemStack(Material.GOLDEN_LEGGINGS);
            final var LEGGINGS_GOLDEN_JUG_META = LEGGINGS_GOLDEN_JUG.getItemMeta();
            LEGGINGS_GOLDEN_JUG_META.displayName(Component.text("Juggernaut Golden Leggings"));
            LEGGINGS_GOLDEN_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_JUG);
            LEGGINGS_GOLDEN_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_GOLDEN_JUG);
            LEGGINGS_GOLDEN_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesLeggings.HEALTH_GOLD_JUG);
            LEGGINGS_GOLDEN_JUG.setItemMeta(LEGGINGS_GOLDEN_JUG_META);

            final var LEGGINGS_CHAIN_JUG = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            final var LEGGINGS_CHAIN_JUG_META = LEGGINGS_CHAIN_JUG.getItemMeta();
            LEGGINGS_CHAIN_JUG_META.displayName(Component.text("Juggernaut Chainmail Leggings"));
            LEGGINGS_CHAIN_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_JUG);
            LEGGINGS_CHAIN_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_CHAIN_JUG);
            LEGGINGS_CHAIN_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesLeggings.HEALTH_CHAIN_JUG);
            LEGGINGS_CHAIN_JUG.setItemMeta(LEGGINGS_CHAIN_JUG_META);

            final var LEGGINGS_IRON_JUG = new ItemStack(Material.IRON_LEGGINGS);
            final var LEGGINGS_IRON_JUG_META = LEGGINGS_IRON_JUG.getItemMeta();
            LEGGINGS_IRON_JUG_META.displayName(Component.text("Juggernaut Iron Leggings"));
            LEGGINGS_IRON_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_JUG);
            LEGGINGS_IRON_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_IRON_JUG);
            LEGGINGS_IRON_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesLeggings.HEALTH_IRON_JUG);
            LEGGINGS_IRON_JUG.setItemMeta(LEGGINGS_IRON_JUG_META);

            final var LEGGINGS_DIAMOND_JUG = new ItemStack(Material.DIAMOND_LEGGINGS);
            final var LEGGINGS_DIAMOND_JUG_META = LEGGINGS_DIAMOND_JUG.getItemMeta();
            LEGGINGS_DIAMOND_JUG_META.displayName(Component.text("Juggernaut Diamond Leggings"));
            LEGGINGS_DIAMOND_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_JUG);
            LEGGINGS_DIAMOND_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_DIAMOND_JUG);
            LEGGINGS_DIAMOND_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesLeggings.HEALTH_DIAMOND_JUG);
            LEGGINGS_DIAMOND_JUG.setItemMeta(LEGGINGS_DIAMOND_JUG_META);

            final var LEGGINGS_NETHERITE_JUG = new ItemStack(Material.NETHERITE_LEGGINGS);
            final var LEGGINGS_NETHERITE_JUG_META = LEGGINGS_NETHERITE_JUG.getItemMeta();
            LEGGINGS_NETHERITE_JUG_META.displayName(Component.text("Juggernaut Netherite Leggings"));
            LEGGINGS_NETHERITE_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesLeggings.MOVE_SPEED_JUG);
            LEGGINGS_NETHERITE_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesLeggings.ARMOR_NETHERITE_JUG);
            LEGGINGS_NETHERITE_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesLeggings.HEALTH_NETHERITE_JUG);
            LEGGINGS_NETHERITE_JUG.setItemMeta(LEGGINGS_NETHERITE_JUG_META);

            //ADDING TO LIST
            put(StratumMaterial.LEGGINGS_LEATHER_LIGHT.name(), LEGGINGS_LEATHER_LIGHT);
            put(StratumMaterial.LEGGINGS_GOLDEN_LIGHT.name(), LEGGINGS_GOLDEN_LIGHT);
            put(StratumMaterial.LEGGINGS_CHAIN_LIGHT.name(), LEGGINGS_CHAIN_LIGHT);
            put(StratumMaterial.LEGGINGS_IRON_LIGHT.name(), LEGGINGS_IRON_LIGHT);
            put(StratumMaterial.LEGGINGS_DIAMOND_LIGHT.name(), LEGGINGS_DIAMOND_LIGHT);
            put(StratumMaterial.LEGGINGS_NETHERITE_LIGHT.name(), LEGGINGS_NETHERITE_LIGHT);

            put(StratumMaterial.LEGGINGS_LEATHER_HEAVY.name(), LEGGINGS_LEATHER_HEAVY);
            put(StratumMaterial.LEGGINGS_GOLDEN_HEAVY.name(), LEGGINGS_GOLDEN_HEAVY);
            put(StratumMaterial.LEGGINGS_CHAIN_HEAVY.name(), LEGGINGS_CHAIN_HEAVY);
            put(StratumMaterial.LEGGINGS_IRON_HEAVY.name(), LEGGINGS_IRON_HEAVY);
            put(StratumMaterial.LEGGINGS_DIAMOND_HEAVY.name(), LEGGINGS_DIAMOND_HEAVY);
            put(StratumMaterial.LEGGINGS_NETHERITE_HEAVY.name(), LEGGINGS_NETHERITE_HEAVY);

            put(StratumMaterial.LEGGINGS_LEATHER_JUG.name(), LEGGINGS_LEATHER_JUG);
            put(StratumMaterial.LEGGINGS_GOLDEN_JUG.name(), LEGGINGS_GOLDEN_JUG);
            put(StratumMaterial.LEGGINGS_CHAIN_JUG.name(), LEGGINGS_CHAIN_JUG);
            put(StratumMaterial.LEGGINGS_IRON_JUG.name(), LEGGINGS_IRON_JUG);
            put(StratumMaterial.LEGGINGS_DIAMOND_JUG.name(), LEGGINGS_DIAMOND_JUG);
            put(StratumMaterial.LEGGINGS_NETHERITE_JUG.name(), LEGGINGS_NETHERITE_JUG);
        }};
    }
}
