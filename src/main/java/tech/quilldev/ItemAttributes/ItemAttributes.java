package tech.quilldev.ItemAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import tech.quilldev.ItemAttributes.DamageAttribute.DamageModifier.BonusDamageAttribute;
import tech.quilldev.ItemAttributes.DamageAttribute.DamageModifier.CritAttribute;
import tech.quilldev.ItemAttributes.DamageAttribute.DamageAttribute;
import tech.quilldev.ItemAttributes.DamageAttribute.ExternalEffect.ChainDamageEffect;
import tech.quilldev.ItemAttributes.DamageAttribute.ExternalEffect.FireHitEffect;
import tech.quilldev.ItemAttributes.DamageAttribute.ExternalEffect.VampirismAttribute;
import tech.quilldev.ItemAttributes.DamageAttribute.PotionBased.*;
import tech.quilldev.ItemAttributes.DeathAttributes.DeathAttribute;
import tech.quilldev.ItemAttributes.DeathAttributes.DeathToRat;
import tech.quilldev.ItemAttributes.UseAttribute.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemAttributes {
    public ArrayList<UseAttribute> useAttributes = new ArrayList<>();
    public ArrayList<DamageAttribute> damageAttributes = new ArrayList<>();
    public ArrayList<DeathAttribute> deathAttributes = new ArrayList<>();
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
                        ),
                        new RegenUseEffect(
                                new NamespacedKey(plugin, "regen"),
                                Component.text("Regen").color(TextColor.color(0xFF5227))
                        ),
                        new CloakUseAttribute(
                                new NamespacedKey(plugin, "cloak"),
                                Component.text("Cloak").color(TextColor.color(0xFF5227))
                        ),
                        new FireballUseEffect(
                                new NamespacedKey(plugin, "fireball"),
                                Component.text("Fireball").color(TextColor.color(0xFF5227))
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
                        new AscendAttribute(
                                new NamespacedKey(plugin, "ascend"),
                                Component.text("Ascend Chance").color(TextColor.color(0x36C61))
                        ),
                        new WeaknessAttribute(
                                new NamespacedKey(plugin, "weakness"),
                                Component.text("Weakness Chance").color(TextColor.color(0x6C2C33))
                        ),
                        new SlowAttribute(
                                new NamespacedKey(plugin, "slow"),
                                Component.text("Slow Chance").color(TextColor.color(0xB0C3))
                        ),
                        new GlowAttribute(
                                new NamespacedKey(plugin, "glow"),
                                Component.text("Glow Chance").color(TextColor.color(0xDABE41))
                        ),
                        new ShadowRealmAttribute(
                                new NamespacedKey(plugin, "shadow"),
                                Component.text("Shadow Laced").color(TextColor.color(0x2E0E84))
                        ),
                        new VampirismAttribute(
                                new NamespacedKey(plugin, "vampirism"),
                                Component.text("Vampiric").color(TextColor.color(0xFF4836))
                        ),
                        new FireHitEffect(
                                new NamespacedKey(plugin, "firehit"),
                                Component.text("Burn Chance").color(TextColor.color(0xFF1610))
                        ),
                        new ChainDamageEffect(
                                new NamespacedKey(plugin, "chaindamage"),
                                Component.text("Chain Damage").color(TextColor.color(0x832294))
                        )

                        //TODO: More...
                )
        );

        deathAttributes.addAll(
                Arrays.asList(
                        new DeathToRat(
                                new NamespacedKey(plugin, "death_rat"),
                                Component.text("Rat Lord").color(TextColor.color(0x5906))
                        )
                )
        );
    }

    public UseAttribute getUseAttribute(String query) {
        final var match = this.useAttributes
                .stream()
                .filter(attr -> attr.key.getKey().equalsIgnoreCase(query))
                .findFirst();
        return match.orElse(null);
    }

    public DamageAttribute getDamageAttribute(String query) {
        final var match = this.damageAttributes
                .stream()
                .filter(attr -> attr.key.value().equalsIgnoreCase(query))
                .findFirst();
        return match.orElse(null);
    }


    public DeathAttribute getDeathAttribute(String query) {
        final var match = this.deathAttributes
                .stream()
                .filter(attr -> attr.key.value().equalsIgnoreCase(query))
                .findFirst();
        return match.orElse(null);
    }
}
