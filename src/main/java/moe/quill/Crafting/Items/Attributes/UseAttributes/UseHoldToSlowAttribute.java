package moe.quill.Crafting.Items.Attributes.UseAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import moe.quill.Crafting.Items.Effects.PotionBasedEffect;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffectType;

public class UseHoldToSlowAttribute extends UseAttribute {

    private final PotionBasedEffect potionBasedEffect = new PotionBasedEffect();

    public UseHoldToSlowAttribute(MaterialManager materialManager, KeyManager keyManager) {
        super(materialManager, keyManager, AttributeKey.USE_HOLD_SLOW_FALL_ATTRIBUTE,
                Component.text("Glide").color(TextColor.color(0x2BCBC6)),
                0f,
                0 * 20);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var useEventData = getEventData(sourceEvent, true, true);
        if (useEventData == null) return;

        var player = useEventData.getPlayer();

        potionBasedEffect.execute(sourceEvent, PotionEffectType.SLOW_FALLING, player, 10);
    }
}
