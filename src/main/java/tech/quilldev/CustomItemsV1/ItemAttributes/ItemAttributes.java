package tech.quilldev.CustomItemsV1.ItemAttributes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnDeathAttributes.GoldOnDeathAttribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnDeathAttributes.RandomBuffOnDeathAttribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.DamageModifier.BonusDamageOnHitAttribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.DamageModifier.CritChanceOnHitAttribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.OnHitAttribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.ExternalEffect.ChainOnHitAttribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.ExternalEffect.FireOnHitAttribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.ExternalEffect.VampirismOnHitAttribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnHitAttributes.PotionBased.*;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnDeathAttributes.OnDeathAttribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnDeathAttributes.RatOnDeathAttribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.OnUseAttributes.*;
import tech.quilldev.CustomItemsV1.ItemAttributes.ToolAttributes.ToolAttribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.ToolAttributes.VeinMineAttributes.LumberjackToolAttribute;
import tech.quilldev.CustomItemsV1.ItemAttributes.ToolAttributes.VeinMineAttributes.VeinMineToolAttribute;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemAttributes {
    public ArrayList<OnUseAttribute> onUseAttributes = new ArrayList<>();
    public ArrayList<OnHitAttribute> onHitAttributes = new ArrayList<>();
    public ArrayList<OnDeathAttribute> onDeathAttributes = new ArrayList<>();
    public ArrayList<ToolAttribute> toolAttributes = new ArrayList<>();
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
                                Component.text("Zeus").color(TextColor.color(0xDABE41))
                        ),
                        new DemonicOnUseAttribute(
                                new NamespacedKey(plugin, "demonic"),
                                Component.text("Demonic").color(TextColor.color(0x2E0E84))
                        ),
                        new RegenOnUseAtrribute(
                                new NamespacedKey(plugin, "regen"),
                                Component.text("Regen").color(TextColor.color(0xFF3824))
                        ),
                        new CloakOnUseAttribute(
                                new NamespacedKey(plugin, "cloak"),
                                Component.text("Cloak").color(TextColor.color(0x2E0E84))
                        ),
                        new FireballOnUseAttribute(
                                new NamespacedKey(plugin, "fireball"),
                                Component.text("Fireball").color(TextColor.color(0xFF3824))
                        )
                )
        );

        onHitAttributes.addAll(
                Arrays.asList(
                        new BonusDamageOnHitAttribute(
                                new NamespacedKey(plugin, "damage"),
                                Component.text("Bonus Damage").color(TextColor.color(0xFF3824))
                        ),
                        new CritChanceOnHitAttribute(
                                new NamespacedKey(plugin, "critrate"),
                                Component.text("Crit Rate").color(TextColor.color(0xDAAF00))
                        ),
                        new WitherOnHitAttribute(
                                new NamespacedKey(plugin, "withering"),
                                Component.text("Withering").color(TextColor.color(0x2E0E84))
                        ),
                        new VenomOnHitAttribute(
                                new NamespacedKey(plugin, "venomous"),
                                Component.text("Venomous").color(TextColor.color(0x8807))
                        ),
                        new AscendOnHitAttribute(
                                new NamespacedKey(plugin, "ascend"),
                                Component.text("Ascend Chance").color(TextColor.color(0xDAAF00))
                        ),
                        new WeaknessOnHitAttribute(
                                new NamespacedKey(plugin, "weakness"),
                                Component.text("Weakness Chance").color(TextColor.color(0x2E0E84))
                        ),
                        new SlowOnHitAttribute(
                                new NamespacedKey(plugin, "slow"),
                                Component.text("Slow Chance").color(TextColor.color(0x2E0E84))
                        ),
                        new GlowOnHitAttribute(
                                new NamespacedKey(plugin, "glow"),
                                Component.text("Glow Chance").color(TextColor.color(0xDAAF00))
                        ),
                        new ShadowRealmOnHitAttribute(
                                new NamespacedKey(plugin, "shadow"),
                                Component.text("Shadow Laced").color(TextColor.color(0x2E0E84))
                        ),
                        new VampirismOnHitAttribute(
                                new NamespacedKey(plugin, "vampirism"),
                                Component.text("Vampiric").color(TextColor.color(0xFF3824))
                        ),
                        new FireOnHitAttribute(
                                new NamespacedKey(plugin, "firehit"),
                                Component.text("Burn Chance").color(TextColor.color(0xFF3824))
                        ),
                        new ChainOnHitAttribute(
                                new NamespacedKey(plugin, "chaindamage"),
                                Component.text("Chain Damage").color(TextColor.color(0xFF3824))
                        )

                        //TODO: More...
                )
        );

        onDeathAttributes.addAll(
                Arrays.asList(
                        new RatOnDeathAttribute(
                                new NamespacedKey(plugin, "death_rat"),
                                Component.text("Rat Lord").color(TextColor.color(0x2E0E84))
                        ),
                        new GoldOnDeathAttribute(
                                new NamespacedKey(plugin, "death_gold"),
                                Component.text("Midas Touch").color(TextColor.color(0xDAAF00))
                        ),
                        new RandomBuffOnDeathAttribute(
                                new NamespacedKey(plugin, "random_effect"),
                                Component.text("Gamblers Heart")
                        )
                )
        );

        toolAttributes.addAll(
                Arrays.asList(
                        new LumberjackToolAttribute(
                                new NamespacedKey(plugin, "tool_lumberjack"),
                                Component.text("Lumberjack")),
                        new VeinMineToolAttribute(
                                new NamespacedKey(plugin, "tool_veinmine"),
                                Component.text("Vein Miner")
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

    public ToolAttribute getToolAttribute(String query) {
        final var match = this.toolAttributes
                .stream()
                .filter(attr -> attr.key.value().equalsIgnoreCase(query))
                .findFirst();
        return match.orElse(null);
    }
}
