package moe.quill.Adventuring.Enemies;

import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public abstract class Enemy {

    protected final Component name;
    protected final EntityType entityType;

    public Enemy(Component name, EntityType entityType) {
        this.name = name;
        this.entityType = entityType;
    }

    protected abstract Entity spawnFreshEntity(Location location);

    @SuppressWarnings("CheckReturnValue")
    public abstract Entity spawn(Location location);
}
