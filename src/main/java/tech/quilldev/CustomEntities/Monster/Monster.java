package tech.quilldev.CustomEntities.Monster;

import net.kyori.adventure.text.Component;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EntityZombie;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

public class Monster extends EntityZombie {


    public Monster(Location location) {
        super(EntityTypes.ZOMBIE, ((CraftWorld) location.getWorld()).getHandle());
        this.setPosition(location.getX(), location.getY(), location.getZ());

        this.setHealth(20.0f);
        this.setCustomName(new ChatComponentText(ChatColor.LIGHT_PURPLE + "Mr. Zomb"));
        this.setCustomNameVisible(true);
    }
}
