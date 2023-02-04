package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.DeathSpikeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DeathSpikeModel extends AnimatedGeoModel<DeathSpikeEntity> {
    @Override
   public ResourceLocation getModelResource(DeathSpikeEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "geo/deathspike.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DeathSpikeEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/deathspike.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DeathSpikeEntity animatable) {
       return new ResourceLocation(GrinnersMobs.MODID, "animations/deathspike.animation.json");

    }
}
