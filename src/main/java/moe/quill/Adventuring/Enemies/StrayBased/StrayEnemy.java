package moe.quill.Adventuring.Enemies.StrayBased;

import moe.quill.Adventuring.Enemies.Enemy;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Stray;

public abstract class StrayEnemy extends Enemy {
    public StrayEnemy(Component name) {
        super(name, EntityType.STRAY);
    }

    @Override
    protected Stray spawnFreshEntity(Location location) {
        final var mob = (Stray) location.getWorld().spawnEntity(location, entityType);
        mob.customName(name);
        return mob;
    }
}
