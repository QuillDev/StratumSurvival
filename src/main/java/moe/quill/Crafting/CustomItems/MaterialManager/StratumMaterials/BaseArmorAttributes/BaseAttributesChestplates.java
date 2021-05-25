package moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.BaseArmorAttributes;

import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;

import java.util.UUID;

public class BaseAttributesChestplates {

    private static final float LEATHER_ARMOR_BASE = 3f;
    private static final float GOLDEN_ARMOR_BASE = 5f;
    private static final float CHAIN_ARMOR_BASE = 5f;
    private static final float IRON_ARMOR_BASE = 6f;
    private static final float DIAMOND_ARMOR_BASE = 8f;
    private static final float NETHERITE_ARMOR_BASE = 8f;

    //MOVE_SPEED
    public static AttributeModifier MOVE_SPEED_LIGHT = new AttributeModifier(
            UUID.randomUUID(),
            "lightweight",
            BaseAttributesArmor.SPEED_VALUE,
            AttributeModifier.Operation.MULTIPLY_SCALAR_1,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier MOVE_SPEED_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "heavyweight",
            -BaseAttributesArmor.SPEED_VALUE,
            AttributeModifier.Operation.MULTIPLY_SCALAR_1,
            EquipmentSlot.CHEST
    );

    //ARMOR_LIGHT
    public static AttributeModifier ARMOR_LEATHER_LIGHT = new AttributeModifier(
            UUID.randomUUID(),
            "weak",
            LEATHER_ARMOR_BASE-BaseAttributesArmor.ARMOR_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier ARMOR_GOLDEN_LIGHT = new AttributeModifier(
            UUID.randomUUID(),
            "weak",
            GOLDEN_ARMOR_BASE-BaseAttributesArmor.ARMOR_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier ARMOR_CHAIN_LIGHT = new AttributeModifier(
            UUID.randomUUID(),
            "weak",
            CHAIN_ARMOR_BASE-BaseAttributesArmor.ARMOR_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier ARMOR_IRON_LIGHT = new AttributeModifier(
            UUID.randomUUID(),
            "weak",
            IRON_ARMOR_BASE-BaseAttributesArmor.ARMOR_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier ARMOR_DIAMOND_LIGHT = new AttributeModifier(
            UUID.randomUUID(),
            "weak",
            DIAMOND_ARMOR_BASE-BaseAttributesArmor.ARMOR_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier ARMOR_NETHERITE_LIGHT = new AttributeModifier(
            UUID.randomUUID(),
            "weak",
            NETHERITE_ARMOR_BASE-BaseAttributesArmor.ARMOR_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );

    //ARMOR_HEAVY
    public static AttributeModifier ARMOR_LEATHER_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "strong",
            LEATHER_ARMOR_BASE+BaseAttributesArmor.ARMOR_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier ARMOR_GOLDEN_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "strong",
            GOLDEN_ARMOR_BASE+BaseAttributesArmor.ARMOR_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier ARMOR_CHAIN_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "strong",
            CHAIN_ARMOR_BASE+BaseAttributesArmor.ARMOR_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier ARMOR_IRON_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "strong",
            IRON_ARMOR_BASE+BaseAttributesArmor.ARMOR_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier ARMOR_DIAMOND_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "strong",
            DIAMOND_ARMOR_BASE+BaseAttributesArmor.ARMOR_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier ARMOR_NETHERITE_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "strong",
            NETHERITE_ARMOR_BASE+BaseAttributesArmor.ARMOR_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );

    //HEALTH
    public static AttributeModifier HEALTH_LEATHER_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "healthy",
            BaseAttributesArmor.LEATHER_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier HEALTH_GOLD_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "healthy",
            BaseAttributesArmor.GOLD_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier HEALTH_CHAIN_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "healthy",
            BaseAttributesArmor.CHAIN_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier HEALTH_IRON_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "healthy",
            BaseAttributesArmor.IRON_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier HEALTH_DIAMOND_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "healthy",
            BaseAttributesArmor.DIAMOND_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
    public static AttributeModifier HEALTH_NETHERITE_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "healthy",
            BaseAttributesArmor.NETHERITE_VALUE_HIGH,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.CHEST
    );
}
