package moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.BaseWeaponAttributes;

import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;

import java.util.UUID;

public class BaseAttributesBoots {

    public static AttributeModifier MOVE_SPEED_LIGHT = new AttributeModifier(
            UUID.randomUUID(),
            "lightarmor",
            1f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.FEET
    );

    public static AttributeModifier MOVE_SPEED_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "heavyarmor",
            -1f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.FEET
    );

    public static AttributeModifier ARMOR_LIGHT = new AttributeModifier(
            UUID.randomUUID(),
            "weak",
            -1f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.FEET
    );

    public static AttributeModifier ARMOR_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "strong",
            1f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.FEET
    );

    public static AttributeModifier HEALTH_HEAVY = new AttributeModifier(
            UUID.randomUUID(),
            "healthy",
            1f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.FEET
    );
}
