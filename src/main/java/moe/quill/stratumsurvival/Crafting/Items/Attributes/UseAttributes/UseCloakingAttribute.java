package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes;

import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Effects.CloakEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;

public class UseCloakingAttribute extends UseAttribute {

    private final static CloakEffect cloakEffect = new CloakEffect();

    public UseCloakingAttribute(MaterialManager materialManager, KeyManager keyManager) {
        super(materialManager, keyManager, AttributeKey.USE_CLOAKING_ATTRIBUTE,
                Component.text("Cloaking Mist").color(TextColor.color(0x3F0BCB)),
                0f,
                15 * 20);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent, true, true);
        if (eventData == null) return;
        cloakEffect.execute(eventData.getEvent(), 45);
    }
}
