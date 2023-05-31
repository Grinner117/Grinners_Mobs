package net.grinner117.grinnersmobs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.EntOakEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public class EntOakRenderer extends GeoEntityRenderer<EntOakEntity> {
    public EntOakRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EntOakModel());
        this.shadowRadius = 3.5f;

    }
    @Override
    public ResourceLocation getTextureLocation(EntOakEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/entoak.png");
    }
    @Override
    public RenderType getRenderType(EntOakEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(8.0f, 8.0f, 8.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}