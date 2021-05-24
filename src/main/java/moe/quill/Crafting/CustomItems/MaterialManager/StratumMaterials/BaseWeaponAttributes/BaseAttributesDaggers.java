package moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.BaseWeaponAttributes;

import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;

import java.util.UUID;

public class BaseAttributesDaggers {

    public static AttributeModifier ATTACK_SPEED = new AttributeModifier(
            UUID.randomUUID(),
            "blade_attack_speed",
            -.2f,
            AttributeModifier.Operation.MULTIPLY_SCALAR_1,
            EquipmentSlot.HAND
    );

    public static AttributeModifier MOVE_SPEED = new AttributeModifier(
            UUID.randomUUID(),
            "blade_walk_speed",
            .3f,
            AttributeModifier.Operation.MULTIPLY_SCALAR_1,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_WOOD = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            2f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_GOLD = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            2f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_STONE = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            2.5f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_IRON = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            3f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_DIAMOND = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            3.5f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_NETHERITE = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            4f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );
}
