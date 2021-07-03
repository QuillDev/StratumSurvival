package moe.quill.stratumsurvival.Utils.PlayerHelpers;

import com.google.inject.Inject;
import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.GlobalKey;
import moe.quill.stratumsurvival.Crafting.Items.ItemHelpers.ItemHelper;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialKey;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.HoverEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class InventoryHelper {

    private final ISerializer serializer;
    private final IKeyManager keyManager;
    private final ItemHelper itemHelper;

    @Inject
    public InventoryHelper(IKeyManager keyManager, ISerializer serializer, ItemHelper itemHelper) {
        this.serializer = serializer;
        this.keyManager = keyManager;
        this.itemHelper = itemHelper;
    }

    public ArrayList<ItemStack> getTrinkets(Player player) {
        final var inventory = player.getInventory();

        //List for storing any trinkets we find in
        final var trinkets = new ArrayList<ItemStack>();

        ItemStack trinketBag = null;
        //get the first trinket bag in the players inventory
        for (final var item : inventory.getContents()) {
            if (item == null) continue;
            if (!itemHelper.itemHasKey(item, MaterialKey.TRINKET_BAG_KEY, GlobalKey.INVENTORY_SIZE_KEY, GlobalKey.INVENTORY_DATA_KEY)) {
                continue; //if it doesn't have all required keys just continue
            }
            trinketBag = item;
            break;
        }

        //if the trinket bag is still null return the empty list of trinkets
        if (trinketBag == null) return trinkets;

        //try to get all of the trinkets from the trinket bag
        final var trinketBagData = trinketBag.getItemMeta().getPersistentDataContainer();
        final var inventoryBytes = trinketBagData.get(keyManager.getKey(GlobalKey.INVENTORY_DATA_KEY), PersistentDataType.BYTE_ARRAY);
        return serializer.deserializeItemList(inventoryBytes);
    }

    /**
     * Get items from the crafting matrix
     *
     * @param inventory to get items from
     * @return the list of items in that matrix
     */
    public ArrayList<ItemStack> getItemsFromMatrix(CraftingInventory inventory) {
        final var matrix = inventory.getMatrix();
        return Arrays.stream(matrix)
                .filter(Objects::nonNull)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Get item at the given display slot
     *
     * @param player to get item for
     * @param slot   to get item at
     * @return the component for the given item
     */
    public Component getItemDisplayAtSlot(Player player, int slot) {
        final var item = player.getInventory().getItem(slot - 1);
        return getItemDisplay(item);
    }

    /**
     * Get the text item display for the given item
     *
     * @param item to get text display for
     * @return the component for that item
     */
    public Component getItemDisplay(ItemStack item) {
        if (item == null) return Component.empty();

        //Make it so they can't link air
        if (item.getType().equals(Material.AIR)) {
            return Component.empty();
        }

        //Get the name of the item
        var customName = item.getItemMeta().displayName();
        if (customName == null) {
            customName = Component.text(Objects.requireNonNull(item.getI18NDisplayName()));
        }

        var loreComponent = Component.empty();

        //Append item lore to the item
        final var itemLore = item.lore();
        if (itemLore != null) {
            //Add item lore
            for (int i = 0; i < itemLore.size(); i++) {
                final var lore = itemLore.get(i);
                if (i == itemLore.size() - 1) {
                    loreComponent = loreComponent.append(lore);
                    continue;
                }
                loreComponent = loreComponent.append(lore.append(Component.newline()));
            }
        }

        final var enchants = item.getEnchantments();
        var enchantComponent = Component.empty();
        for (final var enchant : enchants.keySet()) {
            final var lvl = item.getEnchantmentLevel(enchant);
            final var name = enchant.displayName(lvl);
            enchantComponent = enchantComponent
                    .append(name)
                    .append(Component.newline())
            ;
        }

        return
                Component.text("[")
                        .append(customName)
                        .append(Component.text("]"))
                        .hoverEvent(HoverEvent.showText(
                                customName
                                        .append(Component.newline())
                                        .append(enchantComponent)
                                        .append(loreComponent)
                        ));
    }
}
