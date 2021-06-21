package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.GlobalKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class WeaponUseAttribute extends UseAttribute {

    protected long cooldown;
    protected final NamespacedKey cooldownKey;

    public WeaponUseAttribute(
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
                new ArrayList<>(),
                scaleValue,
                0
        );
        this.cooldown = cooldown;
        this.cooldownKey = keyManager.getKey(GlobalKey.COOLDOWN_KEY);
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
        final var heldItem = player.getInventory().getItemInMainHand();
        final var heldItemMeta = heldItem.getItemMeta();
        final var heldItemData = heldItemMeta.getPersistentDataContainer();

        //If the held item has no cooldown key, return null
        if (!heldItemData.has(cooldownKey, PersistentDataType.BYTE_ARRAY)) return null;

        //Do cool down calculations
        final var lastTickBytes = heldItemData.get(cooldownKey, PersistentDataType.BYTE_ARRAY);
        final var lastTick = serializer.deserializeLong(lastTickBytes);
        final var curTick = Bukkit.getCurrentTick();
        final var deltaTicks = curTick - lastTick;

        //If cool down is not over yet, return null
        if (deltaTicks <= cooldown) {
            final var ticksLeft = (cooldown - deltaTicks) / 20;
            player.sendActionBar(
                    Component.text("This attribute is not yet off cooldown!")
                            .append(Component.space())
                            .append(Component.text(ticksLeft + "s"))
                            .color(TextColor.color(0xFF5C4B))
            );
            return null;
        }

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

        //Write the new cool down to the key
        heldItemData.set(cooldownKey, PersistentDataType.BYTE_ARRAY, serializer.serializeLong(curTick));
        heldItem.setItemMeta(heldItemMeta);
        return new UseEventData(event, player, action);
    }
}
