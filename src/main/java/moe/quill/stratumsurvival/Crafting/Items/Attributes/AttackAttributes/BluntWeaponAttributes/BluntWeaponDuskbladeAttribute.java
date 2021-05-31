package moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Effects.BonusDamageEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.StratumCommon.KeyManager.IKeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;

public class BluntWeaponDuskbladeAttribute extends BluntWeaponAttribute {
    private static final BonusDamageEffect bonusDamageEffect = new BonusDamageEffect();

    public BluntWeaponDuskbladeAttribute(MaterialManager materialManager, IKeyManager keyManager) {
        super(
                materialManager,
                keyManager,
                AttributeKey.BLUNT_WEAPON_DUSKBLADE_ATTRIBUTE,
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
