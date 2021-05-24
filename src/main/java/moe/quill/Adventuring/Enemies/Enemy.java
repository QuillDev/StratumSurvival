package moe.quill.Adventuring.Enemies;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public abstract class Enemy {

    protected final Component name;
    protected final EntityType entityType;
    protected final EnemyType enemyType;
    protected static StratumMaterialManager materialManager;

    public Enemy(Component name, EntityType entityType, EnemyType enemyType) {
        this.name = name;
        this.entityType = entityType;
        this.enemyType = enemyType;
    }

    protected abstract Entity spawnFreshEntity(Location location);

    @SuppressWarnings("CheckReturnValue")
    public abstract Entity spawn(Location location);

    public static void setMaterialManager(StratumMaterialManager materialManager) {
        Enemy.materialManager = materialManager;
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }
}
