package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.DeathSpikeEntity;
import net.grinner117.grinnersmobs.entity.custom.FireNewtEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FireNewtRenderer extends GeoEntityRenderer<FireNewtEntity> {
    public FireNewtRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FireNewtModel());
        this.shadowRadius = 1.0f;
        this.scaleWidth = 1.25f;
        this.scaleHeight = 1.25f;

    }
    @Override
    public ResourceLocation getTextureLocation(FireNewtEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/firenewt.png");
    }

    public RenderType getRenderType(FireNewtEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource,
    float particalTick){
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}