package moe.quill.Adventuring.Enemies;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class EnemyManager {

    private final Plugin plugin;

    private final HashMap<EnemyType, Enemy> enemyMap = new HashMap<>();
    private final StratumMaterialManager materialManager;
    private static final Logger logger = LoggerFactory.getLogger(EnemyManager.class.getSimpleName());
    private static final Reflections reflections = new Reflections("moe.quill");

    public EnemyManager(Plugin plugin, StratumMaterialManager materialManager) {
        this.plugin = plugin;
        this.materialManager = materialManager;
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
                        final var enemy = enemyClass.getDeclaredConstructor(StratumMaterialManager.class).newInstance(materialManager);
                        enemyMap.put(enemy.enemyType, enemy);
                        logger.info(String.format("Registered new enemy -> %s", enemy.getClass().getSimpleName()));
                    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }
}
