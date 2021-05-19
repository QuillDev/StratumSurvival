package tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.MaterialRegistries.WeaponMaterialRegistries;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import tech.quilldev.CustomItemsv2.BaseWeaponAttributes.BaseAttributesDaggers;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterial;
import tech.quilldev.Serialization.StratumSerialization;

import java.util.HashMap;

public class DaggerMaterialRegistry extends MaterialRegistry {
    public DaggerMaterialRegistry(NamespacedKey itemKey) {
        super(itemKey);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{
            final var DAGGER_WOODEN = new ItemStack(Material.WOODEN_SWORD);
            final var DAGGER_WOODEN_META = DAGGER_WOODEN.getItemMeta();
            DAGGER_WOODEN_META.setCustomModelData(1);
            DAGGER_WOODEN_META.setLocalizedName("Wooden Dagger");
            DAGGER_WOODEN_META.displayName(Component.text(DAGGER_WOODEN_META.getLocalizedName()));
            DAGGER_WOODEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesDaggers.ATTACK_DAMAGE_WOOD);
            DAGGER_WOODEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesDaggers.ATTACK_SPEED);
            DAGGER_WOODEN_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesDaggers.MOVE_SPEED);
            DAGGER_WOODEN_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            DAGGER_WOODEN.setItemMeta(DAGGER_WOODEN_META);

            //setup stone battleaxe
            final var DAGGER_STONE = new ItemStack(Material.STONE_SWORD);
            final var DAGGER_STONE_META = DAGGER_STONE.getItemMeta();
            DAGGER_STONE_META.setCustomModelData(1);
            DAGGER_STONE_META.setLocalizedName("Stone Dagger");
            DAGGER_STONE_META.displayName(Component.text(DAGGER_STONE_META.getLocalizedName()));
            DAGGER_STONE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesDaggers.ATTACK_DAMAGE_STONE);
            DAGGER_STONE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesDaggers.ATTACK_SPEED);
            DAGGER_STONE_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesDaggers.MOVE_SPEED);
            DAGGER_STONE_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            DAGGER_STONE.setItemMeta(DAGGER_STONE_META);

            //setup iron battleaxe
            final var DAGGER_IRON = new ItemStack(Material.IRON_SWORD);
            final var DAGGER_IRON_META = DAGGER_IRON.getItemMeta();
            DAGGER_IRON_META.setCustomModelData(1);
            DAGGER_IRON_META.setLocalizedName("Iron Dagger");
            DAGGER_IRON_META.displayName(Component.text(DAGGER_IRON_META.getLocalizedName()));
            DAGGER_IRON_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesDaggers.ATTACK_DAMAGE_IRON);
            DAGGER_IRON_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesDaggers.ATTACK_SPEED);
            DAGGER_IRON_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesDaggers.MOVE_SPEED);
            DAGGER_IRON_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            DAGGER_IRON.setItemMeta(DAGGER_IRON_META);

            //setup golden battleaxe
            final var DAGGER_GOLDEN = new ItemStack(Material.GOLDEN_SWORD);
            final var DAGGER_GOLDEN_META = DAGGER_GOLDEN.getItemMeta();
            DAGGER_GOLDEN_META.setCustomModelData(1);
            DAGGER_GOLDEN_META.setLocalizedName("Golden Dagger");
            DAGGER_GOLDEN_META.displayName(Component.text(DAGGER_GOLDEN_META.getLocalizedName()));
            DAGGER_GOLDEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesDaggers.ATTACK_DAMAGE_GOLD);
            DAGGER_GOLDEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesDaggers.ATTACK_SPEED);
            DAGGER_GOLDEN_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesDaggers.MOVE_SPEED);
            DAGGER_GOLDEN_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            DAGGER_GOLDEN.setItemMeta(DAGGER_GOLDEN_META);

            //setup diamond battleaxe
            final var DAGGER_DIAMOND = new ItemStack(Material.DIAMOND_SWORD);
            final var DAGGER_DIAMOND_META = DAGGER_DIAMOND.getItemMeta();
            DAGGER_DIAMOND_META.setCustomModelData(1);
            DAGGER_DIAMOND_META.setLocalizedName("Diamond Dagger");
            DAGGER_DIAMOND_META.displayName(Component.text(DAGGER_DIAMOND_META.getLocalizedName()));
            DAGGER_DIAMOND_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesDaggers.ATTACK_DAMAGE_DIAMOND);
            DAGGER_DIAMOND_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesDaggers.ATTACK_SPEED);
            DAGGER_DIAMOND_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesDaggers.MOVE_SPEED);
            DAGGER_DIAMOND_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            DAGGER_DIAMOND.setItemMeta(DAGGER_DIAMOND_META);

            //setup Netherite battleaxe
            final var DAGGER_NETHERITE = new ItemStack(Material.NETHERITE_SWORD);
            final var DAGGER_NETHERITE_META = DAGGER_NETHERITE.getItemMeta();
            DAGGER_NETHERITE_META.setCustomModelData(1);
            DAGGER_NETHERITE_META.setLocalizedName("Netherite Dagger");
            DAGGER_NETHERITE_META.displayName(Component.text(DAGGER_NETHERITE_META.getLocalizedName()));
            DAGGER_NETHERITE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesDaggers.ATTACK_DAMAGE_NETHERITE);
            DAGGER_NETHERITE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesDaggers.ATTACK_SPEED);
            DAGGER_NETHERITE_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesDaggers.MOVE_SPEED);
            DAGGER_NETHERITE_META.getPersistentDataContainer().set(itemKey, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
            DAGGER_NETHERITE.setItemMeta(DAGGER_NETHERITE_META);

            //Add battle axes to the stratum material manager
            putIfAbsent(StratumMaterial.DAGGER_WOODEN.name(), DAGGER_WOODEN);
            putIfAbsent(StratumMaterial.DAGGER_STONE.name(), DAGGER_STONE);
            putIfAbsent(StratumMaterial.DAGGER_IRON.name(), DAGGER_IRON);
            putIfAbsent(StratumMaterial.DAGGER_GOLDEN.name(), DAGGER_GOLDEN);
            putIfAbsent(StratumMaterial.DAGGER_DIAMOND.name(), DAGGER_DIAMOND);
            putIfAbsent(StratumMaterial.DAGGER_NETHERITE.name(), DAGGER_NETHERITE);
        }};
    }
}
