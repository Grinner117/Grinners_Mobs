package net.grinner117.grinnersmobs.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
<<<<<<< HEAD
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class DeathSpikeEntity extends Monster implements IAnimatable {
    AnimationFactory manager = GeckoLibUtil.createFactory(this);
=======
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class DeathSpikeEntity extends Monster implements GeoEntity {
  private AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);
>>>>>>> 1.19.3

    public DeathSpikeEntity(EntityType<? extends Monster> p_32725_, Level p_32726_) {
        super(p_32725_, p_32726_);
        this.xpReward = 500;
           }
    public boolean isOnFire() {
        return false;
    }

       public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 200.0D)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.ATTACK_SPEED, 5.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.001F)
                .add(Attributes.FOLLOW_RANGE, 164.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 2.0D)
                .add(Attributes.ARMOR_TOUGHNESS, 8.0D)
                .add(Attributes.ARMOR, 8.0D).build();

    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 0.25F, 0.5D, 0.5D));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, PureTitanVillagerEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, PureTitanLankyEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.4F, true));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.7D));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Skeleton.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Horse.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Chicken.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Sheep.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Zombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EnderMan.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Piglin.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PiglinBrute.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WitherSkeleton.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WitherBoss.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Rabbit.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Creeper.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Slime.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Phantom.class, true));
    }

    public SoundSource getSoundSource() {
        return SoundSource.MASTER;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(SoundEvents.WOLF_STEP, 1.5F, 1.5F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.WOLF_GROWL;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.WOLF_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.WOLF_STEP;
    }

    protected float getSoundVolume() {
        return 5.0F;
    }

<<<<<<< HEAD
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.deathspike.walk", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.deathspike.idle", true));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.deathspike.attack", false));
=======
    private PlayState predicate(AnimationState animationState) {
        if (animationState.isMoving()) {
            animationState.getController().setAnimation(RawAnimation.begin().then("animation.deathspike.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        animationState.getController().setAnimation(RawAnimation.begin().then("animation.deathspike.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationState state) {
        if (this.swinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            state.getController().forceAnimationReset();
            state.getController().setAnimation(RawAnimation.begin()
                    .then("animation.deathspike.attack", Animation.LoopType.PLAY_ONCE));
>>>>>>> 1.19.3
            this.swinging = false;
        }
        return PlayState.CONTINUE;
    }

    @Override
<<<<<<< HEAD
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


=======
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controller",
                0, this::predicate));
        controllers.add(new AnimationController(this, "attackController",
                0, this::attackPredicate));
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return factory;
    }
>>>>>>> 1.19.3
}
