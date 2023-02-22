package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.EntOakEntity;
import net.grinner117.grinnersmobs.entity.custom.EntlingOakEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntOakModel extends GeoModel<EntOakEntity> {
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
