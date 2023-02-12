package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;

import net.grinner117.grinnersmobs.entity.custom.PureTitanVillagerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PureTitanVillagerRenderer extends GeoEntityRenderer<PureTitanVillagerEntity> {
    public PureTitanVillagerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PureTitanVillagerModel());
        this.shadowRadius = 2.0f;
        this.scaleWidth = 12;
        this.scaleHeight = 12;
    }

    @Override
    public ResourceLocation getTextureLocation(PureTitanVillagerEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/puretitanvillager.png");
    }

    @Override
    public RenderType getRenderType(PureTitanVillagerEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick) {
        return super.getRenderType(animatable, texture, bufferSource, particalTick);

    }
}