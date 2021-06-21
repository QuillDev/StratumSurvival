package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.SpellAttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import moe.quill.stratumsurvival.Utils.Particles.ParticleFactory;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Event;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public abstract class UseSpellAttribute extends UseAttribute {

    protected final ParticleFactory particleFactory = new ParticleFactory();

    public UseSpellAttribute(
            Plugin plugin,
            MaterialManager materialManager,
            IKeyManager keyManager,
            ISerializer serializer,
            ItemLists itemLists,
            AttributeKey key,
            Component lore,
            float scaleValue,
            long cooldown
    ) {
        super(
                plugin,
                materialManager,
                keyManager,
                serializer,
                itemLists,
                key,
                lore,
                itemLists.getSpellWeapons(),
                scaleValue,
                cooldown);
    }

    @Override
    public String dataFormat(float data) {
        return attributeFormatter.formatBonusPercent(data);
    }

    protected SpellEventData getEventData(Event sourceEvent, boolean allowAirClicks, boolean disallowBlacklistedBlocks) {
        final var useEventData = super.getEventData(sourceEvent, allowAirClicks, disallowBlacklistedBlocks);
        if (useEventData == null) return null;
        final var player = useEventData.getPlayer();
        final var item = player.getInventory().getItemInMainHand();
        final var itemMeta = item.getItemMeta();
        if (itemMeta == null) return null;
        final var itemData = itemMeta.getPersistentDataContainer();

        //If the item data doesn't have the spell potency key return null
        if (!itemData.has(keyManager.getKey(SpellAttributeKey.SPELL_POTENCY), PersistentDataType.BYTE_ARRAY)) {
            return null;
        }
        final var potencyBytes = itemData.get(keyManager.getKey(SpellAttributeKey.SPELL_POTENCY), PersistentDataType.BYTE_ARRAY);
        final var potency = serializer.deserializeFloat(potencyBytes);
        if (Float.isNaN(potency)) return null;

        return new SpellEventData(useEventData, potency);
    }

    @Override
    public int getMinLevel() {
        return 0;
    }
}
