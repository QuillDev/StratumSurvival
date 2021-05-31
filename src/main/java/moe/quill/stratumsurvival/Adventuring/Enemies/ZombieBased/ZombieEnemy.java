package moe.quill.stratumsurvival.Adventuring.Enemies.ZombieBased;

import moe.quill.stratumsurvival.Adventuring.Enemies.Enemy;
import moe.quill.stratumsurvival.Adventuring.Enemies.EnemyType;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;

public abstract class ZombieEnemy extends Enemy {

    public ZombieEnemy(Component name, MaterialManager materialManager, EnemyType enemyType) {
        super(name, materialManager, EntityType.ZOMBIE, enemyType);
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
