package moe.quill.Adventuring.Bosses.BossAttacks;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.LivingEntity;

public abstract class BossAttack {

    private final Component warningText;
    public BossAttack(Component warningText){
        this.warningText = warningText;
    }

    public Component getWarningText() {
        return warningText;
    }

    public abstract void execute(LivingEntity boss);
}
