package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.UseProjectileSpell;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.UseSpellAttributes;
import moe.quill.stratumsurvival.Crafting.Items.Effects.SpellEffects.ProjectileEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class UseRailgunSpell extends UseSpellAttributes {

    private final ProjectileEffect effect = new ProjectileEffect();

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
                Component.text("Railgun"),
                0,
                (long) (.5 * 20)
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        if (!(sourceEvent instanceof PlayerInteractEvent)) return;

        //Get data about the event
        final var eventData = getEventData(sourceEvent, true, true);
        if (eventData == null) return;
        final var event = eventData.getEvent();

        //Create the locations for the ray we're going to shoot
        final var player = event.getPlayer();
        effect.execute(player, 15, 7, true, Color.fromRGB(253, 78, 54));

        particleFactory.constructParticleGeometry(
                particleFactory.createConcentricCircleGeometry(player.getLocation(), 2, 12, 3, new Vector()),
                Color.GREEN,
                player.getWorld()
        );
    }
}
