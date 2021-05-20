package tech.quilldev.Commands.ItemGenerator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.quilldev.CustomItems.Attributes.ItemAttributes;

import java.util.ArrayList;
import java.util.List;

public class GenerateItemTabs implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            return new ArrayList<>(ItemAttributes.attributeCategories.keySet());
        }
        return null;
    }
}
