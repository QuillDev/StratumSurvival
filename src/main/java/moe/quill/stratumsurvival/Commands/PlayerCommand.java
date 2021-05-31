package moe.quill.stratumsurvival.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface PlayerCommand {

    default Player getPlayerFromSender(CommandSender sender) {
        if (!(sender instanceof Player)) return null;
        return ((Player) sender).getPlayer();
    }
}
