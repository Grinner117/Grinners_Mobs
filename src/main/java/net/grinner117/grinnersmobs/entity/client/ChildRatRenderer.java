package net.grinner117.grinnersmobs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.ChildRatEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public class ChildRatRenderer extends GeoEntityRenderer<ChildRatEntity> {
    public ChildRatRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ChildRatModel());
        this.shadowRadius = 0.5f;

    }
    @Override
    public ResourceLocation getTextureLocation(ChildRatEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/childrat.png");
    }
    @Override
    public RenderType getRenderType(ChildRatEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.5f, 0.5f, 0.5f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}