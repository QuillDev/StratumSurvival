package tech.quilldev.CustomItemsv2.Attributes.UseAttributes.UseAttributeHelpers;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import tech.quilldev.CustomItemsv2.Attributes.Attribute;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class UseAttribute extends Attribute {

    protected long cooldown;

    public UseAttribute(NamespacedKey key, Component lore, float scaleValue, long cooldown) {
        super(key, lore, new ArrayList<>(), scaleValue, 0, 0, new ArrayList<>());
        this.cooldown = cooldown;
    }

    @Override
    public int getMinLevel() {
        return 4;
    }

    //Materials that we disallow right clicks on
    private final ArrayList<Material> blacklistedMaterials = new ArrayList<>(
            Arrays.asList(
                    Material.CRAFTING_TABLE,
                    Material.ANVIL,
                    Material.SMITHING_TABLE,
                    Material.ENCHANTING_TABLE,
                    Material.CHEST,
                    Material.GRINDSTONE
            )
    );

    /**
     * Get the data for the use event
     *
     * @param sourceEvent    to base the event on
     * @param allowAirClicks whether to allow clicking in the air
     * @return the usable data for this use event
     */
    protected UseEventData getEventData(Event sourceEvent, boolean allowAirClicks, boolean disallowBlacklistedBlocks) {
        if (!(sourceEvent instanceof PlayerInteractEvent)) return null;
        final var event = (PlayerInteractEvent) sourceEvent;
        final var player = event.getPlayer();
        final var action = event.getAction();

        //If we're not allowing air clicks and the action is a air click, return null
        if (!allowAirClicks && action.equals(Action.RIGHT_CLICK_AIR)) return null;

        //Check if we did a right click, if we didnt return null
        if (!(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK))) return null;

        //Disallow right clicking certain inventory blocks
        if (disallowBlacklistedBlocks && action.equals(Action.RIGHT_CLICK_BLOCK)) {
            final var clickedBlock = event.getClickedBlock();
            if (clickedBlock == null) return null;
            if (blacklistedMaterials.contains(clickedBlock.getType())) return null;
        }

        return new UseEventData(event, player, action);
    }
}
