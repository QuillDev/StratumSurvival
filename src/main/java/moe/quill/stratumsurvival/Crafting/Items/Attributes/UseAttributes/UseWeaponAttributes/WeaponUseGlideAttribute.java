package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseWeaponAttributes;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.WeaponUseAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Effects.PotionBasedEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffectType;

public class WeaponUseGlideAttribute extends WeaponUseAttribute {
    private final PotionBasedEffect potionBasedEffect = new PotionBasedEffect();

    public WeaponUseGlideAttribute(MaterialManager materialManager,
                                   IKeyManager keyManager,
                                   ISerializer serializer,
                                   ItemLists itemLists
    ) {
        super(
                materialManager,
                keyManager,
                serializer,
                itemLists,
                AttributeKey.USE_HOLD_SLOW_FALL_ATTRIBUTE,
                Component.text("Glide").color(TextColor.color(0x88ABDA)),
                0f,
                0 * 20
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var useEventData = getEventData(sourceEvent, true, true);
        if (useEventData == null) return;

        var player = useEventData.getPlayer();

        potionBasedEffect.execute(sourceEvent, PotionEffectType.SLOW_FALLING, player, 10);
    }
}
