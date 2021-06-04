package moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class ItemType {

    public Class<?> type;
    public ArrayList<ItemStack> itemStacks;

    public ItemType(ArrayList<ItemStack> itemStacks, Class<?> type) {
        this.itemStacks = itemStacks;
        this.type = type;
    }
}
