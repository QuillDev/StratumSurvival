package moe.quill.stratumsurvival.Crafting.Items.Attributes.UseAttributes;

import moe.quill.StratumCommonApi.Annotations.Keyable;
import net.kyori.adventure.text.Component;

@Keyable
public enum SpellAttributeKey {
    SPELL_POTENCY(Component.text("Potency"));

    public Component lore;

    SpellAttributeKey(Component lore) {
        this.lore = lore;
    }
}
