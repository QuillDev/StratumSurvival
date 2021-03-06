package moe.quill.stratumsurvival.Adventuring.Enemies;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import org.bukkit.Location;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;

@Singleton
public class EnemyManager {

    private static final Logger logger = LoggerFactory.getLogger(EnemyManager.class.getSimpleName());

    private final HashMap<EnemyType, Enemy> enemyMap = new HashMap<>();
    private final MaterialManager materialManager;

    private final Reflections reflections;

    @Inject
    public EnemyManager(MaterialManager materialManager, Reflections reflections) {
        this.materialManager = materialManager;
        this.reflections = reflections;
        registerEnemiesDynamically();
    }

    public void spawnEnemyOfType(Location location, EnemyType enemyType) {
        final var enemy = enemyMap.get(enemyType);
        if (enemy == null) return;
        enemy.spawn(location);
    }

    public void registerEnemiesDynamically() {
        reflections
                .getSubTypesOf(Enemy.class)
                .stream()
                .filter(enemyClass -> !Modifier.isAbstract(enemyClass.getModifiers()))
                .forEach(enemyClass -> {
                    try {
                        final var enemy = enemyClass.getDeclaredConstructor(MaterialManager.class).newInstance(materialManager);
                        enemyMap.put(enemy.enemyType, enemy);
                        logger.info(String.format("Registered new enemy -> %s", enemy.getClass().getSimpleName()));
                    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }
}
