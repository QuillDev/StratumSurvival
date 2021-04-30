package tech.quilldev.ItemAttributes.UseAttribute;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public class ZeusEffect extends UseAttribute {

    public ZeusEffect(NamespacedKey key) {
        super(key);
    }

    @Override
    public void execute(Player player) {
        final var target = player.getTargetBlock(50);
        assert target != null;
        player.getWorld().strikeLightning(target.getLocation());
    }
}
