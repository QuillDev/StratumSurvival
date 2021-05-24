package moe.quill.Crafting.CustomItems.Attributes.OnDeathAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import moe.quill.Crafting.CustomItems.Attributes.Attribute;
import moe.quill.Crafting.CustomItems.Effects.DropItemStackEffect;

public class DropGoldOnDeathAttribute extends OnDeathAttribute{

    DropItemStackEffect dropItemStackEffect = new DropItemStackEffect();


    public DropGoldOnDeathAttribute(NamespacedKey key) {
        super(key,
                Component.text("Midas Touch").color(TextColor.color(0xDAAA35)),
                .1f,
                .05f,
                .6f
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
        var item = new ItemStack(Material.GOLD_NUGGET);

        if (modifier < Attribute.rand.nextFloat()) return;
        dropItemStackEffect.execute(sourceEvent, target.getLocation(), item);
    }
}
