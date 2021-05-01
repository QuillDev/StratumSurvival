package tech.quilldev.ItemAttributes.UseAttribute;

<<<<<<< HEAD
import net.kyori.adventure.text.Component;
=======
>>>>>>> e1a96f74a8400e4116704aca7859de6ea5c9abcc
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RegenUseEffect extends UseAttribute{
<<<<<<< HEAD
    public RegenUseEffect(NamespacedKey key, Component component) {
        super(key, component);
=======
    public RegenUseEffect(NamespacedKey key) {
        super(key);
>>>>>>> e1a96f74a8400e4116704aca7859de6ea5c9abcc
    }

    @Override
    public void execute(Player player) {

        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 2));
    }
}
