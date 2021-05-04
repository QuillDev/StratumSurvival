package tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.PotionBased;

import com.destroystokyo.paper.ParticleBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.OnHitAttribute;

public class PotionOnHitAttributeWithParticle extends OnHitAttribute {
    private final Component flavorText;
    private final PotionEffect effect;
    private final Particle particle;

    public PotionOnHitAttributeWithParticle(NamespacedKey key,
                                Component displayText,
                                PotionEffect effect,
                                Component flavorText,
                                Particle particle
    ) {
        super(key, displayText);
        this.flavorText = flavorText;
        this.effect = effect;
        this.particle = particle;
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

        var builder = new ParticleBuilder(particle)
                .location(entity.getLocation())
                .count(60)
                .spawn()
                .count(15)
                .particle(Particle.REDSTONE)
                .color(Color.LIME)
                .spawn()
                ;

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

