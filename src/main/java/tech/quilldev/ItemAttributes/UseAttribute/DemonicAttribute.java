package tech.quilldev.ItemAttributes.UseAttribute;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public class DemonicAttribute extends UseAttribute {

    public DemonicAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(Player player) {
        player.sendMessage("The weapon whispers in your ear... you feel a chill..");
    }
}
