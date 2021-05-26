package moe.quill.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemLists {

    public final StratumMaterialManager materialManager;
    public static final ArrayList<ItemStack> WEAPONS_BLUNT = new ArrayList<>();
    public static final ArrayList<ItemStack> WEAPONS_BOW = new ArrayList<>();
    public static final ArrayList<ItemStack> TOOLS_PICKAXE = new ArrayList<>();

    public ItemLists(StratumMaterialManager materialManager) {
        this.materialManager = materialManager;
        this.registerBluntWeapons();
        this.registerBowWeapons();
        this.registerMiningTools();
    }

    private void registerMiningTools() {
        TOOLS_PICKAXE.addAll(Arrays.asList(
                materialManager.getItem(Material.WOODEN_PICKAXE),
                materialManager.getItem(Material.STONE_PICKAXE),
                materialManager.getItem(Material.GOLDEN_PICKAXE),
                materialManager.getItem(Material.IRON_PICKAXE),
                materialManager.getItem(Material.DIAMOND_PICKAXE),
                materialManager.getItem(Material.NETHERITE_PICKAXE),
                materialManager.getItem(StratumMaterial.ICEPICK_WOODEN),
                materialManager.getItem(StratumMaterial.ICEPICK_STONE),
                materialManager.getItem(StratumMaterial.ICEPICK_GOLDEN),
                materialManager.getItem(StratumMaterial.ICEPICK_IRON),
                materialManager.getItem(StratumMaterial.ICEPICK_DIAMOND),
                materialManager.getItem(StratumMaterial.ICEPICK_NETHERITE),
                materialManager.getItem(StratumMaterial.HAMMER_WOODEN),
                materialManager.getItem(StratumMaterial.HAMMER_STONE),
                materialManager.getItem(StratumMaterial.HAMMER_GOLDEN),
                materialManager.getItem(StratumMaterial.HAMMER_IRON),
                materialManager.getItem(StratumMaterial.HAMMER_DIAMOND),
                materialManager.getItem(StratumMaterial.HAMMER_NETHERITE)
        ));
    }

    private void registerBluntWeapons() {
        WEAPONS_BLUNT.addAll(Arrays.asList(
                materialManager.getItem(StratumMaterial.SCYTHE_WOODEN),
                materialManager.getItem(StratumMaterial.SCYTHE_STONE),
                materialManager.getItem(StratumMaterial.SCYTHE_IRON),
                materialManager.getItem(StratumMaterial.SCYTHE_GOLDEN),
                materialManager.getItem(StratumMaterial.SCYTHE_DIAMOND),
                materialManager.getItem(StratumMaterial.SCYTHE_NETHERITE),
                materialManager.getItem(StratumMaterial.BATTLEAXE_WOODEN),
                materialManager.getItem(StratumMaterial.BATTLEAXE_STONE),
                materialManager.getItem(StratumMaterial.BATTLEAXE_IRON),
                materialManager.getItem(StratumMaterial.BATTLEAXE_GOLDEN),
                materialManager.getItem(StratumMaterial.BATTLEAXE_DIAMOND),
                materialManager.getItem(StratumMaterial.BATTLEAXE_NETHERITE),
                materialManager.getItem(StratumMaterial.DAGGER_WOODEN),
                materialManager.getItem(StratumMaterial.DAGGER_STONE),
                materialManager.getItem(StratumMaterial.DAGGER_IRON),
                materialManager.getItem(StratumMaterial.DAGGER_GOLDEN),
                materialManager.getItem(StratumMaterial.DAGGER_DIAMOND),
                materialManager.getItem(StratumMaterial.DAGGER_NETHERITE),
                materialManager.getItem(StratumMaterial.CUTLASS_WOODEN),
                materialManager.getItem(StratumMaterial.CUTLASS_STONE),
                materialManager.getItem(StratumMaterial.CUTLASS_IRON),
                materialManager.getItem(StratumMaterial.CUTLASS_GOLDEN),
                materialManager.getItem(StratumMaterial.CUTLASS_DIAMOND),
                materialManager.getItem(StratumMaterial.CUTLASS_NETHERITE),
                materialManager.getItem(Material.WOODEN_SWORD),
                materialManager.getItem(Material.STONE_SWORD),
                materialManager.getItem(Material.IRON_SWORD),
                materialManager.getItem(Material.GOLDEN_SWORD),
                materialManager.getItem(Material.DIAMOND_SWORD),
                materialManager.getItem(Material.NETHERITE_SWORD)

        ));
    }

    private void registerBowWeapons() {
        WEAPONS_BOW.addAll(Arrays.asList(
                materialManager.getItem(Material.BOW),
                materialManager.getItem(Material.CROSSBOW)
        ));
    }
}
