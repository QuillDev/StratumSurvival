package moe.quill.Adventuring.Loot;

import moe.quill.Crafting.GlobalKey;
import moe.quill.Crafting.KeyManager;
import moe.quill.StratumSurvival;
import moe.quill.Utils.Serialization.StratumSerialization;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class LootListener implements Listener {

    private final LootManager lootManager;
    private final LootTables lootTables;

    private final NamespacedKey levelKey;

    public LootListener(LootManager lootManager, KeyManager keyManager) {
        this.lootManager = lootManager;
        this.lootTables = lootManager.getLootTables();
        this.levelKey = keyManager.getNsKey(GlobalKey.LEVEL_KEY);
    }

    @EventHandler
    public void dropLootEvent(EntityDeathEvent event) {
        final var lootOdds = .03f;
        if (lootOdds < StratumSurvival.rand.nextFloat()) return;
        final var entity = event.getEntity();
        final var player = entity.getKiller();
        if (player == null) return;
        lootManager.spawnLoot(entity.getLocation());
    }

    @EventHandler
    public void listenForLootOpen(PlayerInteractAtEntityEvent event) {
        final var targetClicked = event.getRightClicked();
        if (!(targetClicked instanceof ArmorStand)) return;
        final var target = (ArmorStand) targetClicked;
        final var targetData = target.getPersistentDataContainer();
        if (!targetData.has(lootManager.getLootChestKey(), PersistentDataType.BYTE_ARRAY)) return;
        if (!targetData.has(levelKey, PersistentDataType.BYTE_ARRAY)) return;
        final var level = (int) StratumSerialization.deserializeFloat(targetData.get(levelKey, PersistentDataType.BYTE_ARRAY));
        event.setCancelled(true); //cancel the right click event
        final var player = event.getPlayer();
        player.sendMessage(String.format("Opened tier %s loot", level));
        targetClicked.remove();

        //Get the table based on the loot level
        final var table = lootTables.getLootTable(level);
        final var drop = table.getRandomDrop();
        player.getInventory().addItem(drop);

        //Generate text for the quantity of the item
        var name = drop.getItemMeta().displayName();
        if (name == null) name = Component.text(Objects.requireNonNull(drop.getI18NDisplayName()));

        final var quantityText =
                Component.text("x")
                        .append(Component.text(drop.getAmount()))
                        .decorate(TextDecoration.BOLD);

        //Send a message to the player about what their chest contained
        player.sendMessage(
                Component.text("You opened the")
                        .append(Component.space())
                        .append(table.getName())
                        .append(Component.space())
                        .append(Component.text("and received"))
                        .append(Component.space())
                        .append(name)
                        .append(Component.space())
                        .append(quantityText)
        );
    }

}
