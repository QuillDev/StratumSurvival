package tech.quilldev.Commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

public class Dev implements CommandExecutor {

    private final Plugin plugin;

    public Dev(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;

        var zeus = new ItemStack(Material.IRON_AXE);
        var meta = zeus.getItemMeta();
        meta.setLocalizedName("Zeus's Axe");
        meta.lore(Arrays.asList(
                Component.text("Developer Item"),
                Component.text("Zeus's Blessing").color(TextColor.color(200, 100, 200)),
                Component.text("Demonic").color(TextColor.color(83, 14, 22)),
                Component.text("regen").color(TextColor.color(40, 83, 44))
        ));

        //Get the data container
        final var data = meta.getPersistentDataContainer();

        NamespacedKey key = new NamespacedKey(plugin, "zeus");
        NamespacedKey key2 = new NamespacedKey(plugin, "demonic");
        NamespacedKey key3 = new NamespacedKey(plugin, "regen");
        data.set(key, PersistentDataType.STRING, "TRUE");
        data.set(key2, PersistentDataType.STRING, "TRUE");
        data.set(key3, PersistentDataType.STRING,"TRUE");
        zeus.setItemMeta(meta);

        Objects.requireNonNull(((Player) sender).getPlayer()).getInventory().addItem(zeus);
        return true;
    }
}
