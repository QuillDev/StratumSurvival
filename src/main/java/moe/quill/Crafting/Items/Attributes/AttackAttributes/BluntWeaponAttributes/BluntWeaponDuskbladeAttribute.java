package moe.quill.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.Effects.BonusDamageEffect;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

public class BluntWeaponDuskbladeAttribute extends BluntWeaponAttribute{
    private static final BonusDamageEffect bonusDamageEffect = new BonusDamageEffect();

    public BluntWeaponDuskbladeAttribute() {
        super(AttributeKey.BLUNT_WEAPON_DUSKBLADE_ATTRIBUTE,
                Component.text("Duskblade").color(TextColor.color(0x3E607C)),
                0f,
                0f,
                0f
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent);
        if (eventData == null) return;

        var time = eventData.getPlayer().getWorld().getTime();

        if (time < 13000 && time > 1000) return;

        bonusDamageEffect.execute(sourceEvent, 1);
    }
}