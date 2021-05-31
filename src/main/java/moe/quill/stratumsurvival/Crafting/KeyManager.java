package moe.quill.stratumsurvival.Crafting;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import moe.quill.StratumCommon.Annotations.Keyable;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import org.reflections.Reflections;

import java.util.HashMap;

@Singleton
public class KeyManager {

    private static final Reflections reflections = new Reflections("moe.quill.stratumsurvival");
    private final HashMap<String, NamespacedKey> keys = new HashMap<>();

    @Inject
    public KeyManager(Plugin plugin) {
        reflections
                .getTypesAnnotatedWith(Keyable.class)
                .forEach(keyClass -> {
                    //Get enum keys
                    final var keyObjects = (Enum<?>[]) keyClass.getEnumConstants();

                    //Create keys for all of the keys in this class
                    for (final var key : keyObjects) {
                        keys.putIfAbsent(key.name(), new NamespacedKey(plugin, key.name()));
                    }
                });
    }

    public NamespacedKey getNsKey(String query) {
        return keys.get(query);
    }

    public <E extends Enum<E>> NamespacedKey getNsKey(Enum<E> materialKey) {
        return getNsKey(materialKey.name());
    }
}
