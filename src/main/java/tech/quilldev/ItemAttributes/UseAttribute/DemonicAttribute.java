package tech.quilldev.ItemAttributes.UseAttribute;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public class DemonicAttribute extends UseAttribute {
    public DemonicAttribute(NamespacedKey key) {
        super(key);
    }

    @Override
    public void execute(Player player) {
        player.sendMessage("The weapon whispers in your ear... you feel a chill..");
    }
}
