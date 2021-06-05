package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.UseRailgunSpell;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.UseSpellAttributes;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.event.Event;
import org.bukkit.util.Vector;

public class UseRailgunSpell extends UseSpellAttributes {
    public UseRailgunSpell(
            MaterialManager materialManager,
            IKeyManager keyManager,
            ISerializer serializer,
            ItemLists itemLists
    ) {
        super(
                materialManager,
                keyManager,
                serializer,
                itemLists,
                AttributeKey.SPELL_RAILGUN_ATTRIBUTE,
                Component.text("Mr. Cum"),
                0,
                0
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var useEventData = getEventData(sourceEvent, true, true);
        if (useEventData == null) return;
        final var player = useEventData.getPlayer();
        final var lookingDirection = player.getLocation();
        final var targetLocation = useEventData.getEvent().getInteractionPoint();
        if (targetLocation == null) return;

        particleFactory.constructParticleGeometry(
                particleFactory.createParticleLine(lookingDirection, targetLocation, 5, new Vector(0, 0, 0)),
                Color.AQUA,
                player.getWorld()
        );
    }
}
