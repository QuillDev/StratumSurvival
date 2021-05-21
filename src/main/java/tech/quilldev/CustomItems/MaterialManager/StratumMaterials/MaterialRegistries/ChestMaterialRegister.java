package tech.quilldev.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries;

import com.destroystokyo.paper.profile.ProfileProperty;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import tech.quilldev.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;

import java.util.HashMap;
import java.util.UUID;

public class ChestMaterialRegister extends MaterialRegistry {


    public ChestMaterialRegister(NamespacedKey itemKey) {
        super(itemKey);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{
            final var commonChestData = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDdlYzQxZTBkZjhlMTcwZDk3ZjliOWFmMWQ2NWVkYWQ0OTc5Yzc4Yzg5YjAxYjE4MGYzODllZTA4YTYxYWY4MiJ9fX0=";
            final var uncommonChestData = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWFmOGRhYWRjZGRiMDg4YThlZDg3NTliYTAyNzcwZDcyODIxNGYwN2NkZDkzYTYzMGI4ZTdkM2NhMDM3M2RjIn19fQ==";
            final var rareChestData = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmQwYmRmMzliNTRmNDk2OTJmYjM3OWI0ZWIwNGQxZWI0YTAwZTc4ZWQzOTExYWQzYjYzYTdlNWJmMzE3NjgzNyJ9fX0=";
            final var epicChestData = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmE2ZGFjODAzNWQzNjFiYTdmMmMyYTYxNGI0ZWJhYWZjMWU1ZTMxMDFmODViZWVmNjgzNTM2ZjMzN2U1MDkwIn19fQ==";
            final var legendaryChestData = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmVlNGE1Y2Q0ZWU2ZTk4OWE2M2RjNDFjNGI0MGQ4M2YwZDU4NTk4ZTdlY2RmMmM5NGRmZWVjMGFkYTAyZWM5MyJ9fX0=";

            put(StratumMaterial.CHEST_COMMON.name(), getHeadForTextureString(commonChestData));
            put(StratumMaterial.CHEST_UNCOMMON.name(), getHeadForTextureString(uncommonChestData));
            put(StratumMaterial.CHEST_RARE.name(), getHeadForTextureString(rareChestData));
            put(StratumMaterial.CHEST_EPIC.name(), getHeadForTextureString(epicChestData));
            put(StratumMaterial.CHEST_LEGENDARY.name(), getHeadForTextureString(legendaryChestData));
        }};
    }

    private ItemStack getHeadForTextureString(String textureString) {
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

