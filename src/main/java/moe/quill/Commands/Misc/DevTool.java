package moe.quill.Commands.Misc;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.wrappers.*;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Adventuring.Enemies.EnemyManager;
import moe.quill.Adventuring.Enemies.EnemyType;
import moe.quill.Adventuring.Enemies.StrayBased.WeebEnemy;
import moe.quill.Adventuring.Enemies.ZombieBased.PirateEnemy;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import moe.quill.Crafting.CustomItems.MaterialManager.StratumMaterials.StratumMaterialManager;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DevTool implements CommandExecutor, Listener {
    private final Plugin plugin;

    private final NamespacedKey lootChestKey;
    private final StratumMaterialManager materialManager;
    private final ProtocolManager protocolManager;

    public DevTool(StratumMaterialManager materialManager, ProtocolManager protocolManager, Plugin plugin) {
        this.plugin = plugin;
        this.lootChestKey = new NamespacedKey(plugin, "loot_chest_key");
        this.materialManager = materialManager;
        this.protocolManager = protocolManager;

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        final var player = ((Player) sender).getPlayer();
        if (player == null) return true;


        final var expOrb = protocolManager.createPacket(PacketType.Play.Server.SPAWN_ENTITY_EXPERIENCE_ORB, false);
        expOrb.getIntegers()
                .write(0, 1);
        expOrb.getDoubles()
                .write(0, player.getLocation().getX())
                .write(1, player.getLocation().getY())
                .write(2, player.getLocation().getZ());

        final var explosion = protocolManager.createPacket(PacketType.Play.Server.EXPLOSION, false);
        explosion.getDoubles()
                .write(0, player.getLocation().getX())
                .write(1, player.getLocation().getY())
                .write(2, player.getLocation().getZ());
        explosion.getFloat().write(0, 4f);
        explosion.getLists(null).write(0, new ArrayList<>()); //NO CLUE WHAT THIS DOES AHH

        try {
            protocolManager.sendServerPacket(player, expOrb);
            protocolManager.sendServerPacket(player, explosion);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return true;
    }


}
