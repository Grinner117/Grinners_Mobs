package net.grinner117.grinnersmobs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.DeathSpikeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DeathSpikeRenderer extends GeoEntityRenderer<DeathSpikeEntity> {
    public DeathSpikeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DeathSpikeModel());
        this.shadowRadius = 1.0f;


    }
    @Override
    public ResourceLocation getTextureLocation(DeathSpikeEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/deathspike.png");
    }

    @Override
    public RenderType getRenderType(DeathSpikeEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(2.0f, 2.0f, 2.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}