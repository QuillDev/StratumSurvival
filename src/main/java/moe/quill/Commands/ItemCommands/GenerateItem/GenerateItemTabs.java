package moe.quill.Commands.ItemCommands.GenerateItem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import moe.quill.Crafting.CustomItems.Attributes.ItemAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class GenerateItemTabs implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            return new ArrayList<>(ItemAttributes.attributeCategories.keySet())
                    .stream()
                    .filter(name -> name.toLowerCase().contains(args[0].toLowerCase(Locale.ROOT)))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
