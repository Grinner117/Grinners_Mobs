package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.EntlingOakEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class EntlingOakRenderer extends GeoEntityRenderer<EntlingOakEntity> {
    public EntlingOakRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EntlingOakModel());
        this.shadowRadius = 1.0f;
        this.scaleWidth = 3;
        this.scaleHeight = 3;
    }
    @Override
    public ResourceLocation getTextureLocation(EntlingOakEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/entling_oak.png");
    }
      public RenderType getRenderType(EntlingOakEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick){
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}