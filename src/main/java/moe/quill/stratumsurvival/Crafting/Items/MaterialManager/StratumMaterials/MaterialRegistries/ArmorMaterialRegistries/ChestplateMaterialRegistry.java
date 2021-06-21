package moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.ArmorMaterialRegistries;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.BaseArmorAttributes.BaseAttributesChestplates;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ChestplateMaterialRegistry extends MaterialRegistry {
    public ChestplateMaterialRegistry(IKeyManager keyManager, ISerializer serializer) {
        super(keyManager, serializer, MaterialKey.ARMOR_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{

            //LIGHT
            final var CHESTPLATE_LEATHER_LIGHT = new ItemStack(Material.LEATHER_CHESTPLATE);
            final var CHESTPLATE_LEATHER_LIGHT_META = CHESTPLATE_LEATHER_LIGHT.getItemMeta();
            CHESTPLATE_LEATHER_LIGHT_META.displayName(Component.text("Light Leather Chestplate"));
            CHESTPLATE_LEATHER_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_LIGHT);
            CHESTPLATE_LEATHER_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_LEATHER_LIGHT);
            CHESTPLATE_LEATHER_LIGHT.setItemMeta(CHESTPLATE_LEATHER_LIGHT_META);

            final var CHESTPLATE_GOLDEN_LIGHT = new ItemStack(Material.GOLDEN_CHESTPLATE);
            final var CHESTPLATE_GOLDEN_LIGHT_META = CHESTPLATE_GOLDEN_LIGHT.getItemMeta();
            CHESTPLATE_GOLDEN_LIGHT_META.displayName(Component.text("Light Gold Chestplate"));
            CHESTPLATE_GOLDEN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_LIGHT);
            CHESTPLATE_GOLDEN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_GOLDEN_LIGHT);
            CHESTPLATE_GOLDEN_LIGHT.setItemMeta(CHESTPLATE_GOLDEN_LIGHT_META);

            final var CHESTPLATE_CHAIN_LIGHT = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            final var CHESTPLATE_CHAIN_LIGHT_META = CHESTPLATE_CHAIN_LIGHT.getItemMeta();
            CHESTPLATE_CHAIN_LIGHT_META.displayName(Component.text("Light Chainmail Chestplate"));
            CHESTPLATE_CHAIN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_LIGHT);
            CHESTPLATE_CHAIN_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_CHAIN_LIGHT);
            CHESTPLATE_CHAIN_LIGHT.setItemMeta(CHESTPLATE_CHAIN_LIGHT_META);

            final var CHESTPLATE_IRON_LIGHT = new ItemStack(Material.IRON_CHESTPLATE);
            final var CHESTPLATE_IRON_LIGHT_META = CHESTPLATE_IRON_LIGHT.getItemMeta();
            CHESTPLATE_IRON_LIGHT_META.displayName(Component.text("Light Iron Chestplate"));
            CHESTPLATE_IRON_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_LIGHT);
            CHESTPLATE_IRON_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_IRON_LIGHT);
            CHESTPLATE_IRON_LIGHT.setItemMeta(CHESTPLATE_IRON_LIGHT_META);

            final var CHESTPLATE_DIAMOND_LIGHT = new ItemStack(Material.DIAMOND_CHESTPLATE);
            final var CHESTPLATE_DIAMOND_LIGHT_META = CHESTPLATE_DIAMOND_LIGHT.getItemMeta();
            CHESTPLATE_DIAMOND_LIGHT_META.displayName(Component.text("Light Diamond Chestplate"));
            CHESTPLATE_DIAMOND_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_LIGHT);
            CHESTPLATE_DIAMOND_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_DIAMOND_LIGHT);
            CHESTPLATE_DIAMOND_LIGHT.setItemMeta(CHESTPLATE_DIAMOND_LIGHT_META);

            final var CHESTPLATE_NETHERITE_LIGHT = new ItemStack(Material.NETHERITE_CHESTPLATE);
            final var CHESTPLATE_NETHERITE_LIGHT_META = CHESTPLATE_NETHERITE_LIGHT.getItemMeta();
            CHESTPLATE_NETHERITE_LIGHT_META.displayName(Component.text("Light Netherite Chestplate"));
            CHESTPLATE_NETHERITE_LIGHT_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_LIGHT);
            CHESTPLATE_NETHERITE_LIGHT_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_NETHERITE_LIGHT);
            CHESTPLATE_NETHERITE_LIGHT.setItemMeta(CHESTPLATE_NETHERITE_LIGHT_META);

            //HEAVY
            final var CHESTPLATE_LEATHER_HEAVY = new ItemStack(Material.LEATHER_CHESTPLATE);
            final var CHESTPLATE_LEATHER_HEAVY_META = CHESTPLATE_LEATHER_HEAVY.getItemMeta();
            CHESTPLATE_LEATHER_HEAVY_META.displayName(Component.text("Heavy Leather Chestplate"));
            CHESTPLATE_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_HEAVY);
            CHESTPLATE_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_LEATHER_HEAVY);
            CHESTPLATE_LEATHER_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesChestplates.HEALTH_LEATHER_HEAVY);
            CHESTPLATE_LEATHER_HEAVY.setItemMeta(CHESTPLATE_LEATHER_HEAVY_META);

            final var CHESTPLATE_GOLDEN_HEAVY = new ItemStack(Material.GOLDEN_CHESTPLATE);
            final var CHESTPLATE_GOLDEN_HEAVY_META = CHESTPLATE_GOLDEN_HEAVY.getItemMeta();
            CHESTPLATE_GOLDEN_HEAVY_META.displayName(Component.text("Heavy Golden Chestplate"));
            CHESTPLATE_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_HEAVY);
            CHESTPLATE_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_GOLDEN_HEAVY);
            CHESTPLATE_GOLDEN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesChestplates.HEALTH_GOLD_HEAVY);
            CHESTPLATE_GOLDEN_HEAVY.setItemMeta(CHESTPLATE_GOLDEN_HEAVY_META);

            final var CHESTPLATE_CHAIN_HEAVY = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            final var CHESTPLATE_CHAIN_HEAVY_META = CHESTPLATE_CHAIN_HEAVY.getItemMeta();
            CHESTPLATE_CHAIN_HEAVY_META.displayName(Component.text("Heavy Chainmail Chestplate"));
            CHESTPLATE_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_HEAVY);
            CHESTPLATE_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_CHAIN_HEAVY);
            CHESTPLATE_CHAIN_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesChestplates.HEALTH_CHAIN_HEAVY);
            CHESTPLATE_CHAIN_HEAVY.setItemMeta(CHESTPLATE_CHAIN_HEAVY_META);

            final var CHESTPLATE_IRON_HEAVY = new ItemStack(Material.IRON_CHESTPLATE);
            final var CHESTPLATE_IRON_HEAVY_META = CHESTPLATE_IRON_HEAVY.getItemMeta();
            CHESTPLATE_IRON_HEAVY_META.displayName(Component.text("Heavy Iron Chestplate"));
            CHESTPLATE_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_HEAVY);
            CHESTPLATE_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_IRON_HEAVY);
            CHESTPLATE_IRON_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesChestplates.HEALTH_IRON_HEAVY);
            CHESTPLATE_IRON_HEAVY.setItemMeta(CHESTPLATE_IRON_HEAVY_META);

            final var CHESTPLATE_DIAMOND_HEAVY = new ItemStack(Material.DIAMOND_CHESTPLATE);
            final var CHESTPLATE_DIAMOND_HEAVY_META = CHESTPLATE_DIAMOND_HEAVY.getItemMeta();
            CHESTPLATE_DIAMOND_HEAVY_META.displayName(Component.text("Heavy Diamond Chestplate"));
            CHESTPLATE_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_HEAVY);
            CHESTPLATE_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_DIAMOND_HEAVY);
            CHESTPLATE_DIAMOND_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesChestplates.HEALTH_DIAMOND_HEAVY);
            CHESTPLATE_DIAMOND_HEAVY.setItemMeta(CHESTPLATE_DIAMOND_HEAVY_META);

            final var CHESTPLATE_NETHERITE_HEAVY = new ItemStack(Material.NETHERITE_CHESTPLATE);
            final var CHESTPLATE_NETHERITE_HEAVY_META = CHESTPLATE_NETHERITE_HEAVY.getItemMeta();
            CHESTPLATE_NETHERITE_HEAVY_META.displayName(Component.text("Heavy Netherite Chestplate"));
            CHESTPLATE_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_HEAVY);
            CHESTPLATE_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_NETHERITE_HEAVY);
            CHESTPLATE_NETHERITE_HEAVY_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesChestplates.HEALTH_NETHERITE_HEAVY);
            CHESTPLATE_NETHERITE_HEAVY.setItemMeta(CHESTPLATE_NETHERITE_HEAVY_META);

            //JUG
            final var CHESTPLATE_LEATHER_JUG = new ItemStack(Material.LEATHER_CHESTPLATE);
            final var CHESTPLATE_LEATHER_JUG_META = CHESTPLATE_LEATHER_JUG.getItemMeta();
            CHESTPLATE_LEATHER_JUG_META.displayName(Component.text("Juggernaut Leather Chestplate"));
            CHESTPLATE_LEATHER_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_JUG);
            CHESTPLATE_LEATHER_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_LEATHER_JUG);
            CHESTPLATE_LEATHER_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesChestplates.HEALTH_LEATHER_JUG);
            CHESTPLATE_LEATHER_JUG.setItemMeta(CHESTPLATE_LEATHER_JUG_META);

            final var CHESTPLATE_GOLDEN_JUG = new ItemStack(Material.GOLDEN_CHESTPLATE);
            final var CHESTPLATE_GOLDEN_JUG_META = CHESTPLATE_GOLDEN_JUG.getItemMeta();
            CHESTPLATE_GOLDEN_JUG_META.displayName(Component.text("Juggernaut Golden Chestplate"));
            CHESTPLATE_GOLDEN_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_JUG);
            CHESTPLATE_GOLDEN_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_GOLDEN_JUG);
            CHESTPLATE_GOLDEN_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesChestplates.HEALTH_GOLD_JUG);
            CHESTPLATE_GOLDEN_JUG.setItemMeta(CHESTPLATE_GOLDEN_JUG_META);

            final var CHESTPLATE_CHAIN_JUG = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            final var CHESTPLATE_CHAIN_JUG_META = CHESTPLATE_CHAIN_JUG.getItemMeta();
            CHESTPLATE_CHAIN_JUG_META.displayName(Component.text("Juggernaut Chainmail Chestplate"));
            CHESTPLATE_CHAIN_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_JUG);
            CHESTPLATE_CHAIN_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_CHAIN_JUG);
            CHESTPLATE_CHAIN_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesChestplates.HEALTH_CHAIN_JUG);
            CHESTPLATE_CHAIN_JUG.setItemMeta(CHESTPLATE_CHAIN_JUG_META);

            final var CHESTPLATE_IRON_JUG = new ItemStack(Material.IRON_CHESTPLATE);
            final var CHESTPLATE_IRON_JUG_META = CHESTPLATE_IRON_JUG.getItemMeta();
            CHESTPLATE_IRON_JUG_META.displayName(Component.text("Juggernaut Iron Chestplate"));
            CHESTPLATE_IRON_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_JUG);
            CHESTPLATE_IRON_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_IRON_JUG);
            CHESTPLATE_IRON_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesChestplates.HEALTH_IRON_JUG);
            CHESTPLATE_IRON_JUG.setItemMeta(CHESTPLATE_IRON_JUG_META);

            final var CHESTPLATE_DIAMOND_JUG = new ItemStack(Material.DIAMOND_CHESTPLATE);
            final var CHESTPLATE_DIAMOND_JUG_META = CHESTPLATE_DIAMOND_JUG.getItemMeta();
            CHESTPLATE_DIAMOND_JUG_META.displayName(Component.text("Juggernaut Diamond Chestplate"));
            CHESTPLATE_DIAMOND_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_JUG);
            CHESTPLATE_DIAMOND_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_DIAMOND_JUG);
            CHESTPLATE_DIAMOND_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesChestplates.HEALTH_DIAMOND_JUG);
            CHESTPLATE_DIAMOND_JUG.setItemMeta(CHESTPLATE_DIAMOND_JUG_META);

            final var CHESTPLATE_NETHERITE_JUG = new ItemStack(Material.NETHERITE_CHESTPLATE);
            final var CHESTPLATE_NETHERITE_JUG_META = CHESTPLATE_NETHERITE_JUG.getItemMeta();
            CHESTPLATE_NETHERITE_JUG_META.displayName(Component.text("Juggernaut Netherite Chestplate"));
            CHESTPLATE_NETHERITE_JUG_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesChestplates.MOVE_SPEED_JUG);
            CHESTPLATE_NETHERITE_JUG_META.addAttributeModifier(Attribute.GENERIC_ARMOR, BaseAttributesChestplates.ARMOR_NETHERITE_JUG);
            CHESTPLATE_NETHERITE_JUG_META.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, BaseAttributesChestplates.HEALTH_NETHERITE_JUG);
            CHESTPLATE_NETHERITE_JUG.setItemMeta(CHESTPLATE_NETHERITE_JUG_META);

            //ADDING TO LIST
            put(StratumMaterial.CHESTPLATE_LEATHER_LIGHT.name(), CHESTPLATE_LEATHER_LIGHT);
            put(StratumMaterial.CHESTPLATE_GOLDEN_LIGHT.name(), CHESTPLATE_GOLDEN_LIGHT);
            put(StratumMaterial.CHESTPLATE_CHAIN_LIGHT.name(), CHESTPLATE_CHAIN_LIGHT);
            put(StratumMaterial.CHESTPLATE_IRON_LIGHT.name(), CHESTPLATE_IRON_LIGHT);
            put(StratumMaterial.CHESTPLATE_DIAMOND_LIGHT.name(), CHESTPLATE_DIAMOND_LIGHT);
            put(StratumMaterial.CHESTPLATE_NETHERITE_LIGHT.name(), CHESTPLATE_NETHERITE_LIGHT);

            put(StratumMaterial.CHESTPLATE_LEATHER_HEAVY.name(), CHESTPLATE_LEATHER_HEAVY);
            put(StratumMaterial.CHESTPLATE_GOLDEN_HEAVY.name(), CHESTPLATE_GOLDEN_HEAVY);
            put(StratumMaterial.CHESTPLATE_CHAIN_HEAVY.name(), CHESTPLATE_CHAIN_HEAVY);
            put(StratumMaterial.CHESTPLATE_IRON_HEAVY.name(), CHESTPLATE_IRON_HEAVY);
            put(StratumMaterial.CHESTPLATE_DIAMOND_HEAVY.name(), CHESTPLATE_DIAMOND_HEAVY);
            put(StratumMaterial.CHESTPLATE_NETHERITE_HEAVY.name(), CHESTPLATE_NETHERITE_HEAVY);

            put(StratumMaterial.CHESTPLATE_LEATHER_JUG.name(), CHESTPLATE_LEATHER_JUG);
            put(StratumMaterial.CHESTPLATE_GOLDEN_JUG.name(), CHESTPLATE_GOLDEN_JUG);
            put(StratumMaterial.CHESTPLATE_CHAIN_JUG.name(), CHESTPLATE_CHAIN_JUG);
            put(StratumMaterial.CHESTPLATE_IRON_JUG.name(), CHESTPLATE_IRON_JUG);
            put(StratumMaterial.CHESTPLATE_DIAMOND_JUG.name(), CHESTPLATE_DIAMOND_JUG);
            put(StratumMaterial.CHESTPLATE_NETHERITE_JUG.name(), CHESTPLATE_NETHERITE_JUG);
        }};
    }
}
