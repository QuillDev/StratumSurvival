package moe.quill.Crafting.Items.Attributes.UseAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import moe.quill.Crafting.Items.Effects.CloakEffect;
import moe.quill.Crafting.Items.Effects.KnockbackEffect;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;

public class UseShadowDodgeAttribute extends UseAttribute {

    public final static CloakEffect cloakEffect = new CloakEffect();
    public final static KnockbackEffect knockbackEffect = new KnockbackEffect();

    public UseShadowDodgeAttribute(MaterialManager materialManager, KeyManager keyManager) {
        super(
                materialManager,
                keyManager,
                AttributeKey.USE_SHADOW_DODGE_ATTRIBUTE,
                Component.text("Shadow Dodge").color(TextColor.color(0x3F0BCB)),
                0f,
                100L);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var useEventData = getEventData(sourceEvent, true, true);
        if (useEventData == null) return;

        var player = useEventData.getPlayer();

        knockbackEffect.execute(useEventData.getEvent(), player, .5f);
        cloakEffect.execute(useEventData.getEvent(), 15);
    }

}
