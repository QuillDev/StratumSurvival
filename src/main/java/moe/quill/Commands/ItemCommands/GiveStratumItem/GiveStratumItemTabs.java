package moe.quill.Commands.ItemCommands.GiveStratumItem;

import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GiveStratumItemTabs implements TabCompleter {

    private final StratumMaterialManager materialManager;

    public GiveStratumItemTabs(StratumMaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            return new ArrayList<>(materialManager.getStratumMaterials().keySet())
                    .stream()
                    .filter(name -> name.toLowerCase().contains(args[0].toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (args.length == 2) {
            return new ArrayList<>(Arrays.asList("1", "16", "32", "64"));
        }

        return null;
    }
}
