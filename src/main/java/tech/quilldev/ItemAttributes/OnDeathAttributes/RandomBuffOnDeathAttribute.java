package tech.quilldev.ItemAttributes.OnDeathAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.ArrayList;
import java.util.Arrays;

public class RandomBuffOnDeathAttribute extends OnDeathAttribute{

    static class Effects {
        public PotionEffectType type;
        public String text;
        Effects(PotionEffectType type, String text) {this.type = type; this.text = text;}
    }

    private final ArrayList<Effects> effectsArrayList = new ArrayList<>(Arrays.asList(
            new Effects(PotionEffectType.SPEED, "Speed"),
            new Effects(PotionEffectType.NIGHT_VISION, "Night Vision"),
            new Effects(PotionEffectType.INCREASE_DAMAGE, "Damage Boost"),
            new Effects(PotionEffectType.SLOW, "Slowness"),
            new Effects(PotionEffectType.BLINDNESS, "Blindness"),
            new Effects(PotionEffectType.WEAKNESS, "Weakness")
    )) ;

    public RandomBuffOnDeathAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    @Override
    public void execute(EntityDeathEvent deathEvent) {

        final var modifier = .15f;
        final var index = rand.nextInt(effectsArrayList.size());
        final var effect = effectsArrayList.get(index);
        final var killer = deathEvent.getEntity().getKiller();

        //check that the entity was killed by a player
        if (killer == null) return;
        //check to see if the Attribute activates
        if(modifier <= rand.nextFloat()) return;

        killer.addPotionEffect(new PotionEffect(effect.type, 150, 1));

        //send a message that you effected the opponent
        killer.sendMessage(
                Component.text("You were")
                        .append(Component.space())
                        .append(Component.text((index < 3) ? "BLESSED" : "CURSED").color(TextColor.color(0x2E0E84)))
                        .append(Component.space())
                        .append(Component.text("with"))
                        .append(Component.space())
                        .append(Component.text(effect.text).color(TextColor.color(0x2E0E84)))
                        .append(Component.text("!"))
        );
    }
}
