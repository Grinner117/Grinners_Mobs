package net.grinner117.grinnersmobs.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
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


public class PureTitanVillagerEntity extends Monster implements IAnimatable {

    private static final float KNOCKBACK_RESISTANCE = 1.0F;
    private static final float ATTACK_KNOCKBACK = 1.5F;
    AnimationFactory manager = GeckoLibUtil.createFactory(this);

    public PureTitanVillagerEntity(EntityType<? extends Monster> EntityType, Level Level) {
        super(EntityType, Level);
        this.xpReward = 10;
    }

    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Spider.class, EntityDataSerializers.BYTE);

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 200.0D)
                .add(Attributes.ATTACK_DAMAGE, 20.0D)
                .add(Attributes.ATTACK_SPEED, 0.25F)
                .add(Attributes.MOVEMENT_SPEED, 1.0F)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 2.0F)
                .add(Attributes.JUMP_STRENGTH, 10.0F)
                .add(Attributes.FOLLOW_RANGE, 64.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 8.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 2.0D).build();

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 0.20F, false));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 128.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
    }

    protected PathNavigation createNavigation(Level p_33802_) {
        return new WallClimberNavigation(this, p_33802_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte) 0);
    }

    public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }

    }

    public boolean onClimbable() {
        return this.isClimbing();
    }

    public boolean isClimbing() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public void setClimbing(boolean p_33820_) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (p_33820_) {
            b0 = (byte) (b0 | 1);
        } else {
            b0 = (byte) (b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.puretitanvillager.walk", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.puretitanvillager.idle", true));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.puretitanvillager.attack", false));
            this.swinging = false;
        }
        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
        data.addAnimationController(new AnimationController(this, "attackController",
                0, this::attackPredicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return manager;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(SoundEvents.GRAVEL_BREAK, 4.0F, 0.01F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ZOMBIE_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENDERMAN_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.GRAVEL_BREAK;
    }

    protected float getSoundVolume() {
        return 15.0F;
    }
}