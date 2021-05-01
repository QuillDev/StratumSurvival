package tech.quilldev.ItemAttributes.OnUseAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CloakOnUseAttribute extends OnUseAttribute {
    public CloakOnUseAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(Player player) {

        final  var duration = 45;

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, duration, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, duration + 15, 1));
    }
}
