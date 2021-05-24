package moe.quill.CustomItems.ItemHelpers;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

import java.util.Arrays;

public enum ItemRarity {
    UNKNOWN(-1, "?????", TextColor.color(0x6474CB)),
    COMMON(1, "COMMON", TextColor.color(0xB0ADAE)),
    UNCOMMON(2, "UNCOMMON", TextColor.color(0x4CC75C)),
    RARE(3, "RARE", TextColor.color(0x4BAFCB)),
    EPIC(4, "EPIC", TextColor.color(0xA357A6)),
    LEGENDARY(5, "LEGENDARY", TextColor.color(0xE04B46)),
    DEVELOPER(6, "DEVELOPER", TextColor.color(0xDCE43B));

    private final int level;
    private final Component name;
    public TextColor color;

    ItemRarity(int level, String name, TextColor color) {
        this.level = level;
        this.color = color;
        this.name = Component.text(name).style(Style.style(TextDecoration.BOLD)).color(color);//.style(Style.style(TextDecoration.BOLD));
    }

    public int getLevel() {
        return level;
    }

    public Component getName() {
        return name;
    }

    public TextColor getColor() {
        return color;
    }

    public static ItemRarity getRarity(int level) {
        return Arrays.stream(ItemRarity.values())
                .filter(rarity -> rarity.getLevel() == level)
                .findFirst()
                .orElse(ItemRarity.UNKNOWN);
    }
}
