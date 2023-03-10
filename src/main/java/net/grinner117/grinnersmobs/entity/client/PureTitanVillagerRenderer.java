package net.grinner117.grinnersmobs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.PureTitanVillagerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import org.jetbrains.annotations.Nullable;

public class PureTitanVillagerRenderer extends GeoEntityRenderer<PureTitanVillagerEntity> {
    public PureTitanVillagerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PureTitanVillagerModel());
        this.shadowRadius = 2.0f;
    }

    @Override
    public ResourceLocation getTextureLocation(PureTitanVillagerEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/puretitanvillager.png");
    }

    @Override
    public RenderType getRenderType(PureTitanVillagerEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(8.0f, 8.0f, 8.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}