package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.UseAoeSpell;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class AoeDamageSpell extends UseAoeSpell {
    public AoeDamageSpell(
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
                AttributeKey.SPELL_AOE_DAMAGE_ATTRIBUTE,
                Component.text("AOE Damage"),
                0,
                5 * 20
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var range = 5;
        final var eventData = getEventData(sourceEvent, true, true, range, true);
        if (eventData == null) return;

        final float damage = 15 * (1 + (eventData.getPotency()));
        System.out.println("dmg: " + damage);
        eventData.getNearbyEntities().forEach(ent -> ent.damage(damage));
        particleFactory.constructParticleGeometry(
                particleFactory.createConcentricCircleGeometry(eventData.getPlayer().getLocation(), range, 12, (int) (range / 2), new Vector()),
                Color.RED,
                eventData.getPlayer().getWorld()
        );

    }
}
