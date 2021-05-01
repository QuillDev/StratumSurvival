package tech.quilldev.ItemAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import tech.quilldev.ItemAttributes.DamageAttribute.DamageModifier.BonusDamageAttribute;
import tech.quilldev.ItemAttributes.DamageAttribute.DamageModifier.CritAttribute;
import tech.quilldev.ItemAttributes.DamageAttribute.DamageAttribute;
import tech.quilldev.ItemAttributes.DamageAttribute.ExternalEffect.VampirismAttribute;
import tech.quilldev.ItemAttributes.DamageAttribute.PotionBased.VenomAttribute;
import tech.quilldev.ItemAttributes.DamageAttribute.PotionBased.WitherAttribute;
import tech.quilldev.ItemAttributes.UseAttribute.DemonicAttribute;
import tech.quilldev.ItemAttributes.UseAttribute.UseAttribute;
import tech.quilldev.ItemAttributes.UseAttribute.ZeusEffect;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemAttributes {
    public ArrayList<UseAttribute> useAttributes = new ArrayList<>();
    public ArrayList<DamageAttribute> damageAttributes = new ArrayList<>();
    public NamespacedKey levelKey;

    public ItemAttributes(Plugin plugin) {
        this.levelKey = new NamespacedKey(plugin, "rarity");
        this.initialize(plugin);
    }

    public void initialize(Plugin plugin) {
        useAttributes.addAll(
                Arrays.asList(
                        new ZeusEffect(
                                new NamespacedKey(plugin, "zeus"),
                                Component.text("Zeus").color(TextColor.color(0x15E1FF))
                        ),
                        new DemonicAttribute(
                                new NamespacedKey(plugin, "demonic"),
                                Component.text("Demonic").color(TextColor.color(0x7C251A))
                        )
                )
        );

        damageAttributes.addAll(
                Arrays.asList(
                        new BonusDamageAttribute(
                                new NamespacedKey(plugin, "damage"),
                                Component.text("Bonus Damage").color(TextColor.color(0xD45B3D))
                        ),
                        new CritAttribute(
                                new NamespacedKey(plugin, "critrate"),
                                Component.text("Crit Rate").color(TextColor.color(0xD45B3D))
                        ),
                        new WitherAttribute(
                                new NamespacedKey(plugin, "withering"),
                                Component.text("Withering").color(TextColor.color(0x575757))
                        ),
                        new VenomAttribute(
                                new NamespacedKey(plugin, "venomous"),
                                Component.text("Venomous").color(TextColor.color(0xAC32))
                        ),
                        new VampirismAttribute(
                                new NamespacedKey(plugin, "vampirism"),
                                Component.text("Vampiric").color(TextColor.color(0xFF4836))
                        )

                        //TODO: More...
                )
        );
    }
}
