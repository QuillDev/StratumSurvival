package moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Effects.EffectHelpers.EffectHelper;
import moe.quill.stratumsurvival.Crafting.Items.Effects.PotionBasedEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffectType;

public class BluntWeaponSpeedStealAttribute extends BluntWeaponAttribute {

    public static PotionBasedEffect potionBasedEffect = new PotionBasedEffect();

    EffectHelper helper = new EffectHelper();

    public BluntWeaponSpeedStealAttribute(MaterialManager materialManager, KeyManager keyManager) {
        super(
                materialManager,
                keyManager,
                AttributeKey.BLUNT_WEAPON_SPEED_STEAL_ATTRIBUTE,
                Component.text("Speed Leach").color(TextColor.color(0x1C6FF7)),
                0,
                0,
                0
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var event = getEventData(sourceEvent);
        if (event == null) return;

        potionBasedEffect.execute(sourceEvent, PotionEffectType.SPEED, event.getPlayer(), 25);
        potionBasedEffect.execute(sourceEvent, PotionEffectType.SLOW, event.getTarget(), 25);
    }
}
