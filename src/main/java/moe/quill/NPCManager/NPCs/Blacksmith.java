package moe.quill.NPCManager.NPCs;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Villager;

public class Blacksmith extends NPC {
    public Blacksmith(NamespacedKey key) {
        super(Villager.Profession.WEAPONSMITH, key);
    }
}
