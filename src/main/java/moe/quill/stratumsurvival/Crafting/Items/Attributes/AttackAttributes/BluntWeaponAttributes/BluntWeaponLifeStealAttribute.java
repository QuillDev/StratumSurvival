package moe.quill.stratumsurvival.Crafting.Items.Attributes.AttackAttributes.BluntWeaponAttributes;

import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Effects.HealPlayerEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.StratumCommon.KeyManager.IKeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class BluntWeaponLifeStealAttribute extends BluntWeaponAttribute {

    public static final HealPlayerEffect healPlayerEffect = new HealPlayerEffect();

    public BluntWeaponLifeStealAttribute(MaterialManager materialManager, IKeyManager keyManager) {
        super(
                materialManager,
                keyManager,
                AttributeKey.BLUNT_WEAPON_LIFE_STEAL_ATTRIBUTE,
                Component.text("Life Steal").color(TextColor.color(0xf75134)),
                .08f,
                .05f,
                .4f
        );
    }

    @Override
    public String dataFormat(float value) {
        return ": +" + Math.round(value * 100) + "%";
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        if (!(sourceEvent instanceof EntityDamageByEntityEvent)) return;
        final var event = (EntityDamageByEntityEvent) sourceEvent;
        healPlayerEffect.execute(sourceEvent, ((float) event.getDamage() * modifier));
    }
}
