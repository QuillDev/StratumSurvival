package moe.quill.Crafting;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.StratumSurvival;
import moe.quill.Utils.Annotations.Keyable;
import org.bukkit.NamespacedKey;
import org.reflections.Reflections;

import java.util.HashMap;

@Singleton
public class KeyManager {

    private static final Reflections reflections = new Reflections("moe.quill");
    private final HashMap<String, NamespacedKey> keys = new HashMap<>();

    @Inject
    public KeyManager(StratumSurvival plugin) {
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

    public NamespacedKey getNsKey(AttributeKey attributeKey) {
        return getNsKey(attributeKey.name());
    }

    public NamespacedKey getNsKey(GlobalKey globalKey) {
        return getNsKey(globalKey.name());
    }
}
