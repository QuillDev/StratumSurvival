package moe.quill.Adventuring.Enemies.ZombieBased;

import moe.quill.Crafting.CustomItems.MaterialManager.HeadHelper;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Zombie;

public class Pirate extends ZombieEnemy {

    public Pirate() {
        super(Component.text("Pirate"));
    }

    @Override
    public Zombie spawn(Location location) {
        final var mob = super.spawn(location);
        final var mobEquipment = mob.getEquipment();
        if (mobEquipment == null) return null;
        mobEquipment.setHelmet(HeadHelper.getHeadFromTexture(
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjE3OWIwMzk5NjQyOTg2NDRjYzRkNGYwOGFlNWY1YTMxNWRkOWJjNTZjMTY3ZDk3ZDI0MTkxOTJmYzc0ZGU5YyJ9fX0="
        ));
        return mob;
    }
}
