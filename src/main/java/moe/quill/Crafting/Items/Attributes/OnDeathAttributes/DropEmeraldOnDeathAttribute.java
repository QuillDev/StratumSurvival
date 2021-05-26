package moe.quill.Crafting.Items.Attributes.OnDeathAttributes;

import moe.quill.Crafting.Items.Attributes.Attribute;
import moe.quill.Crafting.Items.Effects.DropItemStackEffect;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class DropEmeraldOnDeathAttribute extends OnDeathAttribute{
    DropItemStackEffect dropItemStackEffect = new DropItemStackEffect();


    public DropEmeraldOnDeathAttribute(NamespacedKey key) {
        super(key,
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
