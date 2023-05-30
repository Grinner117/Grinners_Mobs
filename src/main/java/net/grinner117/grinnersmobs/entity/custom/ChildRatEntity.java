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
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;


public class ChildRatEntity extends BroodRatEntity implements GeoEntity {

    private AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);
    public ChildRatEntity(EntityType<? extends Monster> EntityType, Level Level) {
        super(EntityType, Level);
        this.xpReward = 15;
    }

    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Spider.class, EntityDataSerializers.BYTE);
    public static final int REINFORCEMENT_ATTEMPTS = 50;
    public static final int REINFORCEMENT_RANGE_MAX = 40;
    public static final int REINFORCEMENT_RANGE_MIN = 7;
    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 2.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0D)
                .add(Attributes.ATTACK_SPEED, 1.0F)
                .add(Attributes.MOVEMENT_SPEED, 1.0F)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 132.0F)
                .add(Attributes.FOLLOW_RANGE, 64.0D).build();
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.3F, false));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.4f ));

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


    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(SoundEvents.WOLF_STEP, 1.0F, 0.5F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.WOLF_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.WOLF_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.WOLF_STEP;
    }

    protected float getSoundVolume() {
        return 1.0F;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controller",
                0, this::predicate));
        controllers.add(new AnimationController(this, "attackController",
                0, this::attackPredicate));

    }
        private PlayState predicate(AnimationState animationState) {
            if(animationState.isMoving()) {
                animationState.getController().setAnimation(RawAnimation.begin().then("animation.rat.walk", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            }

            animationState.getController().setAnimation(RawAnimation.begin().then("animation.rat.idle", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        private PlayState attackPredicate(AnimationState state) {
            if(this.swinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
                state.getController().forceAnimationReset();
                state.getController().setAnimation(RawAnimation.begin()
                        .then("animation.rat.attack", Animation.LoopType.PLAY_ONCE));
                this.swinging = false;
            }

            return PlayState.CONTINUE;
        }

          @Override
        public AnimatableInstanceCache getAnimatableInstanceCache() {
              return factory;
          }
}
