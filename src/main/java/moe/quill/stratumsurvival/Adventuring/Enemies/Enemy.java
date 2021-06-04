package moe.quill.stratumsurvival.Adventuring.Enemies;

import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public abstract class Enemy {

    protected final Component name;
    protected final EntityType entityType;
    protected final EnemyType enemyType;
    protected final MaterialManager materialManager;

    public Enemy(Component name, MaterialManager materialManager, EntityType entityType, EnemyType enemyType) {
        this.name = name;
        this.materialManager = materialManager;
        this.entityType = entityType;
        this.enemyType = enemyType;
    }

    protected abstract Entity spawnFreshEntity(Location location);

    @SuppressWarnings("CheckReturnValue")
    public abstract Entity spawn(Location location);

    public EnemyType getEnemyType() {
        return enemyType;
    }
}
