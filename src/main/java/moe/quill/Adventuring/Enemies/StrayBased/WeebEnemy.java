package moe.quill.Adventuring.Enemies.StrayBased;

import moe.quill.Adventuring.Enemies.EnemyType;
import moe.quill.Crafting.Items.MaterialManager.HeadHelper;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterial;
import moe.quill.Crafting.Items.MaterialManager.StratumMaterials.StratumMaterialManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class WeebEnemy extends StrayEnemy {
    public WeebEnemy(StratumMaterialManager materialManager) {
        super(Component.text("Weeb"), materialManager, EnemyType.ENEMY_WEEB);
    }

    @Override
    public Entity spawn(Location location) {
        final var mob = spawnFreshEntity(location);
        final var equipment = mob.getEquipment();
        if (equipment == null) return null;
        equipment.setHelmet(HeadHelper.getHeadFromTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjQzMjI2NTM5MzZiMzFlZjUyZDEwNDYyYjgzNmE2ZWFiOTJmNTYxZDFiYjYzMWU3ZGFkMjBiOGFhYTY1ZDMyZiJ9fX0="));
        equipment.setItemInMainHand(materialManager.getItem(StratumMaterial.DAGGER_IRON));
        return null;
    }
}
