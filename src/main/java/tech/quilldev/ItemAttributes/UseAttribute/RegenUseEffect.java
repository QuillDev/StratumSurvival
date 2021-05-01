package tech.quilldev.ItemAttributes.UseAttribute;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RegenUseEffect extends UseAttribute{
    public RegenUseEffect(NamespacedKey key, Component component) {
        super(key, component);
    }

    @Override
    public void execute(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 2));
    }
}
