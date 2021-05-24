package moe.quill.Crafting.CustomItems.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.Crafting.CustomItems.Effects.ChainDamageEffect;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

public class BluntWeaponChainAttribute extends BluntWeaponAttribute {

    private static final ChainDamageEffect chainDamageEffect = new ChainDamageEffect();

    public BluntWeaponChainAttribute(NamespacedKey key) {
        super(key,
                Component.text("Chain Damage").color(TextColor.color(0xe04bfa)),
                .17f,
                .1f,
                1f
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
        chainDamageEffect.execute(eventData.getEvent(), 5, modifier / 2f);
    }
}