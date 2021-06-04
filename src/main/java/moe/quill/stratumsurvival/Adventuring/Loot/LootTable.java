package moe.quill.stratumsurvival.Adventuring.Loot;

import moe.quill.stratumsurvival.StratumSurvival;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Random;

public class LootTable {

    ArrayList<LootDrop> drops = new ArrayList<>();
    private final Random random = StratumSurvival.rand;
    private final Component name;
    private int lootSum = 0;


    LootTable(Component name) {
        this.name = name;
    }

    public void register(LootDrop... lootDrops) {

        for (final var lootDrop : lootDrops) {
            //Set the range for the loot drop
            lootDrop.setMin(lootSum);
            lootSum += lootDrop.getWeight();
            drops.add(lootDrop);
        }
    }

    public ItemStack getRandomDrop() {
        final var roll = random.nextInt(lootSum + 1);

        for (final var drop : drops) {
            final var max = drop.getMin() + drop.getWeight();

            //If the roll is in the valid roll range
            if (drop.getMin() <= roll && roll < max) {
                return drop.getItem();
            }
        }

        return new ItemStack(Material.AIR);
    }

    public Component getName() {
        return name;
    }
}
