package tech.quilldev.CustomItemsv2;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;

public class WeaponLists {
    public static ArrayList<Material> BLUNT_WEAPONS = new ArrayList<>(Arrays.asList(
            //AXES
            Material.WOODEN_AXE,
            Material.STONE_AXE,
            Material.IRON_AXE,
            Material.GOLDEN_AXE,
            Material.DIAMOND_AXE,
            Material.NETHERITE_AXE,
            //SWORDS
            Material.WOODEN_SWORD,
            Material.STONE_SWORD,
            Material.IRON_SWORD,
            Material.GOLDEN_SWORD,
            Material.DIAMOND_SWORD,
            Material.NETHERITE_SWORD
    ));

    public static ArrayList<Material> BOW_WEAPONS = new ArrayList<>(Arrays.asList(
            Material.BOW,
            Material.CROSSBOW
    ));
}
