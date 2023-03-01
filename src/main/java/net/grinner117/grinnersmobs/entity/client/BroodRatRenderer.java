package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.BroodRatEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class BroodRatRenderer extends GeoEntityRenderer<BroodRatEntity> {
    public BroodRatRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BroodRatModel());
        this.shadowRadius = 1.0f;
        this.scaleWidth = 2.0f;
        this.scaleHeight = 2.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(BroodRatEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/broodrat.png");
    }
      public RenderType getRenderType(BroodRatEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick){
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}