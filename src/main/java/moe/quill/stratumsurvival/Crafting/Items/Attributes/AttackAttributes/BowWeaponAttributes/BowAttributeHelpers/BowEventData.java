package moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes.BowWeaponAttributes.BowAttributeHelpers;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class BowEventData {

    private final LivingEntity shooter;
    private final Arrow arrow;
    private final ItemStack bow;
    private final EntityDamageByEntityEvent event;

    public BowEventData(LivingEntity shooter, Arrow arrow, ItemStack bow, EntityDamageByEntityEvent event) {
        this.shooter = shooter;
        this.arrow = arrow;
        this.bow = bow;
        this.event = event;
    }

    public LivingEntity getShooter() {
        return shooter;
    }

    public Arrow getArrow() {
        return arrow;
    }

    public EntityDamageByEntityEvent getEvent() {
        return event;
    }

    public ItemStack getBow() {
        return bow;
    }
}

