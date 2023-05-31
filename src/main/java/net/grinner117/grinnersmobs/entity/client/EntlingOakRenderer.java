package net.grinner117.grinnersmobs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.EntlingOakEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public class EntlingOakRenderer extends GeoEntityRenderer<EntlingOakEntity> {
    public EntlingOakRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EntlingOakModel());
        this.shadowRadius = 1.0f;

    }
    @Override
    public ResourceLocation getTextureLocation(EntlingOakEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/entling_oak.png");
    }
    @Override
    public RenderType getRenderType(EntlingOakEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(3.0f, 3.0f, 3.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}