package net.grinner117.grinnersmobs.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;


public class DireRatEntity extends Rat {
    public DireRatEntity(EntityType<? extends Monster> EntityType, Level Level) {
        super(EntityType, Level);
        this.xpReward = 40;
    }
    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 12.0D)
                .add(Attributes.ATTACK_DAMAGE, 4.0D)
                .add(Attributes.ATTACK_SPEED, 1.0F)
                .add(Attributes.MOVEMENT_SPEED, 1.0F)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 132.0F)
                .add(Attributes.FOLLOW_RANGE, 64.0D).build();
    }
}