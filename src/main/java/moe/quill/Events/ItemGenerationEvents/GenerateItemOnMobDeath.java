package moe.quill.Events.ItemGenerationEvents;

import moe.quill.StratumSurvival;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import moe.quill.Crafting.Items.ItemHelpers.ItemGenerator;

import java.util.Random;

public class GenerateItemOnMobDeath implements Listener {
    private final Random rand = StratumSurvival.rand;

    private static final float playerDropRate = 1 / 20f;
    private static final float naturalDropRate = 1 / 200f;
    private final ItemGenerator generator;

    /**
     * Generate the given item on mob death
     *
     * @param generator to use
     */
    public GenerateItemOnMobDeath(ItemGenerator generator) {
        this.generator = generator;
    }

    @EventHandler
    public void onMobDeath(EntityDeathEvent event) {
        final var entity = event.getEntity();
        final var player = entity.getKiller();
        //If it was a natural death, roll natural odds
        if (((player == null) ? naturalDropRate : playerDropRate) < rand.nextFloat()) return;
        spawnItem(entity, generator.generateItem());
    }

    private void spawnItem(Entity entity, ItemStack item) {
        entity.getWorld().dropItemNaturally(entity.getLocation(), item);
    }
}
