package moe.quill.Utils;

import org.bukkit.NamespacedKey;

public class KeyUtils {

    public static <E extends Enum<E>> boolean isValidKey(final Class<E> enumClass, final String enumName) {
        if (enumName == null) {
            return false;
        }
        try {
            Enum.valueOf(enumClass, enumName.toUpperCase());
            return true;
        } catch (final IllegalArgumentException ex) {
            return false;
        }
    }

    public static <E extends Enum<E>> E getAttributeKey(final Class<E> enumClass, NamespacedKey key) {
        if (key == null) {
            return null;
        }
        try {
            return Enum.valueOf(enumClass, key.getKey().toUpperCase());
        } catch (final IllegalArgumentException ex) {
            return null;
        }
    }
}
