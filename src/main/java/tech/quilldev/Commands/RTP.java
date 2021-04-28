package tech.quilldev.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RTP implements CommandExecutor {

    private static final int max = 5000;
    private static final int tries = 50;

    private static final Material[] blacklist = new Material[]{
            Material.AIR,
            Material.WATER,
            Material.LAVA
    };

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;
        var player = ((Player) sender).getPlayer();
        assert player != null;
        var world = player.getWorld();

        //TODO: Implement
        return true;
    }
}
