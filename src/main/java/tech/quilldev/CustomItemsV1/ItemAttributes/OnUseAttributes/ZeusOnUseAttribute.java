package tech.quilldev.CustomItemsV1.ItemAttributes.OnUseAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public class ZeusOnUseAttribute extends OnUseAttribute {

    public ZeusOnUseAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(Player player) {
        final var target = player.getTargetBlock(50);
        assert target != null;
        player.getWorld().strikeLightning(target.getLocation());
    }
}
