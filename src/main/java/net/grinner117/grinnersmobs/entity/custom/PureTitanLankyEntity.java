package net.grinner117.grinnersmobs.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;


public class PureTitanLankyEntity extends PureTitanVillagerEntity implements GeoEntity {
    private AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);
    public PureTitanLankyEntity(EntityType<? extends Monster> EntityType, Level Level) {
        super(EntityType, Level);
        this.xpReward = 300;
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
                animationState.getController().setAnimation(RawAnimation.begin().then("animation.puretitanlanky.walk", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            }

            animationState.getController().setAnimation(RawAnimation.begin().then("animation.puretitanlanky.idle", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        private PlayState attackPredicate(AnimationState state) {
            if(this.swinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
                state.getController().forceAnimationReset();
                state.getController().setAnimation(RawAnimation.begin()
                        .then("animation.puretitanlanky.attack", Animation.LoopType.PLAY_ONCE));
                this.swinging = false;
            }

            return PlayState.CONTINUE;
        }

          @Override
        public AnimatableInstanceCache getAnimatableInstanceCache() {
              return factory;
          }
}
