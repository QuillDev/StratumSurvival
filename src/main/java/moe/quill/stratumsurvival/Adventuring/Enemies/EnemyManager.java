package moe.quill.stratumsurvival.Adventuring.Enemies;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import org.bukkit.Location;
import org.burningwave.core.assembler.ComponentContainer;
import org.burningwave.core.assembler.ComponentSupplier;
import org.burningwave.core.classes.CacheableSearchConfig;
import org.burningwave.core.classes.ClassCriteria;
import org.burningwave.core.classes.ClassHunter;
import org.burningwave.core.classes.SearchConfig;
import org.burningwave.core.io.PathHelper;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.stream.Collectors;

@Singleton
public class EnemyManager {


    private final HashMap<EnemyType, Enemy> enemyMap = new HashMap<>();
    private final MaterialManager materialManager;
    private static final Logger logger = LoggerFactory.getLogger(EnemyManager.class.getSimpleName());
    private static final Reflections reflections = new Reflections("moe.quill.stratumsurvival");

    @Inject
    public EnemyManager(MaterialManager materialManager) {
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
                        final var enemy = enemyClass.getDeclaredConstructor(MaterialManager.class).newInstance(materialManager);
                        enemyMap.put(enemy.enemyType, enemy);
                        logger.info(String.format("Registered new enemy -> %s", enemy.getClass().getSimpleName()));
                    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }
}
