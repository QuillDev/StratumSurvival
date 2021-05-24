package moe.quill.Adventuring.Enemies.ZombieBased;

import moe.quill.Adventuring.Enemies.Enemy;
import moe.quill.Adventuring.Enemies.EnemyType;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;

public abstract class ZombieEnemy extends Enemy {

    public ZombieEnemy(Component name, EnemyType enemyType) {
        super(name, EntityType.ZOMBIE, enemyType);
    }

    @Override
    public Zombie spawn(Location location) {
        return spawnFreshEntity(location);
    }

    @Override
    protected Zombie spawnFreshEntity(Location location) {
        final var mob = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);
        mob.customName(name);
        return mob;
    }
}
