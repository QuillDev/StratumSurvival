package moe.quill.Adventuring.Loot;

import moe.quill.Crafting.CustomItems.ItemHelpers.ItemRarity;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;
import net.kyori.adventure.text.Component;

import java.util.HashMap;

public class LootTables {

    private final HashMap<Integer, LootTable> tables;

    public LootTables(StratumMaterialManager materialManager) {

        this.tables = new HashMap<>() {{
            put(1, new LootTable(Component.text("Common Chest").color(ItemRarity.COMMON.color)) {{
                register(
                        new LootDrop(materialManager.getItem(StratumMaterial.FRAGMENT_COMMON), 100f),
                        new LootDrop(materialManager.getItem(StratumMaterial.FRAGMENT_COMMON), 50f, 3)
                );
            }});

            put(2, new LootTable(Component.text("Uncommon Chest").color(ItemRarity.UNCOMMON.color)) {{
                register(
                        new LootDrop(materialManager.getItem(StratumMaterial.FRAGMENT_UNCOMMON), 100f),
                        new LootDrop(materialManager.getItem(StratumMaterial.FRAGMENT_UNCOMMON), 50f, 3)
                );
            }});

            put(3, new LootTable(Component.text("Rare Chest").color(ItemRarity.RARE.color)) {{
                register(
                        new LootDrop(materialManager.getItem(StratumMaterial.FRAGMENT_RARE), 100f),
                        new LootDrop(materialManager.getItem(StratumMaterial.FRAGMENT_RARE), 50f, 3)
                );
            }});

            put(4, new LootTable(Component.text("Epic Chest").color(ItemRarity.EPIC.color)) {{
                register(
                        new LootDrop(materialManager.getItem(StratumMaterial.FRAGMENT_EPIC), 100f),
                        new LootDrop(materialManager.getItem(StratumMaterial.FRAGMENT_EPIC), 50f, 3)
                );
            }});

            put(5, new LootTable(Component.text("Legendary Chest").color(ItemRarity.LEGENDARY.color)) {{
                register(
                        new LootDrop(materialManager.getItem(StratumMaterial.FRAGMENT_LEGENDARY), 100f),
                        new LootDrop(materialManager.getItem(StratumMaterial.FRAGMENT_LEGENDARY), 50f, 3)
                );
            }});

        }};
    }

    public LootTable getLootTable(int level) {
        return this.tables.get(level);
    }
}