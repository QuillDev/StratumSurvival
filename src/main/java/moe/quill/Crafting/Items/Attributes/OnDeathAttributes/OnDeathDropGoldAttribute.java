package moe.quill.Crafting.Items.Attributes.OnDeathAttributes;

import moe.quill.Crafting.Items.Attributes.AttributeKey;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.Crafting.KeyManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import moe.quill.Crafting.Items.Attributes.Attribute;
import moe.quill.Crafting.Items.Effects.DropItemStackEffect;

public class OnDeathDropGoldAttribute extends OnDeathAttribute {

    DropItemStackEffect dropItemStackEffect = new DropItemStackEffect();


    public OnDeathDropGoldAttribute(MaterialManager materialManager, KeyManager keyManager) {
        super(materialManager, keyManager, AttributeKey.ON_DEATH_DROP_GOLD_ATTRIBUTE,
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
