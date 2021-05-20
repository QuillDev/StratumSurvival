package tech.quilldev.CustomItems.BaseWeaponAttributes;

import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;

import java.util.UUID;

public class BaseAttributesBattleaxes {
    public static AttributeModifier ATTACK_SPEED = new AttributeModifier(
            UUID.randomUUID(),
            "sluggish",
            -.8f,
            AttributeModifier.Operation.MULTIPLY_SCALAR_1,
            EquipmentSlot.HAND
    );

    public static AttributeModifier MOVE_SPEED = new AttributeModifier(
            UUID.randomUUID(),
            "sluggish",
            -.2f,
            AttributeModifier.Operation.MULTIPLY_SCALAR_1,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_WOOD = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            9f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_GOLD = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            9f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_STONE = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            10f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_IRON = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            12f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_DIAMOND = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            13f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_NETHERITE = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            14f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );


}
