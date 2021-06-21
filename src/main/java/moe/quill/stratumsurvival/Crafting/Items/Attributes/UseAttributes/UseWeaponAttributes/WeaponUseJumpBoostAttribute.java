package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseWeaponAttributes;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.WeaponUseAttribute;
import moe.quill.stratumsurvival.Crafting.Items.Effects.SpawnLingeringPotionCloudEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WeaponUseJumpBoostAttribute extends WeaponUseAttribute {
    SpawnLingeringPotionCloudEffect spawnLingeringPotionCloudEffect = new SpawnLingeringPotionCloudEffect();

    public WeaponUseJumpBoostAttribute(
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
