package moe.quill.Commands.Misc;

import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Adventuring.Enemies.EnemyManager;
import moe.quill.Adventuring.Enemies.EnemyType;
import moe.quill.Adventuring.Enemies.StrayBased.WeebEnemy;
import moe.quill.Adventuring.Enemies.ZombieBased.PirateEnemy;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class DevTool implements CommandExecutor, Listener {
    private final Plugin plugin;

    private final NamespacedKey lootChestKey;
    private final StratumMaterialManager materialManager;

    public DevTool(StratumMaterialManager materialManager, Plugin plugin) {
        this.plugin = plugin;
        this.lootChestKey = new NamespacedKey(plugin, "loot_chest_key");
        this.materialManager = materialManager;

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;


        final var item1 = materialManager.getItem(StratumMaterial.HELMET_IRON_LIGHT);
        final var item2 = materialManager.getItem(StratumMaterial.CHESTPLATE_IRON_LIGHT);
        final var item3 = materialManager.getItem(StratumMaterial.LEGGINGS_IRON_LIGHT);
        final var item4 = materialManager.getItem(StratumMaterial.BOOTS_IRON_LIGHT);

        final var item5 = materialManager.getItem(StratumMaterial.HELMET_IRON_HEAVY);
        final var item6 = materialManager.getItem(StratumMaterial.CHESTPLATE_IRON_HEAVY);
        final var item7 = materialManager.getItem(StratumMaterial.LEGGINGS_IRON_HEAVY);
        final var item8 = materialManager.getItem(StratumMaterial.BOOTS_IRON_HEAVY);

        player.getInventory().addItem(item1,item2,item3,item4,item5,item6,item7,item8);
        return true;
    }
}
