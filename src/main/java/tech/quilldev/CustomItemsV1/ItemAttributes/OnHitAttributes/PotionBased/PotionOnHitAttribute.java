package tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.PotionBased;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.OnHitAttribute;

public class PotionOnHitAttribute extends OnHitAttribute {

    private final Component flavorText;
    private final PotionEffect effect;

    public PotionOnHitAttribute(NamespacedKey key,
                                Component displayText,
                                PotionEffect effect,
                                Component flavorText
    ) {
        super(key, displayText);
        this.flavorText = flavorText;
        this.effect = effect;
    }

    @Override
    public void execute(EntityDamageByEntityEvent event, float modifier) {
        if (!(event.getDamager() instanceof Player)) return;
        if (modifier < rand.nextFloat()) return;

        final var player = ((Player) event.getDamager()).getPlayer();
        if (player == null) return;
        if (!(event.getEntity() instanceof LivingEntity)) return;

        //Give the enemy the potion effect
        final var entity = ((LivingEntity) event.getEntity());
        entity.addPotionEffect(this.effect);



        //send a message that you withered the opponent
        player.sendMessage(
                Component.text("You")
                        .append(Component.space())
                        .append(flavorText)
                        .append(Component.space())
                        .append(Component.text("your opponent!"))
        );
    }
}
