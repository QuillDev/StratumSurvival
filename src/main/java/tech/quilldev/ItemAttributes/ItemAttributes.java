package tech.quilldev.ItemAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import tech.quilldev.ItemAttributes.OnHitAttributes.DamageModifier.BonusDamageOnHitAttribute;
import tech.quilldev.ItemAttributes.OnHitAttributes.DamageModifier.CritChanceOnHitAttribute;
import tech.quilldev.ItemAttributes.OnHitAttributes.OnHitAttribute;
import tech.quilldev.ItemAttributes.OnHitAttributes.ExternalEffect.ChainOnHitAttribute;
import tech.quilldev.ItemAttributes.OnHitAttributes.ExternalEffect.FireOnHitAttribute;
import tech.quilldev.ItemAttributes.OnHitAttributes.ExternalEffect.VampirismOnHitAttribute;
import tech.quilldev.ItemAttributes.OnHitAttributes.PotionBased.*;
import tech.quilldev.ItemAttributes.OnDeathAttributes.OnDeathAttribute;
import tech.quilldev.ItemAttributes.OnDeathAttributes.RatOnDeathAttribute;
import tech.quilldev.ItemAttributes.OnUseAttributes.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemAttributes {
    public ArrayList<OnUseAttribute> onUseAttributes = new ArrayList<>();
    public ArrayList<OnHitAttribute> onHitAttributes = new ArrayList<>();
    public ArrayList<OnDeathAttribute> onDeathAttributes = new ArrayList<>();
    public NamespacedKey levelKey;

    public ItemAttributes(Plugin plugin) {
        this.levelKey = new NamespacedKey(plugin, "rarity");
        this.initialize(plugin);
    }

    public void initialize(Plugin plugin) {
        onUseAttributes.addAll(
                Arrays.asList(
                        new ZeusOnUseAttribute(
                                new NamespacedKey(plugin, "zeus"),
                                Component.text("Zeus").color(TextColor.color(0x15E1FF))
                        ),
                        new DemonicOnUseAttribute(
                                new NamespacedKey(plugin, "demonic"),
                                Component.text("Demonic").color(TextColor.color(0x7C251A))
                        ),
                        new RegenOnUseAtrribute(
                                new NamespacedKey(plugin, "regen"),
                                Component.text("Regen").color(TextColor.color(0xFF5227))
                        ),
                        new CloakOnUseAttribute(
                                new NamespacedKey(plugin, "cloak"),
                                Component.text("Cloak").color(TextColor.color(0xFF5227))
                        ),
                        new FireballOnUseAttribute(
                                new NamespacedKey(plugin, "fireball"),
                                Component.text("Fireball").color(TextColor.color(0xFF5227))
                        )
                )
        );

        onHitAttributes.addAll(
                Arrays.asList(
                        new BonusDamageOnHitAttribute(
                                new NamespacedKey(plugin, "damage"),
                                Component.text("Bonus Damage").color(TextColor.color(0xD45B3D))
                        ),
                        new CritChanceOnHitAttribute(
                                new NamespacedKey(plugin, "critrate"),
                                Component.text("Crit Rate").color(TextColor.color(0xD45B3D))
                        ),
                        new WitherOnHitAttribute(
                                new NamespacedKey(plugin, "withering"),
                                Component.text("Withering").color(TextColor.color(0x575757))
                        ),
                        new VenomOnHitAttribute(
                                new NamespacedKey(plugin, "venomous"),
                                Component.text("Venomous").color(TextColor.color(0xAC32))
                        ),
                        new AscendOnHitAttribute(
                                new NamespacedKey(plugin, "ascend"),
                                Component.text("Ascend Chance").color(TextColor.color(0x36C61))
                        ),
                        new WeaknessOnHitAttribute(
                                new NamespacedKey(plugin, "weakness"),
                                Component.text("Weakness Chance").color(TextColor.color(0x6C2C33))
                        ),
                        new SlowOnHitAttribute(
                                new NamespacedKey(plugin, "slow"),
                                Component.text("Slow Chance").color(TextColor.color(0xB0C3))
                        ),
                        new GlowOnHitAttribute(
                                new NamespacedKey(plugin, "glow"),
                                Component.text("Glow Chance").color(TextColor.color(0xDABE41))
                        ),
                        new ShadowRealmOnHitAttribute(
                                new NamespacedKey(plugin, "shadow"),
                                Component.text("Shadow Laced").color(TextColor.color(0x2E0E84))
                        ),
                        new VampirismOnHitAttribute(
                                new NamespacedKey(plugin, "vampirism"),
                                Component.text("Vampiric").color(TextColor.color(0xFF4836))
                        ),
                        new FireOnHitAttribute(
                                new NamespacedKey(plugin, "firehit"),
                                Component.text("Burn Chance").color(TextColor.color(0xFF1610))
                        ),
                        new ChainOnHitAttribute(
                                new NamespacedKey(plugin, "chaindamage"),
                                Component.text("Chain Damage").color(TextColor.color(0x832294))
                        )

                        //TODO: More...
                )
        );

        onDeathAttributes.addAll(
                Arrays.asList(
                        new RatOnDeathAttribute(
                                new NamespacedKey(plugin, "death_rat"),
                                Component.text("Rat Lord").color(TextColor.color(0x5906))
                        )
                )
        );
    }

    public OnUseAttribute getUseAttribute(String query) {
        final var match = this.onUseAttributes
                .stream()
                .filter(attr -> attr.key.getKey().equalsIgnoreCase(query))
                .findFirst();
        return match.orElse(null);
    }

    public OnHitAttribute getDamageAttribute(String query) {
        final var match = this.onHitAttributes
                .stream()
                .filter(attr -> attr.key.value().equalsIgnoreCase(query))
                .findFirst();
        return match.orElse(null);
    }


    public OnDeathAttribute getDeathAttribute(String query) {
        final var match = this.onDeathAttributes
                .stream()
                .filter(attr -> attr.key.value().equalsIgnoreCase(query))
                .findFirst();
        return match.orElse(null);
    }
}
