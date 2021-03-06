package moe.quill.stratumsurvival.Crafting.Items.Attributes.ToolAttributes.MiningAttributes.PickaxeAttributes;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;

public class PickaxeDoubleDropsAttribute extends PickaxeAttribute {
    public PickaxeDoubleDropsAttribute(
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
                AttributeKey.PICKAXE_DOUBLE_DROP_ATTRIBUTE,
                Component.text("Double Drops"),
                .2f,
                .1f,
                1f
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        if (modifier < rand.nextFloat()) return;
        final var eventData = getEventData(sourceEvent);
        if (eventData == null) return;

        //Just drop another set of the drops
        final var block = eventData.getBlock();
        final var location = block.getLocation();
        final var world = location.getWorld();
        final var player = eventData.getPlayer();
        eventData.getDrops().forEach(drop -> {
            world.dropItemNaturally(location, drop); //Drop items naturally at the given location
            drop.setAmount(drop.getAmount() * 2); //Double drops for the next event that picks this up
        });
        player.sendActionBar(Component.text("Your pickaxe managed to harvest twice the ore!"));
    }

    @Override
    public String dataFormat(float data) {
        return attributeFormatter.formatPercent(data);
    }
}
