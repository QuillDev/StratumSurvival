package moe.quill.stratumsurvival.Crafting.Items.Attributes.OnDeathAttributes;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.Attribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public abstract class OnDeathAttribute extends Attribute {

    public OnDeathAttribute(
            Plugin plugin,
            MaterialManager materialManager,
            IKeyManager keyManager,
            ISerializer serializer,
            ItemLists itemLists,
            AttributeKey key,
            Component lore,
            float scaleValue,
            float minRoll,
            float maxRoll
    ) {
        super(
                plugin,
                materialManager,
                keyManager,
                serializer,
                itemLists,
                key,
                lore,
                //Weapons this attribute can be applied to
                new ArrayList<>(),
                scaleValue,
                minRoll,
                maxRoll,
                //TODO: Later might want to make weapon on death for bows and blunt separate
                new ArrayList<>()
        );
    }

    protected OnDeathAttributeData getEventData(Event sourceEvent) {
        if (!(sourceEvent instanceof EntityDeathEvent)) return null;
        final var event = (EntityDeathEvent) sourceEvent;
        final var target = event.getEntity();
        final var player = target.getKiller();
        if (player == null) return null;
        return new OnDeathAttributeData(player, target, event);
    }
}
