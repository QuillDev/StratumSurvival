package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseWeaponAttributes;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.WeaponUseAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Effects.KnockbackEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;

public class WeaponUseDashAttribute extends WeaponUseAttribute {
    private final KnockbackEffect knockbackEffect = new KnockbackEffect();

    public WeaponUseDashAttribute(MaterialManager materialManager,
                                  IKeyManager keyManager,
                                  ISerializer serializer,
                                  ItemLists itemLists
    ) {
        super(
                materialManager,
                keyManager,
                serializer,
                itemLists,
                AttributeKey.USE_DASH_ATTRIBUTE,
                Component.text("Dash").color(TextColor.color(0x53CB35)),
                0f,
                15 * 20
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var useEventData = getEventData(sourceEvent, true, true);
        if (useEventData == null) return;

        var player = useEventData.getPlayer();

        knockbackEffect.execute(useEventData.getEvent(), player, -1.5f);
    }
}
