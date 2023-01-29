package net.grinner117.grinnersmobs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.PureTitanLankyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PureTitanLankyRenderer extends GeoEntityRenderer<PureTitanLankyEntity> {
    public PureTitanLankyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PureTitanLankyModel());
        this.shadowRadius = 2.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(PureTitanLankyEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/puretitanlanky.png");
    }
    @Override
    public RenderType getRenderType(PureTitanLankyEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(6.0f, 6.0f, 6.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}