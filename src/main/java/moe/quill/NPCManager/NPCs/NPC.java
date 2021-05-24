package moe.quill.NPCManager.NPCs;

import moe.quill.Serialization.StratumSerialization;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.persistence.PersistentDataType;

public class NPC {

    private final Villager.Profession profession;
    private final NamespacedKey key;

    public NPC(Villager.Profession profession, NamespacedKey key) {
        this.profession = profession;
        this.key = key;
    }

    /**
     * Spawn the npc at the given location and write any keys to it
     *
     * @param location to spawn the villager
     */
    public void spawn(Location location, Component name) {
        final var world = location.getWorld();
        final var villager = (Villager) world.spawnEntity(location, EntityType.VILLAGER);
        villager.customName(name);
        villager.setProfession(this.profession);
        villager.setInvulnerable(true);
        villager.setAI(false);

        //Get the data container
        final var data = villager.getPersistentDataContainer();
        data.set(key, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeBoolean(true));
    }

    public NamespacedKey getKey() {
        return key;
    }
}
