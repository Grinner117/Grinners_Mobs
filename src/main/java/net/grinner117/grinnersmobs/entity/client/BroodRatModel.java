package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.BroodRatEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BroodRatModel extends AnimatedGeoModel<BroodRatEntity> {
    @Override
    public ResourceLocation getModelResource(BroodRatEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "geo/rat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BroodRatEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/brooderat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BroodRatEntity animatable) {
        return new ResourceLocation(GrinnersMobs.MODID, "animations/rat.animation.json");

    }
}
