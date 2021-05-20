package tech.quilldev.CustomItems.Attributes.AttackAttributes.BluntWeaponAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItems.Effects.EvokerFangEffect;

public class BluntWeaponEvokerStrikeAttribute extends BluntWeaponAttribute {

    EvokerFangEffect evokerFangEffect = new EvokerFangEffect();

    public BluntWeaponEvokerStrikeAttribute(NamespacedKey key) {
        super(key,
                Component.text("Evoker Strike").color(TextColor.color(0x555755)),
                .1f,
                .1f,
                .5f
        );
    }

    @Override
    public String dataFormat(float value) {
        return attributeFormatter.formatPercent(value);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent);
        if (eventData == null) return;
        if (modifier < rand.nextFloat()) return;
        evokerFangEffect.execute(eventData.getEvent());
    }
}
