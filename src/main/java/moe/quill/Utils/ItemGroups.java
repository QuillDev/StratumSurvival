package moe.quill.Utils;

import org.bukkit.Material;

import java.util.HashSet;

public class ItemGroups {
    
    public static final HashSet<Material> Ore = new HashSet<>(){{
        add(Material.REDSTONE_ORE);
        add(Material.LAPIS_ORE);
        add(Material.NETHER_QUARTZ_ORE);
        add(Material.COAL_ORE);
        add(Material.IRON_ORE);
        add(Material.GOLD_ORE);
        add(Material.NETHER_GOLD_ORE);
        add(Material.DIAMOND_ORE);
        add(Material.EMERALD_ORE);
    }};

    public static final HashSet<Material> Ice = new HashSet<>() {{
        add(Material.ICE);
        add(Material.BLUE_ICE);
        add(Material.FROSTED_ICE);
        add(Material.PACKED_ICE);
    }};
}

