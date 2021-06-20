package moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Effects.ChainDamageEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;

public class BluntWeaponChainAttribute extends BluntWeaponAttribute {

    private static final ChainDamageEffect chainDamageEffect = new ChainDamageEffect();

    public BluntWeaponChainAttribute(
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
                AttributeKey.BLUNT_WEAPON_CHAIN_ATTRIBUTE,
                Component.text("Chain Damage").color(TextColor.color(0xe04bfa)),
                .17f,
                .1f,
                1f
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
        if (modifier < rand.nextFloat()) return;
        chainDamageEffect.execute(eventData.getEvent(), 5, modifier / 2f);
    }
}
