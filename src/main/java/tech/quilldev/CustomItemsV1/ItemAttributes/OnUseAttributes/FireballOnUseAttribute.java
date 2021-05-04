package tech.quilldev.CustomItemsV1.ItemAttributes.OnUseAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

public class FireballOnUseAttribute extends OnUseAttribute {
    public FireballOnUseAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(Player player) {
        var fireball = player.launchProjectile(Fireball.class);
        fireball.setVelocity(fireball.getVelocity().multiply(2));
    }
}
