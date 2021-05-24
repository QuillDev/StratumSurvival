package moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.WeaponHelpers;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class WeaponType {

    public Class<?> type;
    public ArrayList<ItemStack> itemStacks;

    public WeaponType(ArrayList<ItemStack> itemStacks, Class<?> type) {
        this.itemStacks = itemStacks;
        this.type = type;
    }
}
