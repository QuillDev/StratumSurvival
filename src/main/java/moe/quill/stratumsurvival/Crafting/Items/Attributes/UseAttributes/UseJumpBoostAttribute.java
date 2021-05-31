package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes;

import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Effects.SpawnLingeringPotionCloudEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.StratumCommon.KeyManager.IKeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class UseJumpBoostAttribute extends UseAttribute {
    SpawnLingeringPotionCloudEffect spawnLingeringPotionCloudEffect = new SpawnLingeringPotionCloudEffect();

    public UseJumpBoostAttribute(MaterialManager materialManager, IKeyManager keyManager) {
        super(
                materialManager,
                keyManager,
                AttributeKey.USE_JUMP_BOOST_ATTRIBUTE,
                Component.text("Acrobatic Field").color(TextColor.color(0x53CB35)),
                0f,
                500L);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var useEventData = getEventData(sourceEvent, true, true);
        if (useEventData == null) return;

        var player = useEventData.getPlayer();

        spawnLingeringPotionCloudEffect.execute(sourceEvent, player.getLocation(),
                new PotionEffect(PotionEffectType.JUMP, 100, 5),
                3,
                120,
                0
        );
        spawnLingeringPotionCloudEffect.execute(sourceEvent, player.getLocation(),
                new PotionEffect(PotionEffectType.SLOW_FALLING, 100, 1),
                3,
                120,
                0
        );
    }

}
