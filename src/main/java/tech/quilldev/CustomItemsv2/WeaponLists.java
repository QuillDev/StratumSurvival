package tech.quilldev.CustomItemsv2;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import tech.quilldev.Crafting.StratumMaterial;
import tech.quilldev.Crafting.StratumMaterialManager;

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
                materialManager.getItem(StratumMaterial.BATTLEAXE_WOODEN),
                materialManager.getItem(StratumMaterial.BATTLEAXE_STONE),
                materialManager.getItem(StratumMaterial.BATTLEAXE_IRON),
                materialManager.getItem(StratumMaterial.BATTLEAXE_GOLDEN),
                materialManager.getItem(StratumMaterial.BATTLEAXE_DIAMOND),
                materialManager.getItem(StratumMaterial.BATTLEAXE_NETHERITE),
                materialManager.getItem(Material.WOODEN_SWORD),
                materialManager.getItem(Material.STONE_SWORD),
                materialManager.getItem(Material.IRON_AXE),
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
