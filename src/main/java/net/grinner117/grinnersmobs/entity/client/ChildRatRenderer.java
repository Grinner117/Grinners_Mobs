package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.ChildRatEntity;
import net.grinner117.grinnersmobs.entity.custom.EntlingOakEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class ChildRatRenderer extends GeoEntityRenderer<ChildRatEntity> {
    public ChildRatRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ChildRatModel());
        this.shadowRadius = 0.5f;
        this.scaleWidth = 0.5f;
        this.scaleHeight = 0.5f;
    }
    @Override
    public ResourceLocation getTextureLocation(ChildRatEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/childrat.png");
    }
      public RenderType getRenderType(ChildRatEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick){
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}