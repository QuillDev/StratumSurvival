package moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.WeaponMaterialRegistries;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.BaseWeaponAttributes.BaseAttributesCutlasses;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class CutlassMaterialRegistry extends MaterialRegistry {


    public CutlassMaterialRegistry() {
        super(MaterialKey.CUTLASS_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{
            final var CUTLASS_WOODEN = new ItemStack(Material.WOODEN_SWORD);
            final var CUTLASS_WOODEN_META = CUTLASS_WOODEN.getItemMeta();
            CUTLASS_WOODEN_META.setCustomModelData(3);
            CUTLASS_WOODEN_META.setLocalizedName("Wooden Cutlass");
            CUTLASS_WOODEN_META.displayName(Component.text(CUTLASS_WOODEN_META.getLocalizedName()));
            CUTLASS_WOODEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesCutlasses.ATTACK_DAMAGE_WOOD);
            CUTLASS_WOODEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesCutlasses.ATTACK_SPEED);
            CUTLASS_WOODEN.setItemMeta(CUTLASS_WOODEN_META);

            //setup stone battleaxe
            final var CUTLASS_STONE = new ItemStack(Material.STONE_SWORD);
            final var CUTLASS_STONE_META = CUTLASS_STONE.getItemMeta();
            CUTLASS_STONE_META.setCustomModelData(3);
            CUTLASS_STONE_META.setLocalizedName("Stone Cutlass");
            CUTLASS_STONE_META.displayName(Component.text(CUTLASS_STONE_META.getLocalizedName()));
            CUTLASS_STONE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesCutlasses.ATTACK_DAMAGE_STONE);
            CUTLASS_STONE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesCutlasses.ATTACK_SPEED);
            CUTLASS_STONE.setItemMeta(CUTLASS_STONE_META);

            //setup iron battleaxe
            final var CUTLASS_IRON = new ItemStack(Material.IRON_SWORD);
            final var CUTLASS_IRON_META = CUTLASS_IRON.getItemMeta();
            CUTLASS_IRON_META.setCustomModelData(3);
            CUTLASS_IRON_META.setLocalizedName("Iron Cutlass");
            CUTLASS_IRON_META.displayName(Component.text(CUTLASS_IRON_META.getLocalizedName()));
            CUTLASS_IRON_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesCutlasses.ATTACK_DAMAGE_IRON);
            CUTLASS_IRON_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesCutlasses.ATTACK_SPEED);
            CUTLASS_IRON.setItemMeta(CUTLASS_IRON_META);

            //setup golden battleaxe
            final var CUTLASS_GOLDEN = new ItemStack(Material.GOLDEN_SWORD);
            final var CUTLASS_GOLDEN_META = CUTLASS_GOLDEN.getItemMeta();
            CUTLASS_GOLDEN_META.setCustomModelData(3);
            CUTLASS_GOLDEN_META.setLocalizedName("Golden Cutlass");
            CUTLASS_GOLDEN_META.displayName(Component.text(CUTLASS_GOLDEN_META.getLocalizedName()));
            CUTLASS_GOLDEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesCutlasses.ATTACK_DAMAGE_GOLD);
            CUTLASS_GOLDEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesCutlasses.ATTACK_SPEED);
            CUTLASS_GOLDEN.setItemMeta(CUTLASS_GOLDEN_META);

            //setup diamond battleaxe
            final var CUTLASS_DIAMOND = new ItemStack(Material.DIAMOND_SWORD);
            final var CUTLASS_DIAMOND_META = CUTLASS_DIAMOND.getItemMeta();
            CUTLASS_DIAMOND_META.setCustomModelData(3);
            CUTLASS_DIAMOND_META.setLocalizedName("Diamond Cutlass");
            CUTLASS_DIAMOND_META.displayName(Component.text(CUTLASS_DIAMOND_META.getLocalizedName()));
            CUTLASS_DIAMOND_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesCutlasses.ATTACK_DAMAGE_DIAMOND);
            CUTLASS_DIAMOND_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesCutlasses.ATTACK_SPEED);
            CUTLASS_DIAMOND.setItemMeta(CUTLASS_DIAMOND_META);

            //setup Netherite battleaxe
            final var CUTLASS_NETHERITE = new ItemStack(Material.NETHERITE_SWORD);
            final var CUTLASS_NETHERITE_META = CUTLASS_NETHERITE.getItemMeta();
            CUTLASS_NETHERITE_META.setCustomModelData(3);
            CUTLASS_NETHERITE_META.setLocalizedName("Netherite Cutlass");
            CUTLASS_NETHERITE_META.displayName(Component.text(CUTLASS_NETHERITE_META.getLocalizedName()));
            CUTLASS_NETHERITE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesCutlasses.ATTACK_DAMAGE_NETHERITE);
            CUTLASS_NETHERITE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesCutlasses.ATTACK_SPEED);
            CUTLASS_NETHERITE.setItemMeta(CUTLASS_NETHERITE_META);

            //Add battle axes to the stratum material manager
            putIfAbsent(StratumMaterial.CUTLASS_WOODEN.name(), CUTLASS_WOODEN);
            putIfAbsent(StratumMaterial.CUTLASS_STONE.name(), CUTLASS_STONE);
            putIfAbsent(StratumMaterial.CUTLASS_IRON.name(), CUTLASS_IRON);
            putIfAbsent(StratumMaterial.CUTLASS_GOLDEN.name(), CUTLASS_GOLDEN);
            putIfAbsent(StratumMaterial.CUTLASS_DIAMOND.name(), CUTLASS_DIAMOND);
            putIfAbsent(StratumMaterial.CUTLASS_NETHERITE.name(), CUTLASS_NETHERITE);
        }};
    }
}
