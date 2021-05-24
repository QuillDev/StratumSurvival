package moe.quill.Crafting.CustomItems.Attributes.ToolAttributes.MiningAttributes.PickaxeAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

public class PickaxeDoubleDropsAttribute extends PickaxeAttribute {
    public PickaxeDoubleDropsAttribute(
            NamespacedKey key
    ) {
        super(key, Component.text("Double Drops"), .2f, .1f, 1f);
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
