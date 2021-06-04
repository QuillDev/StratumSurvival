package moe.quill.stratumsurvival.Adventuring.Loot;

import org.bukkit.inventory.ItemStack;

public class LootDrop {

    private final ItemStack item;
    private final float weight;
    private int min = 0;

    public LootDrop(ItemStack item, float weight) {
        this.item = item;
        this.weight = weight;
    }

    public LootDrop(ItemStack item, float weight, int amount) {
        final var tempItem = item.clone();
        tempItem.setAmount(amount);
        this.item = tempItem;
        this.weight = weight;
    }

    public ItemStack getItem() {
        return item;
    }

    public float getWeight() {
        return weight;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMin() {
        return min;
    }
}
