package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.UseProjectileSpell;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.UseSpellAttribute;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.util.stream.Collectors;

public class UseWaterBoltSpell extends UseSpellAttribute {
    public UseWaterBoltSpell(
            Plugin plugin,
            MaterialManager materialManager,
            IKeyManager keyManager,
            ISerializer serializer,
            ItemLists itemLists
    ) {
        super(
                plugin,
                materialManager,
                keyManager,
                serializer,
                itemLists,
                AttributeKey.SPELL_WATER_BOLT_ATTRIBUTE,
                Component.text("Water Bolt").color(TextColor.color(0x2EA2CB)),
                0,
                0
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent, true, true);
        if (eventData == null) return;

        final var range = 10 * (1 + eventData.getPotency());
        final var damage = 10 * (1 + eventData.getPotency());
        final var player = eventData.getPlayer();
        final var playerLoc = player.getLocation();
        final var endBlock = player.getTargetBlock((int) range);
        if (endBlock == null) return;
        final var endLoc = endBlock.getLocation();

        final var divisions = range / 5f;
        final var segments = particleFactory.createLineSegmentList(player.getEyeLocation(), endLoc, (int) divisions);

        final var linePairs = segments.stream().sorted((a, b) -> {
            final var firstA = a.getFirst();
            final var firstB = b.getFirst();

            final var distA = firstA.toVector().distance(playerLoc.toVector());
            final var distB = firstB.toVector().distance(playerLoc.toVector());

            if (distA > distB) {
                return 1;
            } else if (distA == distB) {
                return 0;
            }
            return -1;
        }).collect(Collectors.toList());

        final var radius = .6;
        for (int idx = 0; idx < linePairs.size(); idx++) {

            int finalIdx = idx;
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                final var curLine = linePairs.get(finalIdx);

                final var ray = particleFactory.createParticleLine(curLine.getFirst(), curLine.getSecond(), 3, new Vector());
                if (ray.size() < 1) return;

                final var enemyLoc = ray.get(0);
                final var targets = enemyLoc.getNearbyLivingEntities(2);

                for (final var point : ray) {
                    final var hitBox = new BoundingBox(
                            point.getX() - radius,
                            point.getY() + radius,
                            point.getZ() - radius,
                            point.getX() + radius,
                            point.getY() - radius,
                            point.getZ() + radius
                    );

                    //Check if the targets hit box overlaps with the hit box, if it does, do the damage
                    for (final var target : targets) {
                        if (!target.getBoundingBox().overlaps(hitBox)) continue;
                        target.damage(damage, player);
                    }
                }
                particleFactory.constructParticleGeometry(
                        ray,
                        Color.TEAL,
                        player.getWorld()
                );
            }, idx);

        }

    }
}
