package moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.Attribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.OnDeathAttributes.OnDeathAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AttackAttribute extends Attribute {
    public AttackAttribute(
            MaterialManager materialManager,
            IKeyManager keyManager,
            ISerializer serializer,
            ItemLists itemLists,
            AttributeKey key,
            Component lore,
            ArrayList<ItemStack> itemStacks,
            float scaleValue,
            float minRoll,
            float maxRoll
    ) {
        super(
                materialManager,
                keyManager,
                serializer,
                itemLists,
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
