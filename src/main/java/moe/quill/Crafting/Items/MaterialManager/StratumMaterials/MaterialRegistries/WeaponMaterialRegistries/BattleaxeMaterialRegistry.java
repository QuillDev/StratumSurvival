package moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.WeaponMaterialRegistries;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.BaseWeaponAttributes.BaseAttributesBattleaxes;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class BattleaxeMaterialRegistry extends MaterialRegistry {
    public BattleaxeMaterialRegistry(KeyManager keyManager) {
        super(keyManager, MaterialKey.BATTLEAXE_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {

        return new HashMap<>() {{
            //setup wooden battleaxe
            final var BATTLEAXE_WOODEN = new ItemStack(Material.WOODEN_AXE);
            final var BATTLEAXE_WOODEN_META = BATTLEAXE_WOODEN.getItemMeta();
            BATTLEAXE_WOODEN_META.setCustomModelData(1);
            BATTLEAXE_WOODEN_META.setLocalizedName("Wooden Battleaxe");
            BATTLEAXE_WOODEN_META.displayName(Component.text(BATTLEAXE_WOODEN_META.getLocalizedName()));
            BATTLEAXE_WOODEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesBattleaxes.ATTACK_DAMAGE_WOOD);
            BATTLEAXE_WOODEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesBattleaxes.ATTACK_SPEED);
            BATTLEAXE_WOODEN_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBattleaxes.MOVE_SPEED);
            BATTLEAXE_WOODEN.setItemMeta(BATTLEAXE_WOODEN_META);

            //setup stone battleaxe
            final var BATTLEAXE_STONE = new ItemStack(Material.STONE_AXE);
            final var BATTLEAXE_STONE_META = BATTLEAXE_STONE.getItemMeta();
            BATTLEAXE_STONE_META.setCustomModelData(1);
            BATTLEAXE_STONE_META.setLocalizedName("Stone Battleaxe");
            BATTLEAXE_STONE_META.displayName(Component.text(BATTLEAXE_STONE_META.getLocalizedName()));
            BATTLEAXE_STONE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesBattleaxes.ATTACK_DAMAGE_STONE);
            BATTLEAXE_STONE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesBattleaxes.ATTACK_SPEED);
            BATTLEAXE_STONE_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBattleaxes.MOVE_SPEED);
            BATTLEAXE_STONE.setItemMeta(BATTLEAXE_STONE_META);

            //setup iron battleaxe
            final var BATTLEAXE_IRON = new ItemStack(Material.IRON_AXE);
            final var BATTLEAXE_IRON_META = BATTLEAXE_IRON.getItemMeta();
            BATTLEAXE_IRON_META.setCustomModelData(1);
            BATTLEAXE_IRON_META.setLocalizedName("Iron Battleaxe");
            BATTLEAXE_IRON_META.displayName(Component.text(BATTLEAXE_IRON_META.getLocalizedName()));
            BATTLEAXE_IRON_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesBattleaxes.ATTACK_DAMAGE_IRON);
            BATTLEAXE_IRON_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesBattleaxes.ATTACK_SPEED);
            BATTLEAXE_IRON_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBattleaxes.MOVE_SPEED);
            BATTLEAXE_IRON.setItemMeta(BATTLEAXE_IRON_META);

            //setup golden battleaxe
            final var BATTLEAXE_GOLDEN = new ItemStack(Material.GOLDEN_AXE);
            final var BATTLEAXE_GOLDEN_META = BATTLEAXE_GOLDEN.getItemMeta();
            BATTLEAXE_GOLDEN_META.setCustomModelData(1);
            BATTLEAXE_GOLDEN_META.setLocalizedName("Golden Battleaxe");
            BATTLEAXE_GOLDEN_META.displayName(Component.text(BATTLEAXE_GOLDEN_META.getLocalizedName()));
            BATTLEAXE_GOLDEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesBattleaxes.ATTACK_DAMAGE_GOLD);
            BATTLEAXE_GOLDEN_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesBattleaxes.ATTACK_SPEED);
            BATTLEAXE_GOLDEN_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBattleaxes.MOVE_SPEED);
            BATTLEAXE_GOLDEN.setItemMeta(BATTLEAXE_GOLDEN_META);

            //setup diamond battleaxe
            final var BATTLEAXE_DIAMOND = new ItemStack(Material.DIAMOND_AXE);
            final var BATTLEAXE_DIAMOND_META = BATTLEAXE_DIAMOND.getItemMeta();
            BATTLEAXE_DIAMOND_META.setCustomModelData(1);
            BATTLEAXE_DIAMOND_META.setLocalizedName("Diamond Battleaxe");
            BATTLEAXE_DIAMOND_META.displayName(Component.text(BATTLEAXE_DIAMOND_META.getLocalizedName()));
            BATTLEAXE_DIAMOND_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesBattleaxes.ATTACK_DAMAGE_DIAMOND);
            BATTLEAXE_DIAMOND_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesBattleaxes.ATTACK_SPEED);
            BATTLEAXE_DIAMOND_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBattleaxes.MOVE_SPEED);
            BATTLEAXE_DIAMOND.setItemMeta(BATTLEAXE_DIAMOND_META);

            //setup Netherite battleaxe
            final var BATTLEAXE_NETHERITE = new ItemStack(Material.NETHERITE_AXE);
            final var BATTLEAXE_NETHERITE_META = BATTLEAXE_NETHERITE.getItemMeta();
            BATTLEAXE_NETHERITE_META.setCustomModelData(1);
            BATTLEAXE_NETHERITE_META.setLocalizedName("Netherite Battleaxe");
            BATTLEAXE_NETHERITE_META.displayName(Component.text(BATTLEAXE_NETHERITE_META.getLocalizedName()));
            BATTLEAXE_NETHERITE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, BaseAttributesBattleaxes.ATTACK_DAMAGE_NETHERITE);
            BATTLEAXE_NETHERITE_META.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, BaseAttributesBattleaxes.ATTACK_SPEED);
            BATTLEAXE_NETHERITE_META.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, BaseAttributesBattleaxes.MOVE_SPEED);
            BATTLEAXE_NETHERITE.setItemMeta(BATTLEAXE_NETHERITE_META);

            //Add battle axes to the stratum material manager
            putIfAbsent(StratumMaterial.BATTLEAXE_WOODEN.name(), BATTLEAXE_WOODEN);
            putIfAbsent(StratumMaterial.BATTLEAXE_STONE.name(), BATTLEAXE_STONE);
            putIfAbsent(StratumMaterial.BATTLEAXE_IRON.name(), BATTLEAXE_IRON);
            putIfAbsent(StratumMaterial.BATTLEAXE_GOLDEN.name(), BATTLEAXE_GOLDEN);
            putIfAbsent(StratumMaterial.BATTLEAXE_DIAMOND.name(), BATTLEAXE_DIAMOND);
            putIfAbsent(StratumMaterial.BATTLEAXE_NETHERITE.name(), BATTLEAXE_NETHERITE);
        }};
    }
}
