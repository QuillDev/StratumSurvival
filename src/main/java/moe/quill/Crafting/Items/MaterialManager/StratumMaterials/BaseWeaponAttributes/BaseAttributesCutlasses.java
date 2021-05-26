package moe.quill.Crafting.Items.MaterialManager.StratumMaterials.BaseWeaponAttributes;

import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;

import java.util.UUID;

public class BaseAttributesCutlasses {

    public static AttributeModifier ATTACK_SPEED = new AttributeModifier(
            UUID.randomUUID(),
            "sluggish",
            -.55f,
            AttributeModifier.Operation.MULTIPLY_SCALAR_1,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_WOOD = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            5f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_GOLD = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            5f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_STONE = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            6f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_IRON = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            7f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_DIAMOND = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            8f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );

    public static AttributeModifier ATTACK_DAMAGE_NETHERITE = new AttributeModifier(
            UUID.randomUUID(),
            "bonusDamage",
            9f,
            AttributeModifier.Operation.ADD_NUMBER,
            EquipmentSlot.HAND
    );
}
