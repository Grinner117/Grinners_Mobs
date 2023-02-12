package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.PureTitanLankyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PureTitanLankyRenderer extends GeoEntityRenderer<PureTitanLankyEntity> {
    public PureTitanLankyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PureTitanLankyModel());
        this.shadowRadius = 2.5f;
        this.scaleWidth = 7;
        this.scaleHeight = 7;
    }
    @Override
    public ResourceLocation getTextureLocation(PureTitanLankyEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/puretitanlanky.png");
    }
    @Override
    public RenderType getRenderType(PureTitanLankyEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick){
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }

}