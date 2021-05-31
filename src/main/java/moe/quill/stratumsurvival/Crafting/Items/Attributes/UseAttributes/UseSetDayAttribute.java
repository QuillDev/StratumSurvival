package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Effects.TimeSetEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;

@SuppressWarnings("unused")
public class UseSetDayAttribute extends UseAttribute {

    TimeSetEffect timeSetEffect = new TimeSetEffect();

    public UseSetDayAttribute(MaterialManager materialManager, IKeyManager keyManager) {
        super(
                materialManager,
                keyManager,
                AttributeKey.USE_SET_DAY_ATTRIBUTE,
                Component.text("Daniel's Bane").color(TextColor.color(0x214A2A)),
                0f,
                3600 * 20);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent, true, true);
        if (eventData == null) return;
        var player = eventData.getPlayer();

        timeSetEffect.execute(player.getLocation(), 1000);
    }
}
