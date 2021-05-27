package moe.quill.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.Effects.KnockbackEffect;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;

public class BluntWeaponFeintAttribute extends BluntWeaponAttribute {

    public final static KnockbackEffect knockbackEffect = new KnockbackEffect();

    public BluntWeaponFeintAttribute(MaterialManager materialManager, KeyManager keyManager) {
        super(
                materialManager,
                keyManager,
                AttributeKey.BLUNT_WEAPON_FEINT_ATTRIBUTE,
                Component.text("Feint").color(TextColor.color(0x4D1DCB)),
                0f,
                0f,
                0f
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent);
        if (eventData == null) return;

        var player = eventData.getPlayer();

        knockbackEffect.execute(eventData.getEvent(), player, .5f);
    }

}
