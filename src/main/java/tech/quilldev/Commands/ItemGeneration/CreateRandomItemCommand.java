package tech.quilldev.Commands.ItemGeneration;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.CustomItemsV1.ItemAttributeType;
import tech.quilldev.CustomItemsV1.ItemGenerator;

public class CreateRandomItemCommand implements CommandExecutor {

    private final ItemGenerator generator;

    private final float perEnemyOdds = 1f;
    private final float perRarityOdds = .38f;

    public CreateRandomItemCommand(ItemGenerator generator) {
        this.generator = generator;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;
        if (args.length == 0) return false;
        final var player = ((Player) sender).getPlayer();
        ItemStack item = null;

        switch (ItemAttributeType.valueOf(args[0])) {
            case WEAPON_BLUNT:
                item = generator.generateRandomWeapon(perEnemyOdds, perRarityOdds);
                break;
            case WEAPON_CAST:
                break;
            case TOOL_MINE:
                item = generator.generateRandomTool(perEnemyOdds, perRarityOdds);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + args[0]);
        }

        //Change generator based on completion

        if (player == null) return true;
        player.getInventory().addItem(item);
        return false;
    }
}
