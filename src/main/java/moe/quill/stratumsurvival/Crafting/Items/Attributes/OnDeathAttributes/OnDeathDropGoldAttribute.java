package moe.quill.stratumsurvival.Crafting.Items.Attributes.OnDeathAttributes;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.Attribute;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Effects.DropItemStackEffect;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class OnDeathDropGoldAttribute extends OnDeathAttribute {

    DropItemStackEffect dropItemStackEffect = new DropItemStackEffect();


    public OnDeathDropGoldAttribute(
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
                AttributeKey.ON_DEATH_DROP_GOLD_ATTRIBUTE,
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
