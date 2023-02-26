package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.ChildRatEntity;
import net.grinner117.grinnersmobs.entity.custom.EntOakEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ChildRatModel extends GeoModel<ChildRatEntity> {
    @Override
    public ResourceLocation getModelResource(ChildRatEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "geo/rat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChildRatEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/childrat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChildRatEntity animatable) {
        return new ResourceLocation(GrinnersMobs.MODID, "animations/rat.animation.json");

    }
}
