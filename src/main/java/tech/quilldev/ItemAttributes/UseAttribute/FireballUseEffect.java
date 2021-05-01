package tech.quilldev.ItemAttributes.UseAttribute;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

public class FireballUseEffect extends UseAttribute{
    public FireballUseEffect(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(Player player) {
        var fireball = player.launchProjectile(Fireball.class);
        fireball.setVelocity(fireball.getVelocity().multiply(2));
    }
}
