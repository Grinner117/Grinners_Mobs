package net.grinner117.grinnersmobs.entity.custom;

import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class DeathSpikeEntity extends Monster implements Enemy, IAnimatable {
    AnimationFactory manager = GeckoLibUtil.createFactory(this);
    private static final EntityDataAccessor<Boolean> DATA_IS_CHARGING = SynchedEntityData.defineId(DeathSpikeEntity.class, EntityDataSerializers.BOOLEAN);
    private int explosionPower = 1;

    public DeathSpikeEntity(EntityType<? extends DeathSpikeEntity> p_32725_, Level p_32726_) {
        super(p_32725_, p_32726_);
        this.xpReward = 500;
    }

    protected void registerGoals() {
               this.goalSelector.addGoal(7, new DeathSpikeEntity.GhastLookGoal(this));
        this.goalSelector.addGoal(7, new DeathSpikeEntity.GhastShootFireballGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (p_32755_) -> {
            return Math.abs(p_32755_.getY() - this.getY()) <= 4.0D;
        }));
    }

    public boolean isCharging() {
        return this.entityData.get(DATA_IS_CHARGING);
    }

    public void setCharging(boolean p_32759_) {
        this.entityData.set(DATA_IS_CHARGING, p_32759_);
    }

    public int getExplosionPower() {
        return this.explosionPower;
    }

    protected boolean shouldDespawnInPeaceful() {
        return true;
    }

       protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_IS_CHARGING, false);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 300.0D)
                .add(Attributes.ATTACK_DAMAGE, 25.0D)
                .add(Attributes.ATTACK_SPEED, 0.1F)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 20.0F)
                .add(Attributes.FOLLOW_RANGE, 64.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 2.0D).build();
    }


    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }
    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(SoundEvents.WOLF_STEP, 1.5F, 1.5F);
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
        return 5.0F;
    }

      public int getMaxSpawnClusterSize() {
        return 4;
    }

    public void addAdditionalSaveData(CompoundTag p_32744_) {
        super.addAdditionalSaveData(p_32744_);
        p_32744_.putByte("ExplosionPower", (byte)this.explosionPower);
    }

    public void readAdditionalSaveData(CompoundTag p_32733_) {
        super.readAdditionalSaveData(p_32733_);
        if (p_32733_.contains("ExplosionPower", 99)) {
            this.explosionPower = p_32733_.getByte("ExplosionPower");
        }

    }

    protected float getStandingEyeHeight(Pose p_32741_, EntityDimensions p_32742_) {
        return 1.6F;
    }


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

    static class GhastLookGoal extends Goal {
        private final DeathSpikeEntity ghast;

        public GhastLookGoal(DeathSpikeEntity p_32762_) {
            this.ghast = p_32762_;
            this.setFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        public boolean canUse() {
            return true;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            if (this.ghast.getTarget() == null) {
                Vec3 vec3 = this.ghast.getDeltaMovement();
                this.ghast.setYRot(-((float)Mth.atan2(vec3.x, vec3.z)) * (180F / (float)Math.PI));
                this.ghast.yBodyRot = this.ghast.getYRot();
            } else {
                LivingEntity livingentity = this.ghast.getTarget();
                double d0 = 64.0D;
                if (livingentity.distanceToSqr(this.ghast) < 4096.0D) {
                    double d1 = livingentity.getX() - this.ghast.getX();
                    double d2 = livingentity.getZ() - this.ghast.getZ();
                    this.ghast.setYRot(-((float)Mth.atan2(d1, d2)) * (180F / (float)Math.PI));
                    this.ghast.yBodyRot = this.ghast.getYRot();
                }
            }

        }
    }

    static class GhastShootFireballGoal extends Goal {
        private final DeathSpikeEntity ghast;
        public int chargeTime;

        public GhastShootFireballGoal(DeathSpikeEntity p_32776_) {
            this.ghast = p_32776_;
        }

        public boolean canUse() {
            return this.ghast.getTarget() != null;
        }

        public void start() {
            this.chargeTime = 0;
        }

        public void stop() {
            this.ghast.setCharging(false);
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity livingentity = this.ghast.getTarget();
            if (livingentity != null) {
                double d0 = 64.0D;
                if (livingentity.distanceToSqr(this.ghast) < 4096.0D && this.ghast.hasLineOfSight(livingentity)) {
                    Level level = this.ghast.level;
                    ++this.chargeTime;
                    if (this.chargeTime == 5 && !this.ghast.isSilent()) {
                        level.levelEvent((Player)null, 1015, this.ghast.blockPosition(), 0);
                    }

                    if (this.chargeTime == 10) {
                        double d1 = 4.0D;
                        Vec3 vec3 = this.ghast.getViewVector(1.0F);
                        double d2 = livingentity.getX() - (this.ghast.getX() + vec3.x * 4.0D);
                        double d3 = livingentity.getY(0.5D) - (0.5D + this.ghast.getY(0.5D));
                        double d4 = livingentity.getZ() - (this.ghast.getZ() + vec3.z * 4.0D);
                        if (!this.ghast.isSilent()) {
                            level.levelEvent((Player)null, 1016, this.ghast.blockPosition(), 0);
                        }
                        LargeFireball largefireball = new LargeFireball(level, this.ghast, d2, d3, d4, this.ghast.getExplosionPower());
                        largefireball.setPos(this.ghast.getX() + vec3.x * 4.0D, this.ghast.getY(0.5D) + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
                        level.addFreshEntity(largefireball);
                        this.chargeTime = -40;
                    }
                } else if (this.chargeTime > 0) {
                    --this.chargeTime;
                }

                this.ghast.setCharging(this.chargeTime > 10);
            }
        }
    }
    }