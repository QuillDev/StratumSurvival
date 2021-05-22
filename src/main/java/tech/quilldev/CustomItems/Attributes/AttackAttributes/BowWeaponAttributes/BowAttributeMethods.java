package tech.quilldev.CustomItems.Attributes.AttackAttributes.BowWeaponAttributes;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tech.quilldev.CustomItems.Attributes.AttackAttributes.BowWeaponAttributes.BowAttributeHelpers.BowEventData;
import tech.quilldev.CustomItems.MaterialManager.StratumMaterials.WeaponHelpers.WeaponLists;

public class BowAttributeMethods {

    /**
     * Get all data required about the current event
     *
     * @param sourceEvent to get data from
     * @return required data to execute the event
     */
    public BowEventData getEventData(Event sourceEvent) {
        if (!(sourceEvent instanceof EntityDamageByEntityEvent)) return null; //if it's not a damage event, return
        final var event = (EntityDamageByEntityEvent) sourceEvent;
        if (!((event.getDamager()) instanceof Arrow)) return null; //if the damager is not an arrow, return
        final var arrow = (Arrow) event.getDamager();
        if (!(arrow.getShooter() instanceof Player)) return null; //If the player is not
        final var shooter = (Player) arrow.getShooter();
        if (shooter == null) return null; //if the shooter is null return null
        final var bow = shooter.getInventory().getItemInMainHand();

        //Make sure the held item is a bow
        var match = false;
        for (final var weapon : WeaponLists.WEAPONS_BOW) {
            if (weapon.getType().equals(bow.getType())) {
                match = true;
                break;
            }
        }
        if (!match) return null; //if the weapon is not a valid type, return

        //Get the bow item meta and make sure it has custom data
        final var bowMeta = bow.getItemMeta();
        final var bowData = bowMeta.getPersistentDataContainer();
        if (bowData.getKeys().size() == 0) return null;

        return new BowEventData(shooter, arrow, bow, event);
    }
}
