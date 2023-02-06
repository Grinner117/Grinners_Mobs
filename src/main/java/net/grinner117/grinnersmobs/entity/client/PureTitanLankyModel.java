package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.PureTitanLankyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PureTitanLankyModel extends GeoModel<PureTitanLankyEntity> {
    @Override
    public ResourceLocation getModelResource(PureTitanLankyEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "geo/puretitanlanky.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PureTitanLankyEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/puretitanlanky.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PureTitanLankyEntity animatable) {
        return new ResourceLocation(GrinnersMobs.MODID, "animations/puretitanlanky.animation.json");

    }
}
