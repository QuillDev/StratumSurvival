package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.UseProjectileSpell;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes.UseSpellAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Effects.SpellEffects.ProjectileEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;

public class UseBulletSpell extends UseSpellAttribute {

    private final ProjectileEffect projectileEffect = new ProjectileEffect();

    public UseBulletSpell(
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
                AttributeKey.SPELL_BULLET_ATTRIBUTE,
                Component.text("Bullet"),
                0,
                10
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var eventData = getEventData(sourceEvent, true, true);
        if (eventData == null) return;
        final var event = eventData.getEvent();
        projectileEffect.execute(event.getPlayer(), 10, 10, false, Color.BLACK);
    }
}
