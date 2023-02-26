package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.ChildRatEntity;
import net.grinner117.grinnersmobs.entity.custom.DireRatEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class DireRatRenderer extends GeoEntityRenderer<DireRatEntity> {
    public DireRatRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DireRatModel());
        this.shadowRadius = 1.0f;
        this.scaleWidth = 1.0f;
        this.scaleHeight = 1.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(DireRatEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/direrat.png");
    }
      public RenderType getRenderType(DireRatEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick){
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}