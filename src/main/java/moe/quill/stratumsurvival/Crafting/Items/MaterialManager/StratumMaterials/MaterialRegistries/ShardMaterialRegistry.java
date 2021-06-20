package moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialRegistries;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.GlobalKey;
import moe.quill.stratumsurvival.Crafting.Items.ItemHelpers.ItemRarity;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collections;
import java.util.HashMap;

public class ShardMaterialRegistry extends MaterialRegistry {

    private final NamespacedKey levelKey;

    public ShardMaterialRegistry(IKeyManager keyManager, ISerializer serializer) {
        super(keyManager, serializer, MaterialKey.SHARD_KEY);
        this.levelKey = keyManager.getKey(GlobalKey.LEVEL_KEY);
    }

    @Override
    public HashMap<String, ItemStack> getMaterials() {
        return new HashMap<>() {{
            final Component crystalLore = Component.text("Used for crafting");
            // Setup the common crystal
            final var SHARD_COMMON = new ItemStack(Material.EMERALD);
            final var SHARD_COMMON_META = SHARD_COMMON.getItemMeta();
            final var SHARD_COMMON_COLOR = ItemRarity.COMMON.getColor();
            SHARD_COMMON_META.setCustomModelData(1);
            SHARD_COMMON_META.displayName(Component.text("Common Shard").decorate(TextDecoration.BOLD).color(SHARD_COMMON_COLOR));
            SHARD_COMMON_META.lore(Collections.singletonList(crystalLore.color(SHARD_COMMON_COLOR)));
            SHARD_COMMON_META.getPersistentDataContainer().set(levelKey, PersistentDataType.FLOAT, 1f);
            SHARD_COMMON.setItemMeta(SHARD_COMMON_META);

            //Uncommon crafting crystal
            final var SHARD_UNCOMMON = new ItemStack(Material.EMERALD);
            final var SHARD_UNCOMMON_META = SHARD_UNCOMMON.getItemMeta();
            final var SHARD_UNCOMMON_COLOR = ItemRarity.UNCOMMON.getColor();
            SHARD_UNCOMMON_META.setCustomModelData(2);
            SHARD_UNCOMMON_META.displayName(Component.text("Uncommon Shard").decorate(TextDecoration.BOLD).color(SHARD_UNCOMMON_COLOR));
            SHARD_UNCOMMON_META.lore(Collections.singletonList(crystalLore.color(SHARD_UNCOMMON_COLOR)));
            SHARD_UNCOMMON_META.getPersistentDataContainer().set(levelKey, PersistentDataType.FLOAT, 2f);
            SHARD_UNCOMMON.setItemMeta(SHARD_UNCOMMON_META);

            // Rare crafting crystal
            final var SHARD_RARE = new ItemStack(Material.EMERALD);
            final var SHARD_RARE_META = SHARD_RARE.getItemMeta();
            final var SHARD_RARE_COLOR = ItemRarity.RARE.getColor();
            SHARD_RARE_META.setCustomModelData(3);
            SHARD_RARE_META.displayName(Component.text("Rare Shard").decorate(TextDecoration.BOLD).color(SHARD_RARE_COLOR));
            SHARD_RARE_META.lore(Collections.singletonList(crystalLore.color(SHARD_RARE_COLOR)));
            SHARD_RARE_META.getPersistentDataContainer().set(levelKey, PersistentDataType.FLOAT, 3f);
            SHARD_RARE.setItemMeta(SHARD_RARE_META);

            // Epic crafting crystal
            final var SHARD_EPIC = new ItemStack(Material.EMERALD);
            final var SHARD_EPIC_META = SHARD_EPIC.getItemMeta();
            final var SHARD_EPIC_COLOR = ItemRarity.EPIC.getColor();
            SHARD_EPIC_META.setCustomModelData(4);
            SHARD_EPIC_META.displayName(Component.text("Epic Shard").decorate(TextDecoration.BOLD).color(SHARD_EPIC_COLOR));
            SHARD_EPIC_META.lore(Collections.singletonList(crystalLore.color(SHARD_EPIC_COLOR)));
            SHARD_EPIC_META.getPersistentDataContainer().set(levelKey, PersistentDataType.FLOAT, 4f);
            SHARD_EPIC.setItemMeta(SHARD_EPIC_META);

            // Legendary crafting crystal
            final var SHARD_LEGENDARY = new ItemStack(Material.EMERALD);
            final var SHARD_LEGENDARY_META = SHARD_LEGENDARY.getItemMeta();
            final var SHARD_LEGENDARY_COLOR = ItemRarity.LEGENDARY.getColor();
            SHARD_LEGENDARY_META.setCustomModelData(5);
            SHARD_LEGENDARY_META.displayName(Component.text("Legendary Shard").decorate(TextDecoration.BOLD).color(SHARD_LEGENDARY_COLOR));
            SHARD_LEGENDARY_META.lore(Collections.singletonList(crystalLore.color(SHARD_LEGENDARY_COLOR)));
            SHARD_LEGENDARY_META.getPersistentDataContainer().set(levelKey, PersistentDataType.FLOAT, 5f);
            SHARD_LEGENDARY.setItemMeta(SHARD_LEGENDARY_META);

            //Add all of the materials to the material manager
            putIfAbsent(StratumMaterial.SHARD_UNCOMMON.name(), SHARD_UNCOMMON);
            putIfAbsent(StratumMaterial.SHARD_COMMON.name(), SHARD_COMMON);
            putIfAbsent(StratumMaterial.SHARD_RARE.name(), SHARD_RARE);
            putIfAbsent(StratumMaterial.SHARD_EPIC.name(), SHARD_EPIC);
            putIfAbsent(StratumMaterial.SHARD_LEGENDARY.name(), SHARD_LEGENDARY);
        }};
    }
}
