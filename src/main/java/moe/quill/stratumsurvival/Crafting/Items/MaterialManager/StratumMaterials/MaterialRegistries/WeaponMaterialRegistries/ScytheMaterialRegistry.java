package moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.WeaponMaterialRegistries;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.BaseWeaponAttributes.BaseAttributesScythes;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ScytheMaterialRegistry extends MaterialRegistry {

    public ScytheMaterialRegistry(IKeyManager keyManager) {
        super(keyManager, MaterialKey.SCYTHE_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {
            {
                //setup wooden battleaxe
                final var SCYTHE_WOODEN = new ItemStack(Material.WOODEN_SWORD);
                final var SCYTHE_WOODEN_META = SCYTHE_WOODEN.getItemMeta();
                SCYTHE_WOODEN_META.setCustomModelData(2);
                SCYTHE_WOODEN_META.setLocalizedName("Wooden Scythe");
                SCYTHE_WOODEN_META.displayName(Component.text(SCYTHE_WOODEN_META.getLocalizedName()));
                SCYTHE_WOODEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesScythes.ATTACK_DAMAGE_WOOD);
                SCYTHE_WOODEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesScythes.ATTACK_SPEED);
                SCYTHE_WOODEN.setItemMeta(SCYTHE_WOODEN_META);

                //setup stone battleaxe
                final var SCYTHE_STONE = new ItemStack(Material.STONE_SWORD);
                final var SCYTHE_STONE_META = SCYTHE_STONE.getItemMeta();
                SCYTHE_STONE_META.setCustomModelData(2);
                SCYTHE_STONE_META.setLocalizedName("Stone Scythe");
                SCYTHE_STONE_META.displayName(Component.text(SCYTHE_STONE_META.getLocalizedName()));
                SCYTHE_STONE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesScythes.ATTACK_DAMAGE_STONE);
                SCYTHE_STONE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesScythes.ATTACK_SPEED);
                SCYTHE_STONE.setItemMeta(SCYTHE_STONE_META);

                //setup iron battleaxe
                final var SCYTHE_IRON = new ItemStack(Material.IRON_SWORD);
                final var SCYTHE_IRON_META = SCYTHE_IRON.getItemMeta();
                SCYTHE_IRON_META.setCustomModelData(2);
                SCYTHE_IRON_META.setLocalizedName("Iron Scythe");
                SCYTHE_IRON_META.displayName(Component.text(SCYTHE_IRON_META.getLocalizedName()));
                SCYTHE_IRON_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesScythes.ATTACK_DAMAGE_IRON);
                SCYTHE_IRON_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesScythes.ATTACK_SPEED);
                SCYTHE_IRON.setItemMeta(SCYTHE_IRON_META);

                //setup golden battleaxe
                final var SCYTHE_GOLDEN = new ItemStack(Material.GOLDEN_SWORD);
                final var SCYTHE_GOLDEN_META = SCYTHE_GOLDEN.getItemMeta();
                SCYTHE_GOLDEN_META.setCustomModelData(2);
                SCYTHE_GOLDEN_META.setLocalizedName("Golden Scythe");
                SCYTHE_GOLDEN_META.displayName(Component.text(SCYTHE_GOLDEN_META.getLocalizedName()));
                SCYTHE_GOLDEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesScythes.ATTACK_DAMAGE_GOLD);
                SCYTHE_GOLDEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesScythes.ATTACK_SPEED);
                SCYTHE_GOLDEN.setItemMeta(SCYTHE_GOLDEN_META);

                //setup diamond battleaxe
                final var SCYTHE_DIAMOND = new ItemStack(Material.DIAMOND_SWORD);
                final var SCYTHE_DIAMOND_META = SCYTHE_DIAMOND.getItemMeta();
                SCYTHE_DIAMOND_META.setCustomModelData(2);
                SCYTHE_DIAMOND_META.setLocalizedName("Diamond Scythe");
                SCYTHE_DIAMOND_META.displayName(Component.text(SCYTHE_DIAMOND_META.getLocalizedName()));
                SCYTHE_DIAMOND_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesScythes.ATTACK_DAMAGE_DIAMOND);
                SCYTHE_DIAMOND_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesScythes.ATTACK_SPEED);
                SCYTHE_DIAMOND.setItemMeta(SCYTHE_DIAMOND_META);

                //setup Netherite battleaxe
                final var SCYTHE_NETHERITE = new ItemStack(Material.NETHERITE_SWORD);
                final var SCYTHE_NETHERITE_META = SCYTHE_NETHERITE.getItemMeta();
                SCYTHE_NETHERITE_META.setCustomModelData(2);
                SCYTHE_NETHERITE_META.setLocalizedName("Netherite Scythe");
                SCYTHE_NETHERITE_META.displayName(Component.text(SCYTHE_NETHERITE_META.getLocalizedName()));
                SCYTHE_NETHERITE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesScythes.ATTACK_DAMAGE_NETHERITE);
                SCYTHE_NETHERITE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesScythes.ATTACK_SPEED);
                SCYTHE_NETHERITE.setItemMeta(SCYTHE_NETHERITE_META);

                //Add battle axes to the stratum material manager
                putIfAbsent(StratumMaterial.SCYTHE_WOODEN.name(), SCYTHE_WOODEN);
                putIfAbsent(StratumMaterial.SCYTHE_STONE.name(), SCYTHE_STONE);
                putIfAbsent(StratumMaterial.SCYTHE_IRON.name(), SCYTHE_IRON);
                putIfAbsent(StratumMaterial.SCYTHE_GOLDEN.name(), SCYTHE_GOLDEN);
                putIfAbsent(StratumMaterial.SCYTHE_DIAMOND.name(), SCYTHE_DIAMOND);
                putIfAbsent(StratumMaterial.SCYTHE_NETHERITE.name(), SCYTHE_NETHERITE);
            }
        };
    }


}
