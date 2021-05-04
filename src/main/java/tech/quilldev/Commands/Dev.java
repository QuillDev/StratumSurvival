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
import tech.quilldev.CustomItemsv2.ItemAttributes;
import tech.quilldev.Serialization.StratumSerialization;

public class Dev implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;

        var zeus = new ItemStack(Material.NETHERITE_AXE);
        var meta = zeus.getItemMeta();
        meta.displayName(Component.text("Quill's Battleaxe").color(TextColor.color(0xDCDA55)));

        //Get the data container
        final var data = meta.getPersistentDataContainer();
        final var attr = ItemAttributes.getAttribute("blunt_weapon_whisper");
        final var bdamage = ItemAttributes.getAttribute("blunt_weapon_flat_damage");
        final var cdamage = ItemAttributes.getAttribute("blunt_weapon_chain_damage");
        data.set(attr.key, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeFloat(12124f));
        data.set(bdamage.key, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeFloat(11f));
        data.set(cdamage.key, PersistentDataType.BYTE_ARRAY, StratumSerialization.serializeFloat(1f));
        zeus.setItemMeta(meta);
        ((Player) sender).getInventory().addItem(zeus);
        return true;
    }
}
