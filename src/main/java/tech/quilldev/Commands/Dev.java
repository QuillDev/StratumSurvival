package tech.quilldev.Commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import tech.quilldev.ItemAttributes.ItemAttributes;

import java.util.Objects;

public class Dev implements CommandExecutor {

    private final ItemAttributes attributes;

    public Dev(ItemAttributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;

        var zeus = new ItemStack(Material.NETHERITE_AXE);
        var meta = zeus.getItemMeta();
        meta.displayName(Component.text("Quill's Battleaxe").color(TextColor.color(0xDCDA55)));

        //Get the data container
        final var data = meta.getPersistentDataContainer();

        final var zeusKey = attributes.getUseAttribute("zeus").key;
        final var ratKey = attributes.getDeathAttribute("death_rat").key;
        final var ascendKey = attributes.getDamageAttribute("ascend").key;

        data.set(zeusKey, PersistentDataType.STRING, "TRUE");
        data.set(ratKey, PersistentDataType.STRING, "TRUE");
        data.set(ascendKey, PersistentDataType.FLOAT, .5f);

        zeus.setItemMeta(meta);

        Objects.requireNonNull(((Player) sender).getPlayer()).getInventory().addItem(zeus);
        return true;
    }
}
