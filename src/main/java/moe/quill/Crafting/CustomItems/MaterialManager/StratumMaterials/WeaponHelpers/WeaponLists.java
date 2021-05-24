package moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.WeaponHelpers;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

import java.util.ArrayList;
import java.util.Arrays;

public class WeaponLists {

    public final StratumMaterialManager materialManager;
    public static final ArrayList<ItemStack> WEAPONS_BLUNT = new ArrayList<>();
    public static final ArrayList<ItemStack> WEAPONS_BOW = new ArrayList<>();

    public WeaponLists(StratumMaterialManager materialManager) {
        this.materialManager = materialManager;
        this.registerBluntWeapons();
        this.registerBowWeapons();
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
