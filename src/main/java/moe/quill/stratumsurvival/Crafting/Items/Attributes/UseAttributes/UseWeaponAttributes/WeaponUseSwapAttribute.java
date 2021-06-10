package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseWeaponAttributes;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.WeaponUseAttribute;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;

public class WeaponUseSwapAttribute extends WeaponUseAttribute {
    public WeaponUseSwapAttribute(Plugin plugin, MaterialManager materialManager, IKeyManager keyManager, ISerializer serializer, ItemLists itemLists) {
        super(
                plugin,
                materialManager,
                keyManager,
                serializer,
                itemLists,
                AttributeKey.USE_SWAP_ATTRIBUTE,
                Component.text("Swap").color(TextColor.color(0x00FFF7)),
                0,
                60
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        var eventData = getEventData(sourceEvent,true,true);
        if (eventData == null) return;
        var player = eventData.getPlayer();
        var entity = player.getTargetEntity(10);
        if (entity == null) return;
        var location = player.getLocation();
        player.teleport(entity);
        entity.teleport(location);
    }
}
