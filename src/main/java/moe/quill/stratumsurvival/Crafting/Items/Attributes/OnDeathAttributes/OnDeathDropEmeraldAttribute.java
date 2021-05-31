package moe.quill.stratumsurvival.Crafting.Items.Attributes.OnDeathAttributes;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.Attribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Effects.DropItemStackEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class OnDeathDropEmeraldAttribute extends OnDeathAttribute {
    DropItemStackEffect dropItemStackEffect = new DropItemStackEffect();


    public OnDeathDropEmeraldAttribute(MaterialManager materialManager, IKeyManager keyManager) {
        super(materialManager, keyManager, AttributeKey.ON_DEATH_DROP_EMERALD_ATTRIBUTE,
                Component.text("Emerald Touch").color(TextColor.color(0x2CDA44)),
                .05f,
                .01f,
                .2f
        );
    }

    @Override
    public String dataFormat(float value) {
        return attributeFormatter.formatPercent(value);
    }

    @Override
    public void execute(Event sourceEvent, float modifier) {
        final var data = getEventData(sourceEvent);
        if (data == null) return;

        var target = data.getTarget();
        var item = new ItemStack(Material.EMERALD);

        if (modifier < Attribute.rand.nextFloat()) return;
        dropItemStackEffect.execute(sourceEvent, target.getLocation(), item);
    }
}
