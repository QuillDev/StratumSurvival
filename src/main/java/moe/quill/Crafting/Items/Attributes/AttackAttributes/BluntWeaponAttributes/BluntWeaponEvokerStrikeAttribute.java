package moe.quill.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import moe.quill.Crafting.Items.Effects.SpawnEntityEffect;

public class BluntWeaponEvokerStrikeAttribute extends BluntWeaponAttribute {

    SpawnEntityEffect evokerFangEffect = new SpawnEntityEffect();

    public BluntWeaponEvokerStrikeAttribute(MaterialManager materialManager, KeyManager keyManager) {
        super(
                materialManager,
                keyManager,
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
