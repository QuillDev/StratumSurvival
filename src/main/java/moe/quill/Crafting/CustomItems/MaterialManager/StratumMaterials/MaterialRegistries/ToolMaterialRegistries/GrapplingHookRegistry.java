package moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries.ToolMaterialRegistries;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.MaterialRegistries.MaterialRegistry;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("unused")
public class GrapplingHookRegistry extends MaterialRegistry {
    public GrapplingHookRegistry() {
        super(MaterialKey.GRAPPLING_HOOK_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{
            final var GRAPPLING_HOOK_LORE = new ArrayList<Component>() {{
                add(Component.text("It's like I'm flying! - Quill").color(TextColor.color(0x5FA5CB)));
            }};

            final var GRAPPLING_HOOK = new ItemStack(Material.FISHING_ROD);
            final var GRAPPLING_HOOK_META = GRAPPLING_HOOK.getItemMeta();
            GRAPPLING_HOOK_META.setCustomModelData(1);
            GRAPPLING_HOOK_META.setLocalizedName("Grappling Hook");
            GRAPPLING_HOOK_META.displayName(Component.text("Grappling Hook"));
            GRAPPLING_HOOK_META.lore(GRAPPLING_HOOK_LORE);
            GRAPPLING_HOOK.setItemMeta(GRAPPLING_HOOK_META);

            final var choice = new RecipeChoice.MaterialChoice(Material.NAUTILUS_SHELL);
            put(StratumMaterial.GRAPPLING_HOOK.name(), GRAPPLING_HOOK);
        }};
    }
}
