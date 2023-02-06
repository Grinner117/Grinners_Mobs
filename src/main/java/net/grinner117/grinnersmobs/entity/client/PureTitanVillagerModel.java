package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.PureTitanVillagerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PureTitanVillagerModel extends GeoModel<PureTitanVillagerEntity> {
    @Override
    public ResourceLocation getModelResource(PureTitanVillagerEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "geo/puretitanvillager.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PureTitanVillagerEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/puretitanvillager.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PureTitanVillagerEntity animatable) {
        return new ResourceLocation(GrinnersMobs.MODID, "animations/puretitanvillager.animation.json");

    }
}
