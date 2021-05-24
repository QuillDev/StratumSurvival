package moe.quill.Adventuring.Enemies.StrayBased;

import moe.quill.Adventuring.Enemies.Enemy;
import moe.quill.Adventuring.Enemies.EnemyType;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Stray;

public abstract class StrayEnemy extends Enemy {
    public StrayEnemy(Component name, StratumMaterialManager materialManager, EnemyType enemyType) {
        super(name, materialManager, EntityType.STRAY, enemyType);
    }

    @Override
    protected Stray spawnFreshEntity(Location location) {
        final var mob = (Stray) location.getWorld().spawnEntity(location, entityType);
        mob.customName(name);
        return mob;
    }
}
