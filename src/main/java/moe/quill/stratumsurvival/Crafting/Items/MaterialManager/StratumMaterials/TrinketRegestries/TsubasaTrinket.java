package moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.TrinketRegestries;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.HashMap;

public class TsubasaTrinket extends TrinketRegistry {

    public TsubasaTrinket(IKeyManager keyManager, ISerializer serializer) {
        super(keyManager, serializer, MaterialKey.TSUBASA_TRINKET_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{
            final var tsubasaLore = Component.text("It feels like I'm flying! - Quill").color(TextColor.color(0x2EA2CB));
            final var TSUBASA_TRINKET = new ItemStack(Material.GOLD_NUGGET);
            final var TSUBASA_TRINKET_META = TSUBASA_TRINKET.getItemMeta();
            TSUBASA_TRINKET_META.lore(Collections.singletonList(tsubasaLore));
            TSUBASA_TRINKET.setItemMeta(TSUBASA_TRINKET_META);
            put(StratumMaterial.TSUBASA_TRINKET.name(), TSUBASA_TRINKET);
        }};
    }
}
