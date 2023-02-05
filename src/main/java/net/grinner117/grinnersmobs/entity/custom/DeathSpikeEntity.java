package net.grinner117.grinnersmobs.entity.custom;

import net.grinner117.grinnersmobs.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
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

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class DeathSpikeEntity extends Monster implements RangedAttackMob, IAnimatable {
    AnimationFactory manager = GeckoLibUtil.createFactory(this);

    public DeathSpikeEntity(EntityType<? extends Monster> p_32725_, Level p_32726_) {
        super(p_32725_, p_32726_);
        this.xpReward = 500;
        this.reassessWeaponGoal();
        }
        protected boolean shouldDespawnInPeaceful() {
        return false;
    }



    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 300.0D)
                .add(Attributes.ATTACK_DAMAGE, 0.1D)
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

        private final RangedBowAttackGoal<DeathSpikeEntity> bowGoal = new RangedBowAttackGoal<>(this, 1.0D, 0, 15.0F);
        private final MeleeAttackGoal meleeGoal = new MeleeAttackGoal(this, 0.1D, false) {
            public void stop() {
                super.stop();
                DeathSpikeEntity.this.setAggressive(false);
            }
            public void start() {
                super.start();
                DeathSpikeEntity.this.setAggressive(true);
            }
        };



        protected void registerGoals() {
            this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Wolf.class, 6.0F, 1.0D, 1.2D));
            this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
            this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
            this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

            this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
        }

        protected void populateDefaultEquipmentSlots(RandomSource p_218949_, DifficultyInstance p_218950_) {
            super.populateDefaultEquipmentSlots(p_218949_, p_218950_);
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
        }

        @Nullable
        public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_32146_, DifficultyInstance p_32147_, MobSpawnType p_32148_, @Nullable SpawnGroupData p_32149_, @Nullable CompoundTag p_32150_) {
            p_32149_ = super.finalizeSpawn(p_32146_, p_32147_, p_32148_, p_32149_, p_32150_);
            RandomSource randomsource = p_32146_.getRandom();
            this.populateDefaultEquipmentSlots(randomsource, p_32147_);
            this.populateDefaultEquipmentEnchantments(randomsource, p_32147_);
            this.reassessWeaponGoal();
            this.setCanPickUpLoot(randomsource.nextFloat() < 0.55F * p_32147_.getSpecialMultiplier());
            if (this.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
                LocalDate localdate = LocalDate.now();
                int i = localdate.get(ChronoField.DAY_OF_MONTH);
                int j = localdate.get(ChronoField.MONTH_OF_YEAR);
                if (j == 10 && i == 31 && randomsource.nextFloat() < 0.25F) {
                    this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(randomsource.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
                    this.armorDropChances[EquipmentSlot.HEAD.getIndex()] = 0.0F;
                }
            }

            return p_32149_;
        }

        public void reassessWeaponGoal() {
            if (this.level != null && !this.level.isClientSide) {
                this.goalSelector.removeGoal(this.meleeGoal);
                this.goalSelector.removeGoal(this.bowGoal);
                ItemStack itemstack = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof net.minecraft.world.item.BowItem));
                if (itemstack.is(Items.BOW)) {
                    int i = 20;
                    if (this.level.getDifficulty() != Difficulty.HARD) {
                        i = 40;
                    }

                    this.bowGoal.setMinAttackInterval(i);
                    this.goalSelector.addGoal(4, this.bowGoal);
                } else {
                    this.goalSelector.addGoal(4, this.meleeGoal);
                }

            }
        }

        public void performRangedAttack(LivingEntity p_32141_, float p_32142_) {
            ItemStack itemstack = this.getProjectile(this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof net.minecraft.world.item.BowItem)));
            AbstractArrow abstractarrow = this.getArrow(itemstack, p_32142_);
            if (this.getMainHandItem().getItem() instanceof net.minecraft.world.item.BowItem)
                abstractarrow = ((net.minecraft.world.item.BowItem)this.getMainHandItem().getItem()).customArrow(abstractarrow);
            double d0 = p_32141_.getX() - this.getX();
            double d1 = p_32141_.getY(0.3333333333333333D) - abstractarrow.getY();
            double d2 = p_32141_.getZ() - this.getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            abstractarrow.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level.getDifficulty().getId() * 4));
            this.playSound(SoundEvents.SLIME_ATTACK, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            this.level.addFreshEntity(abstractarrow);
        }

        protected AbstractArrow getArrow(ItemStack p_32156_, float p_32157_) {
            return ProjectileUtil.getMobArrow(this, p_32156_, p_32157_);
        }

        public boolean canFireProjectileWeapon(ProjectileWeaponItem p_32144_) {
            return p_32144_ == Items.BOW;
        }

        public void readAdditionalSaveData(CompoundTag p_32152_) {
            super.readAdditionalSaveData(p_32152_);
            this.reassessWeaponGoal();
        }

        public void setItemSlot(EquipmentSlot p_32138_, ItemStack p_32139_) {
            super.setItemSlot(p_32138_, p_32139_);
            if (!this.level.isClientSide) {
                this.reassessWeaponGoal();
            }

    }

    }
