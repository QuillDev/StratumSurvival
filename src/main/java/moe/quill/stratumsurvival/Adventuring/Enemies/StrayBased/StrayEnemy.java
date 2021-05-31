package moe.quill.stratumsurvival.Adventuring.Enemies.StrayBased;

import moe.quill.stratumsurvival.Adventuring.Enemies.Enemy;
import moe.quill.stratumsurvival.Adventuring.Enemies.EnemyType;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Stray;

public abstract class StrayEnemy extends Enemy {
    public StrayEnemy(Component name, MaterialManager materialManager, EnemyType enemyType) {
        super(name, materialManager, EntityType.STRAY, enemyType);
    }

    @Override
    protected Stray spawnFreshEntity(Location location) {
        final var mob = (Stray) location.getWorld().spawnEntity(location, entityType);
        mob.customName(name);
        return mob;
    }
}
