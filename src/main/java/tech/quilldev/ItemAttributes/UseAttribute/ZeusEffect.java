package tech.quilldev.ItemAttributes.UseAttribute;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public class ZeusEffect extends UseAttribute {

    public ZeusEffect(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(Player player) {
        final var target = player.getTargetBlock(50);
        assert target != null;
        player.getWorld().strikeLightning(target.getLocation());
    }
}
