package tech.quilldev.CustomItems.Attributes.OnDeathAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import tech.quilldev.CustomItems.Attributes.Attribute;
import tech.quilldev.CustomItems.Effects.DropItemStackEffect;

public class DropDiamondOnDeathAttribute extends OnDeathAttribute{
    DropItemStackEffect dropItemStackEffect = new DropItemStackEffect();


    public DropDiamondOnDeathAttribute(NamespacedKey key) {
        super(key,
                Component.text("Diamond Touch").color(TextColor.color(0x35B6DA)),
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
        var item = new ItemStack(Material.DIAMOND);

        if (modifier < Attribute.rand.nextFloat()) return;
        dropItemStackEffect.execute(sourceEvent, target.getLocation(), item);
    }
}
