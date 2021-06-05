package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseSpellAttributes;

import moe.quill.StratumCommon.KeyManager.IKeyManager;
import moe.quill.StratumCommon.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.AttributeKey;
import moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes.UseAttributeHelpers.UseAttribute;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.WeaponHelpers.ItemLists;
import moe.quill.stratumsurvival.Particles.ParticleFactory;
import net.kyori.adventure.text.Component;

public abstract class UseSpellAttributes extends UseAttribute {

    protected final ParticleFactory particleFactory = new ParticleFactory();

    public UseSpellAttributes(
            MaterialManager materialManager,
            IKeyManager keyManager,
            ISerializer serializer,
            ItemLists itemLists,
            AttributeKey key,
            Component lore,
            float scaleValue,
            long cooldown
    ) {
        super(
                materialManager,
                keyManager,
                serializer,
                itemLists,
                key,
                lore,
                itemLists.getSpellWeapons(),
                scaleValue,
                cooldown);
    }

    @Override
    public int getMinLevel() {
        return 0;
    }
}
