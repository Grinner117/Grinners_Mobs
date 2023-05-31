package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.FireNewtEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FireNewtModel extends AnimatedGeoModel<FireNewtEntity> {
  @Override
   public ResourceLocation getModelResource(FireNewtEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "geo/newt.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(FireNewtEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/firenewt.png");
    }
    @Override
    public ResourceLocation getAnimationResource(FireNewtEntity animatable) {
       return new ResourceLocation(GrinnersMobs.MODID, "animations/newt.animation.json");

    }
}
