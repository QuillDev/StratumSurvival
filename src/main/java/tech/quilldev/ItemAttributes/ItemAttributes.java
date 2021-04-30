package tech.quilldev.ItemAttributes;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import tech.quilldev.ItemAttributes.DamageAttribute.DamageAttribute;
import tech.quilldev.ItemAttributes.UseAttribute.DemonicAttribute;
import tech.quilldev.ItemAttributes.UseAttribute.UseAttribute;
import tech.quilldev.ItemAttributes.UseAttribute.ZeusEffect;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemAttributes {
    public ArrayList<UseAttribute> useAttributes = new ArrayList<>();
    public ArrayList<DamageAttribute> damageAttributes = new ArrayList<>();

    public ItemAttributes(Plugin plugin) {
        this.initialize(plugin);
    }

    public void initialize(Plugin plugin){
        useAttributes.addAll(
                Arrays.asList(
                        new ZeusEffect(new NamespacedKey(plugin, "zeus")),
                        new DemonicAttribute(new NamespacedKey(plugin, "demonic"))
                )
        );
    }
}
