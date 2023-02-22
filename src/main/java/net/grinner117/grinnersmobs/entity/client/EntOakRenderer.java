package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.EntOakEntity;
import net.grinner117.grinnersmobs.entity.custom.EntlingOakEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class EntOakRenderer extends GeoEntityRenderer<EntOakEntity> {
    public EntOakRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EntOakModel());
        this.shadowRadius = 3.5f;
        this.scaleWidth = 8;
        this.scaleHeight = 8;
    }
    @Override
    public ResourceLocation getTextureLocation(EntOakEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/entoak.png");
    }
      public RenderType getRenderType(EntOakEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick){
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}