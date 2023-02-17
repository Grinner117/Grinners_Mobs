package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.DeathSpikeEntity;
import net.minecraft.resources.ResourceLocation;
<<<<<<< HEAD
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DeathSpikeModel extends AnimatedGeoModel<DeathSpikeEntity> {
=======
import software.bernie.geckolib.model.GeoModel;

public class DeathSpikeModel extends GeoModel<DeathSpikeEntity> {
>>>>>>> 1.19.3
    @Override
   public ResourceLocation getModelResource(DeathSpikeEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "geo/deathspike.geo.json");
    }
<<<<<<< HEAD

=======
>>>>>>> 1.19.3
    @Override
    public ResourceLocation getTextureResource(DeathSpikeEntity object) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/deathspike.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DeathSpikeEntity animatable) {
       return new ResourceLocation(GrinnersMobs.MODID, "animations/deathspike.animation.json");

    }
}
