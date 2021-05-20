package tech.quilldev.CustomItemsv2.Attributes.AttackAttributes.BluntWeaponAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectTypeWrapper;
import tech.quilldev.CustomItemsv2.Effects.EffectHelpers.EffectHelper;
import tech.quilldev.CustomItemsv2.Effects.PotionBasedEffect;

public class BluntWeaponSpeedStealAttribute extends BluntWeaponAttribute{

    public static PotionBasedEffect potionBasedEffect = new PotionBasedEffect();

    EffectHelper helper = new EffectHelper();

    public BluntWeaponSpeedStealAttribute(NamespacedKey key) {
        super(key,
                Component.text("Speed Leach").color(TextColor.color(0x1C6FF7)),
                0,
                0,
                0
        );
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {

        var player = helper.getLivingEntity(sourceEvent);
        var target = helper.getTargetLivingEntity(sourceEvent);

        potionBasedEffect.execute(sourceEvent,PotionEffectType.SPEED,player,25);
        potionBasedEffect.execute(sourceEvent,PotionEffectType.SLOW,(LivingEntity) target,25);
    }
}
