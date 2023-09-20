package net.grinner117.grinnersmobs.entity.custom;


import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class EntOakEntity extends EnderMan implements IAnimatable {
	AnimationFactory manager = GeckoLibUtil.createFactory(this);

	public EntOakEntity(EntityType<? extends EnderMan> EntityType, Level Level) {
		super(EntityType, Level);
		this.xpReward = 600;
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.0D, false));

		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Monster.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Mob.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Animal.class, true));
	}

	public static AttributeSupplier setAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 300.0D)
				.add(Attributes.MOVEMENT_SPEED, (double) 0.0F)
				.add(Attributes.ATTACK_DAMAGE, 40.0D)
				.add(Attributes.FOLLOW_RANGE, 128.0D)
				.add(Attributes.ARMOR, 32.0D)
				.add(Attributes.ATTACK_KNOCKBACK, 15.0D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 32.0D)
				.add(Attributes.ARMOR_TOUGHNESS, 32.0D)
				.add(Attributes.ATTACK_SPEED, 0.5D)
				.build();
	}

	public boolean isSensitiveToWater() {
		return false;
	}

	//ambient sound
	protected SoundEvent getAmbientSound() {
		return SoundEvents.WOOD_STEP;
	}

	//hurt sound
	protected SoundEvent getHurtSound(DamageSource p_32527_) {
		return SoundEvents.WOOD_BREAK;
	}

	//death sound
	protected SoundEvent getDeathSound() {
		return SoundEvents.GHAST_DEATH;
	}


	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ent.walk", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ent.idle", true));
		return PlayState.CONTINUE;
	}

	private PlayState attackPredicate(AnimationEvent event) {
		if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
			event.getController().markNeedsReload();
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ent.attack", false));
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
}
