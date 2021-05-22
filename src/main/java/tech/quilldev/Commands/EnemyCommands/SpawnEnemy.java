package tech.quilldev.Commands.EnemyCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.CustomItems.MaterialManager.HeadHelper;
import tech.quilldev.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import tech.quilldev.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

public class SpawnEnemy implements CommandExecutor {

    private final StratumMaterialManager materialManager;
    private final ItemStack pirateHead =
            HeadHelper.getHeadFromTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTU2ZWM3MGYwNDQxYzdkMWYwM2ZjOTcwOWZkZjcwZTU1OGY3ZDJlYzE5MWQzNzMwYjhjMDYyMWJlZjg5OWVkZSJ9fX0=");


    public SpawnEnemy(StratumMaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(sender instanceof Player)) return false;

        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;

        ItemStack head = pirateHead;
        ItemStack sword = materialManager.getItem(StratumMaterial.SCYTHE_GOLDEN);
        var headMeta = (SkullMeta) head.getItemMeta();

        final var location = player.getLocation();
        final var pirate = (Stray) player.getWorld().spawnEntity(location, EntityType.STRAY);
        pirate.getEquipment().setHelmet(head);
        pirate.getEquipment().setItemInMainHand(sword);

        return false;
    }
}
