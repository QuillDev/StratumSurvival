package tech.quilldev.ItemAttributes.OnUseAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public class DemonicOnUseAttribute extends OnUseAttribute {

    public DemonicOnUseAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(Player player) {
        player.sendMessage("The weapon whispers in your ear... you feel a chill..");
    }
}
