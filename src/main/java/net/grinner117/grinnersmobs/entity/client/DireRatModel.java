package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.ChildRatEntity;
import net.grinner117.grinnersmobs.entity.custom.DireRatEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DireRatModel extends GeoModel<DireRatEntity> {
    @Override
    public ResourceLocation getModelResource(DireRatEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "geo/rat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DireRatEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/direrat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DireRatEntity animatable) {
        return new ResourceLocation(GrinnersMobs.MODID, "animations/rat.animation.json");

    }
}
