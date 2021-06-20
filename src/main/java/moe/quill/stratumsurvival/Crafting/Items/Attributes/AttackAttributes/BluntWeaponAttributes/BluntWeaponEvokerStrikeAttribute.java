package moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Effects.SpawnEntityEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;

public class BluntWeaponEvokerStrikeAttribute extends BluntWeaponAttribute {

    SpawnEntityEffect evokerFangEffect = new SpawnEntityEffect();

    public BluntWeaponEvokerStrikeAttribute(
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
                AttributeKey.BLUNT_WEAPON_EVOKER_STRIKE_ATTRIBUTE,
                Component.text("Evoker Strike").color(TextColor.color(0x555755)),
                .1f,
                .1f,
                .5f
        );
    }

    @Override
    public String dataFormat(float value) {
        return attributeFormatter.formatPercent(value);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent);
        if (eventData == null) return;

        var target = eventData.getTarget();

        if (modifier < rand.nextFloat()) return;
        evokerFangEffect.execute(eventData.getEvent(), target.getLocation(), EntityType.EVOKER_FANGS);
    }
}
