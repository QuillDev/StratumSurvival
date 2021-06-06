package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseWeaponAttributes;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.WeaponUseAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Effects.CloakEffect;
import moe.quill.stratumsurvival.Crafting.Items.Effects.KnockbackEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;

public class WeaponUseShadowDodgeAttribute extends WeaponUseAttribute {

    public final static CloakEffect cloakEffect = new CloakEffect();
    public final static KnockbackEffect knockbackEffect = new KnockbackEffect();

    public WeaponUseShadowDodgeAttribute(
            Plugin plugin,
            MaterialManager materialManager,
            IKeyManager keyManager,
            ISerializer serializer,
            ItemLists itemLists
    ) {
        super(
                plugin,
                materialManager,
                keyManager,
                serializer,
                itemLists,
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
