package tech.quilldev.CustomItemsv2.Attributes.UseAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import tech.quilldev.CustomItemsv2.Attributes.UseAttributes.UseAttribute;
import tech.quilldev.CustomItemsv2.Effects.CloakEffect;
import tech.quilldev.CustomItemsv2.Effects.KnockbackEffect;
import tech.quilldev.CustomItemsv2.Effects.WhisperEffect;

public class ShadowDodgeUseWeaponAttribute extends UseAttribute {

    public final static CloakEffect cloakEffect = new CloakEffect();
    public final static KnockbackEffect knockbackEffect = new KnockbackEffect();
    public final static WhisperEffect whisperEffect = new WhisperEffect();

    public ShadowDodgeUseWeaponAttribute(NamespacedKey key) {
        super(key,
                Component.text("Shadow Dodge").color(TextColor.color(0x3F0BCB)),
                0f);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {

        knockbackEffect.execute(sourceEvent, 1.5f);
        cloakEffect.execute(sourceEvent, 15);

    }

}
