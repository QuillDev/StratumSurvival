package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.UseAoeSpell;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseEventData;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.UseSpellAttributes;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Event;

public abstract class UseAoeSpell extends UseSpellAttributes {
    public UseAoeSpell(
            MaterialManager materialManager,
            IKeyManager keyManager,
            ISerializer serializer,
            ItemLists itemLists,
            AttributeKey key,
            Component lore,
            float scaleValue,
            long cooldown
    ) {
        super(materialManager, keyManager, serializer, itemLists, key, lore, scaleValue, cooldown);
    }

    protected AoeSpellEventData getEventData(Event sourceEvent, boolean allowAirClicks, boolean blacklistBlocks, float range, boolean pvp) {
        final var parentData = super.getEventData(sourceEvent, allowAirClicks, blacklistBlocks);
        if (parentData == null) return null;
        return new AoeSpellEventData(parentData.getEvent(), parentData.getPlayer(), parentData.getEvent().getAction(), range, pvp);
    }
}
