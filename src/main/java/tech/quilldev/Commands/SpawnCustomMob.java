package tech.quilldev.Commands;

import net.minecraft.server.v1_16_R3.ChatComponentText;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.CustomEntities.Monster.Monster;

public class SpawnCustomMob implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;
        final var monster = new Monster(player.getLocation(), player);
        monster.setCustomName(new ChatComponentText(ChatColor.LIGHT_PURPLE + player.getName() + "'s Pet Zombie"));// Sets pig's name.
        final var world = ((CraftWorld) player.getWorld()).getHandle();
        world.addEntity(monster);

        return false;
    }
}
