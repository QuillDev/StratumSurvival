package tech.quilldev.ItemAttributes.OnUseAttributes;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import tech.quilldev.ItemAttributes.Attribute;

public abstract class OnUseAttribute extends Attribute  {

    public OnUseAttribute(NamespacedKey key, Component displayText) {
        super(key, displayText);
    }

    public abstract void execute(Player player);
}
