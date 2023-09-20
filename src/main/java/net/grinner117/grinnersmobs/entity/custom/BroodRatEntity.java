package net.grinner117.grinnersmobs.entity.custom;

import net.grinner117.grinnersmobs.entity.ModEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;


public class BroodRatEntity extends Rat {

    private float yRot;

    public BroodRatEntity(EntityType<? extends Monster> EntityType, Level Level) {
        super(EntityType, Level);
        this.xpReward = 40;
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 35.0D)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.ATTACK_SPEED, 1.0F)
                .add(Attributes.MOVEMENT_SPEED, 1.0F)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 132.0F)
                .add(Attributes.FOLLOW_RANGE, 64.0D).build();
    }

    //summons a childratentity every 15 seconds
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.tickCount % 400 == 0) {
            ChildRatEntity ratsummon = new ChildRatEntity(ModEntityTypes.CHILDRAT.get(), this.level);
            ratsummon.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, 0.0F);
            this.level.addFreshEntity(ratsummon);
        }
    }
}
