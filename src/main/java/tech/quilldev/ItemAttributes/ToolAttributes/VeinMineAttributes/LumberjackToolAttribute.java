package tech.quilldev.ItemAttributes.ToolAttributes.VeinMineAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import java.util.ArrayList;
import java.util.Arrays;

public class LumberjackToolAttribute extends VeinMineAttribute {

    public LumberjackToolAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText, new ArrayList<>(
                        Arrays.asList(
                                Material.BIRCH_LOG,
                                Material.OAK_LOG,
                                Material.DARK_OAK_LOG,
                                Material.ACACIA_LOG,
                                Material.SPRUCE_LOG,
                                Material.JUNGLE_LOG,
                                Material.STRIPPED_ACACIA_LOG,
                                Material.STRIPPED_BIRCH_LOG,
                                Material.STRIPPED_JUNGLE_LOG,
                                Material.STRIPPED_OAK_LOG,
                                Material.STRIPPED_SPRUCE_LOG,
                                Material.STRIPPED_DARK_OAK_LOG,
                                Material.STRIPPED_CRIMSON_STEM,
                                Material.STRIPPED_WARPED_STEM
                        )
                ),
                new ArrayList<>(Arrays.asList(
                        Material.WOODEN_AXE,
                        Material.STONE_AXE,
                        Material.IRON_AXE,
                        Material.GOLDEN_AXE,
                        Material.DIAMOND_AXE,
                        Material.NETHERITE_AXE
                )));
    }
}
