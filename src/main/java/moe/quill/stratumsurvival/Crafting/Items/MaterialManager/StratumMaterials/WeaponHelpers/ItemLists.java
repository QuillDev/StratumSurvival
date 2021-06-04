package moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers;

import com.google.inject.Inject;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemLists {


    private final ArrayList<ItemStack> bluntWeapons = new ArrayList<>();
    private final ArrayList<ItemStack> bowWeapons = new ArrayList<>();
    private final ArrayList<ItemStack> pickaxeItems = new ArrayList<>();
    private final MaterialManager materialManager;

    @Inject
    public ItemLists(MaterialManager materialManager) {
        this.materialManager = materialManager;
        this.registerBluntWeapons();
        this.registerBowWeapons();
        this.registerMiningTools();
    }

    private void registerMiningTools() {
        pickaxeItems.addAll(Arrays.asList(
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
        bluntWeapons.addAll(Arrays.asList(
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
        bowWeapons.addAll(Arrays.asList(
                materialManager.getItem(Material.BOW),
                materialManager.getItem(Material.CROSSBOW)
        ));
    }

    public ArrayList<ItemStack> getPickaxeItems() {
        return pickaxeItems;
    }

    public ArrayList<ItemStack> getBluntWeapons() {
        return bluntWeapons;
    }

    public ArrayList<ItemStack> getBowWeapons() {
        return bowWeapons;
    }

}
