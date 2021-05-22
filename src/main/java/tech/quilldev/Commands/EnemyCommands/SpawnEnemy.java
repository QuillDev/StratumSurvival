package tech.quilldev.Commands.EnemyCommands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;

public class SpawnEnemy implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(sender instanceof Player)) return false;

        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;

        ItemStack head = new ItemStack(Material.ZOMBIE_HEAD);
        ItemStack sword = new ItemStack(Material.GOLDEN_SWORD);
        var headMeta = (SkullMeta) head.getItemMeta();

        final var location = player.getLocation();
        final var pirate = (Stray) player.getWorld().spawnEntity(location, EntityType.STRAY);

        pirate.getEquipment().setHelmet(head);
        pirate.getEquipment().setItemInMainHand(sword);

        return false;
    }
}
