package moe.quill.stratumsurvival.Crafting.Items.MaterialManager;

import com.destroystokyo.paper.profile.ProfileProperty;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class HeadHelper {

    public static ItemStack getHeadFromTexture(String textureString) {
        final var item = new ItemStack(Material.PLAYER_HEAD);
        final var meta = (SkullMeta) item.getItemMeta();
        final var profile = Bukkit.createProfile(UUID.randomUUID(), null);
        final var propertyMap = profile.getProperties();
        propertyMap.add(new ProfileProperty("textures", textureString));
        meta.setPlayerProfile(profile);
        item.setItemMeta(meta);
        return item;
    }
}
