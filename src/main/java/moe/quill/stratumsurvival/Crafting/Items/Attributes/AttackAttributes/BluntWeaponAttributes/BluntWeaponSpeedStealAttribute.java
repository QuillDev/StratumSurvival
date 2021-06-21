package moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Effects.EffectHelpers.EffectHelper;
import moe.quill.stratumsurvival.Crafting.Items.Effects.PotionBasedEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;

public class BluntWeaponSpeedStealAttribute extends BluntWeaponAttribute {

    public static PotionBasedEffect potionBasedEffect = new PotionBasedEffect();

    EffectHelper helper = new EffectHelper();

    public BluntWeaponSpeedStealAttribute(
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
