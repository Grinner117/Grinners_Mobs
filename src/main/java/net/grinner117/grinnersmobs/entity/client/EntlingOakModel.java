package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.EntlingOakEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntlingOakModel extends GeoModel<EntlingOakEntity> {
    @Override
    public ResourceLocation getModelResource(EntlingOakEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "geo/entling.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntlingOakEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/entling_oak.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntlingOakEntity animatable) {
        return new ResourceLocation(GrinnersMobs.MODID, "animations/entling.animation.json");

    }
}
