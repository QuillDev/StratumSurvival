package moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries;

import moe.quill.Crafting.Items.MaterialManager.HeadHelper;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.KeyManager;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ChestMaterialRegister extends MaterialRegistry {


    public ChestMaterialRegister(KeyManager keyManager) {
        super(keyManager, MaterialKey.LOOT_CHEST_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{
            final var commonChestData = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDdlYzQxZTBkZjhlMTcwZDk3ZjliOWFmMWQ2NWVkYWQ0OTc5Yzc4Yzg5YjAxYjE4MGYzODllZTA4YTYxYWY4MiJ9fX0=";
            final var uncommonChestData = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWFmOGRhYWRjZGRiMDg4YThlZDg3NTliYTAyNzcwZDcyODIxNGYwN2NkZDkzYTYzMGI4ZTdkM2NhMDM3M2RjIn19fQ==";
            final var rareChestData = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmQwYmRmMzliNTRmNDk2OTJmYjM3OWI0ZWIwNGQxZWI0YTAwZTc4ZWQzOTExYWQzYjYzYTdlNWJmMzE3NjgzNyJ9fX0=";
            final var epicChestData = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmE2ZGFjODAzNWQzNjFiYTdmMmMyYTYxNGI0ZWJhYWZjMWU1ZTMxMDFmODViZWVmNjgzNTM2ZjMzN2U1MDkwIn19fQ==";
            final var legendaryChestData = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmVlNGE1Y2Q0ZWU2ZTk4OWE2M2RjNDFjNGI0MGQ4M2YwZDU4NTk4ZTdlY2RmMmM5NGRmZWVjMGFkYTAyZWM5MyJ9fX0=";

            put(StratumMaterial.CHEST_COMMON.name(), HeadHelper.getHeadFromTexture(commonChestData));
            put(StratumMaterial.CHEST_UNCOMMON.name(), HeadHelper.getHeadFromTexture(uncommonChestData));
            put(StratumMaterial.CHEST_RARE.name(), HeadHelper.getHeadFromTexture(rareChestData));
            put(StratumMaterial.CHEST_EPIC.name(), HeadHelper.getHeadFromTexture(epicChestData));
            put(StratumMaterial.CHEST_LEGENDARY.name(), HeadHelper.getHeadFromTexture(legendaryChestData));
        }};
    }
}

