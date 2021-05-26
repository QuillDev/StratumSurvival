package moe.quill.Crafting;

import moe.quill.Utils.Annotations.Keyable;
import org.bukkit.plugin.Plugin;
import org.reflections.Reflections;

public class KeyManager {

    private static final Reflections reflections = new Reflections("moe.quill");

    public KeyManager(Plugin plugin) {
        reflections
                .getTypesAnnotatedWith(Keyable.class)
                .forEach(attrClass -> {
                    //Get enum keys
                    final var keyClass = attrClass.getEnumConstants();

                    for (final var key : keyClass) {
                        System.out.println(key);
                    }
                });
    }
}
