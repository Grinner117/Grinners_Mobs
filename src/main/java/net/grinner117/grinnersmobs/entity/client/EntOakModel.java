package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.EntOakEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EntOakModel extends AnimatedGeoModel<EntOakEntity> {
    @Override
    public ResourceLocation getModelResource(EntOakEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "geo/ent.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntOakEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/entoak.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntOakEntity animatable) {
        return new ResourceLocation(GrinnersMobs.MODID, "animations/ent.animation.json");

    }
}
