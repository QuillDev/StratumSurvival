package tech.quilldev.Events.ToolEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterial;
import tech.quilldev.CustomItemsv2.MaterialManager.StratumMaterialManager;

public class ToolBreakBlockDropShard implements Listener {

    private final StratumMaterialManager materialManager;

    public ToolBreakBlockDropShard(StratumMaterialManager materialManager) {
        this.materialManager = materialManager;
    }


    //TODO: Add odds to this
    @EventHandler
    public void dropShardOnBlockBreak(BlockBreakEvent event) {
        final var player = event.getPlayer();
        final var block = event.getBlock();
        player.getWorld().dropItemNaturally(block.getLocation(), materialManager.getItem(StratumMaterial.FRAGMENT_LEGENDARY));
    }
}
