package tech.quilldev.CustomItemsV1.ItemAttributes.ToolAttributes.VeinMineAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import java.util.ArrayList;
import java.util.Arrays;

public class VeinMineToolAttribute extends VeinMineAttribute {

    public VeinMineToolAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText, new ArrayList<>(Arrays.asList(
                Material.COAL_ORE,
                Material.IRON_ORE,
                Material.DIAMOND_ORE,
                Material.EMERALD_ORE,
                Material.NETHER_GOLD_ORE,
                Material.NETHER_QUARTZ_ORE,
                Material.LAPIS_ORE,
                Material.REDSTONE_ORE
                )),
                new ArrayList<>(Arrays.asList(
                        Material.WOODEN_PICKAXE,
                        Material.STONE_PICKAXE,
                        Material.IRON_PICKAXE,
                        Material.GOLDEN_PICKAXE,
                        Material.DIAMOND_PICKAXE,
                        Material.NETHERITE_PICKAXE
                )));
    }
}
