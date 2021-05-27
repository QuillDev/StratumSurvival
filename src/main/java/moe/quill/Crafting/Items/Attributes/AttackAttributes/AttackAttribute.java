package moe.quill.Crafting.Items.Attributes.AttackAttributes;

import moe.quill.Crafting.Items.Attributes.Attribute;
import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.Attributes.OnDeathAttributes.OnDeathAttribute;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import moe.quill.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AttackAttribute extends Attribute {
    public AttackAttribute(AttributeKey key, Component lore, ArrayList<ItemStack> itemStacks, float scaleValue, float minRoll, float maxRoll) {
        super(
                key,
                lore,
                itemStacks,
                scaleValue,
                minRoll,
                maxRoll,
                new ArrayList<>(Arrays.asList(
                        UseAttribute.class,
                        OnDeathAttribute.class
                )));
    }

    /**
     * Get the event data for the current event
     *
     * @param sourceEvent to get data from
     * @return the data for the event
     */
    public AttackEventData getEventData(Event sourceEvent) {
        if (!(sourceEvent instanceof EntityDamageByEntityEvent)) return null;
        final var event = (EntityDamageByEntityEvent) sourceEvent;
        //Make sure the target is a living entity
        final var targetEntity = event.getEntity();
        if (!(targetEntity instanceof LivingEntity)) return null;
        //Get the damager + the entity we need for the event data
        final var entity = (LivingEntity) targetEntity;
        final var damager = event.getDamager();
        if (!(damager instanceof Player)) return null;
        final var player = ((Player) damager).getPlayer();

        return new AttackEventData(player, entity, event);
    }

    public abstract void execute(Event sourceEvent, float modifier);
}
