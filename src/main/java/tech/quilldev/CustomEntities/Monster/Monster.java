package tech.quilldev.CustomEntities.Monster;


import net.minecraft.server.v1_16_R3.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;

public class Monster extends EntityZombie {

    private final Player player;

    public Monster(Location location, Player player) {
        super(EntityTypes.ZOMBIE, ((CraftWorld) location.getWorld()).getHandle());
        this.setPosition(location.getX(), location.getY(), location.getZ());

        this.setHealth(20.0f);
        this.setCustomName(new ChatComponentText(ChatColor.LIGHT_PURPLE + "Mr. Zomb"));
        this.setCustomNameVisible(true);

        // Confirms target (NEW add this)
        this.setGoalTarget(((CraftPlayer) player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
        this.player = player;
    }

    @Override
    public void initPathfinder() { /*Read all the notes*/
        this.goalSelector.a(2, new PathfinderGoalPet(this, 1, 15));
        // these are required to make the pig follow the player, so add them
        this.goalSelector.a(1, new PathfinderGoalFloat(this));
        this.goalSelector.a(3, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));

    }
}
