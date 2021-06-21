package moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.ArmorMaterialRegistries;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.BaseArmorAttributes.BaseAttributesHelmets;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class HelmetMaterialRegistry extends MaterialRegistry {
    public HelmetMaterialRegistry(IKeyManager keyManager, ISerializer serializer) {
        super(keyManager, serializer, MaterialKey.ARMOR_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{

            //LIGHT
            final var HELMET_LEATHER_LIGHT = new ItemStack(Material.LEATHER_HELMET);
            final var HELMET_LEATHER_LIGHT_META = HELMET_LEATHER_LIGHT.getItemMeta();
            HELMET_LEATHER_LIGHT_META.displayName(Component.text("Light Leather Helmet"));
            HELMET_LEATHER_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_LIGHT);
            HELMET_LEATHER_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_LEATHER_LIGHT);
            HELMET_LEATHER_LIGHT.setItemMeta(HELMET_LEATHER_LIGHT_META);

            final var HELMET_GOLDEN_LIGHT = new ItemStack(Material.GOLDEN_HELMET);
            final var HELMET_GOLDEN_LIGHT_META = HELMET_GOLDEN_LIGHT.getItemMeta();
            HELMET_GOLDEN_LIGHT_META.displayName(Component.text("Light Gold Helmet"));
            HELMET_GOLDEN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_LIGHT);
            HELMET_GOLDEN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_GOLDEN_LIGHT);
            HELMET_GOLDEN_LIGHT.setItemMeta(HELMET_GOLDEN_LIGHT_META);

            final var HELMET_CHAIN_LIGHT = new ItemStack(Material.CHAINMAIL_HELMET);
            final var HELMET_CHAIN_LIGHT_META = HELMET_CHAIN_LIGHT.getItemMeta();
            HELMET_CHAIN_LIGHT_META.displayName(Component.text("Light Chainmail Helmet"));
            HELMET_CHAIN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_LIGHT);
            HELMET_CHAIN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_CHAIN_LIGHT);
            HELMET_CHAIN_LIGHT.setItemMeta(HELMET_CHAIN_LIGHT_META);

            final var HELMET_IRON_LIGHT = new ItemStack(Material.IRON_HELMET);
            final var HELMET_IRON_LIGHT_META = HELMET_IRON_LIGHT.getItemMeta();
            HELMET_IRON_LIGHT_META.displayName(Component.text("Light Iron Helmet"));
            HELMET_IRON_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_LIGHT);
            HELMET_IRON_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_IRON_LIGHT);
            HELMET_IRON_LIGHT.setItemMeta(HELMET_IRON_LIGHT_META);

            final var HELMET_DIAMOND_LIGHT = new ItemStack(Material.DIAMOND_HELMET);
            final var HELMET_DIAMOND_LIGHT_META = HELMET_DIAMOND_LIGHT.getItemMeta();
            HELMET_DIAMOND_LIGHT_META.displayName(Component.text("Light Diamond Helmet"));
            HELMET_DIAMOND_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_LIGHT);
            HELMET_DIAMOND_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_DIAMOND_LIGHT);
            HELMET_DIAMOND_LIGHT.setItemMeta(HELMET_DIAMOND_LIGHT_META);

            final var HELMET_NETHERITE_LIGHT = new ItemStack(Material.NETHERITE_HELMET);
            final var HELMET_NETHERITE_LIGHT_META = HELMET_NETHERITE_LIGHT.getItemMeta();
            HELMET_NETHERITE_LIGHT_META.displayName(Component.text("Light Netherite Helmet"));
            HELMET_NETHERITE_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_LIGHT);
            HELMET_NETHERITE_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_NETHERITE_LIGHT);
            HELMET_NETHERITE_LIGHT.setItemMeta(HELMET_NETHERITE_LIGHT_META);

            //HEAVY
            final var HELMET_LEATHER_HEAVY = new ItemStack(Material.LEATHER_HELMET);
            final var HELMET_LEATHER_HEAVY_META = HELMET_LEATHER_HEAVY.getItemMeta();
            HELMET_LEATHER_HEAVY_META.displayName(Component.text("Heavy Leather Helmet"));
            HELMET_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_HEAVY);
            HELMET_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_LEATHER_HEAVY);
            HELMET_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_LEATHER_HEAVY);
            HELMET_LEATHER_HEAVY.setItemMeta(HELMET_LEATHER_HEAVY_META);

            final var HELMET_GOLDEN_HEAVY = new ItemStack(Material.GOLDEN_HELMET);
            final var HELMET_GOLDEN_HEAVY_META = HELMET_GOLDEN_HEAVY.getItemMeta();
            HELMET_GOLDEN_HEAVY_META.displayName(Component.text("Heavy Golden Helmet"));
            HELMET_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_HEAVY);
            HELMET_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_GOLDEN_HEAVY);
            HELMET_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_GOLD_HEAVY);
            HELMET_GOLDEN_HEAVY.setItemMeta(HELMET_GOLDEN_HEAVY_META);

            final var HELMET_CHAIN_HEAVY = new ItemStack(Material.CHAINMAIL_HELMET);
            final var HELMET_CHAIN_HEAVY_META = HELMET_CHAIN_HEAVY.getItemMeta();
            HELMET_CHAIN_HEAVY_META.displayName(Component.text("Heavy Chainmail Helmet"));
            HELMET_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_HEAVY);
            HELMET_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_CHAIN_HEAVY);
            HELMET_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_CHAIN_HEAVY);
            HELMET_CHAIN_HEAVY.setItemMeta(HELMET_CHAIN_HEAVY_META);

            final var HELMET_IRON_HEAVY = new ItemStack(Material.IRON_HELMET);
            final var HELMET_IRON_HEAVY_META = HELMET_IRON_HEAVY.getItemMeta();
            HELMET_IRON_HEAVY_META.displayName(Component.text("Heavy Iron Helmet"));
            HELMET_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_HEAVY);
            HELMET_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_IRON_HEAVY);
            HELMET_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_IRON_HEAVY);
            HELMET_IRON_HEAVY.setItemMeta(HELMET_IRON_HEAVY_META);

            final var HELMET_DIAMOND_HEAVY = new ItemStack(Material.DIAMOND_HELMET);
            final var HELMET_DIAMOND_HEAVY_META = HELMET_DIAMOND_HEAVY.getItemMeta();
            HELMET_DIAMOND_HEAVY_META.displayName(Component.text("Heavy Diamond Helmet"));
            HELMET_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_HEAVY);
            HELMET_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_DIAMOND_HEAVY);
            HELMET_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_DIAMOND_HEAVY);
            HELMET_DIAMOND_HEAVY.setItemMeta(HELMET_DIAMOND_HEAVY_META);

            final var HELMET_NETHERITE_HEAVY = new ItemStack(Material.NETHERITE_HELMET);
            final var HELMET_NETHERITE_HEAVY_META = HELMET_NETHERITE_HEAVY.getItemMeta();
            HELMET_NETHERITE_HEAVY_META.displayName(Component.text("Heavy Netherite Helmet"));
            HELMET_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_HEAVY);
            HELMET_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_NETHERITE_HEAVY);
            HELMET_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_NETHERITE_HEAVY);
            HELMET_NETHERITE_HEAVY.setItemMeta(HELMET_NETHERITE_HEAVY_META);

            //JUG
            final var HELMET_LEATHER_JUG = new ItemStack(Material.LEATHER_HELMET);
            final var HELMET_LEATHER_JUG_META = HELMET_LEATHER_JUG.getItemMeta();
            HELMET_LEATHER_JUG_META.displayName(Component.text("Juggernaut Leather Helmet"));
            HELMET_LEATHER_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_JUG);
            HELMET_LEATHER_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_LEATHER_JUG);
            HELMET_LEATHER_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_LEATHER_JUG);
            HELMET_LEATHER_JUG.setItemMeta(HELMET_LEATHER_JUG_META);

            final var HELMET_GOLDEN_JUG = new ItemStack(Material.GOLDEN_HELMET);
            final var HELMET_GOLDEN_JUG_META = HELMET_GOLDEN_JUG.getItemMeta();
            HELMET_GOLDEN_JUG_META.displayName(Component.text("Juggernaut Golden Helmet"));
            HELMET_GOLDEN_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_JUG);
            HELMET_GOLDEN_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_GOLDEN_JUG);
            HELMET_GOLDEN_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_GOLD_JUG);
            HELMET_GOLDEN_JUG.setItemMeta(HELMET_GOLDEN_JUG_META);

            final var HELMET_CHAIN_JUG = new ItemStack(Material.CHAINMAIL_HELMET);
            final var HELMET_CHAIN_JUG_META = HELMET_CHAIN_JUG.getItemMeta();
            HELMET_CHAIN_JUG_META.displayName(Component.text("Juggernaut Chainmail Helmet"));
            HELMET_CHAIN_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_JUG);
            HELMET_CHAIN_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_CHAIN_JUG);
            HELMET_CHAIN_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_CHAIN_JUG);
            HELMET_CHAIN_JUG.setItemMeta(HELMET_CHAIN_JUG_META);

            final var HELMET_IRON_JUG = new ItemStack(Material.IRON_HELMET);
            final var HELMET_IRON_JUG_META = HELMET_IRON_JUG.getItemMeta();
            HELMET_IRON_JUG_META.displayName(Component.text("Juggernaut Iron Helmet"));
            HELMET_IRON_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_JUG);
            HELMET_IRON_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_IRON_JUG);
            HELMET_IRON_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_IRON_JUG);
            HELMET_IRON_JUG.setItemMeta(HELMET_IRON_JUG_META);

            final var HELMET_DIAMOND_JUG = new ItemStack(Material.DIAMOND_HELMET);
            final var HELMET_DIAMOND_JUG_META = HELMET_DIAMOND_JUG.getItemMeta();
            HELMET_DIAMOND_JUG_META.displayName(Component.text("Juggernaut Diamond Helmet"));
            HELMET_DIAMOND_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_JUG);
            HELMET_DIAMOND_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_DIAMOND_JUG);
            HELMET_DIAMOND_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_DIAMOND_JUG);
            HELMET_DIAMOND_JUG.setItemMeta(HELMET_DIAMOND_JUG_META);

            final var HELMET_NETHERITE_JUG = new ItemStack(Material.NETHERITE_HELMET);
            final var HELMET_NETHERITE_JUG_META = HELMET_NETHERITE_JUG.getItemMeta();
            HELMET_NETHERITE_JUG_META.displayName(Component.text("Juggernaut Netherite Helmet"));
            HELMET_NETHERITE_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesHelmets.MOVE_SPEED_JUG);
            HELMET_NETHERITE_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesHelmets.ARMOR_NETHERITE_JUG);
            HELMET_NETHERITE_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesHelmets.HEALTH_NETHERITE_JUG);
            HELMET_NETHERITE_JUG.setItemMeta(HELMET_NETHERITE_JUG_META);

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

            put(StratumMaterial.HELMET_LEATHER_JUG.name(), HELMET_LEATHER_JUG);
            put(StratumMaterial.HELMET_GOLDEN_JUG.name(), HELMET_GOLDEN_JUG);
            put(StratumMaterial.HELMET_CHAIN_JUG.name(), HELMET_CHAIN_JUG);
            put(StratumMaterial.HELMET_IRON_JUG.name(), HELMET_IRON_JUG);
            put(StratumMaterial.HELMET_DIAMOND_JUG.name(), HELMET_DIAMOND_JUG);
            put(StratumMaterial.HELMET_NETHERITE_JUG.name(), HELMET_NETHERITE_JUG);
        }};
    }
}
