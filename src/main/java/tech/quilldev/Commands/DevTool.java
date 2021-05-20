package tech.quilldev.Commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterials.StratumMaterialManager;

import java.util.Objects;

public class DevTool implements CommandExecutor {

    private final StratumMaterialManager materialManager;

    public DevTool(StratumMaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;

        Objects.requireNonNull(((Player) sender).getPlayer()).getInventory().addItem(materialManager.getItem(StratumMaterial.GEODE_COMMON));
        return true;
    }
}
