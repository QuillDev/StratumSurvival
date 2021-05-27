package moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.HelperItemRegistries;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

@SuppressWarnings("unused")
public class BlockadeRegistry extends MaterialRegistry {
    public BlockadeRegistry(KeyManager keyManager) {
        super(keyManager, MaterialKey.BLOCKADE_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{
            final var BLOCKADE = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            final var BLOCKADE_META = BLOCKADE.getItemMeta();
            BLOCKADE_META.displayName(Component.text("LOCKED").decorate(TextDecoration.BOLD).color(TextColor.color(0xF93A30)));
            BLOCKADE.setItemMeta(BLOCKADE_META);
            put(StratumMaterial.BLOCKADE.name(), BLOCKADE);
        }};
    }
}
