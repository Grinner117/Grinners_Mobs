package net.grinner117.grinnersmobs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.FireNewtEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FireNewtRenderer extends GeoEntityRenderer<FireNewtEntity> {
    public FireNewtRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FireNewtModel());
        this.shadowRadius = 0.4f;
    }
    @Override
    public ResourceLocation getTextureLocation(FireNewtEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/firenewt.png");
    }
    @Override
    public RenderType getRenderType(FireNewtEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.25f, 1.25f, 1.25f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}