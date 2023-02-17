package net.grinner117.grinnersmobs.entity.client;

<<<<<<< HEAD
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
=======
>>>>>>> 1.19.3
import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.PureTitanLankyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
<<<<<<< HEAD
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
=======
import software.bernie.geckolib.renderer.GeoEntityRenderer;
>>>>>>> 1.19.3

public class PureTitanLankyRenderer extends GeoEntityRenderer<PureTitanLankyEntity> {
    public PureTitanLankyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PureTitanLankyModel());
<<<<<<< HEAD
        this.shadowRadius = 2.0f;
=======
        this.shadowRadius = 2.5f;
        this.scaleWidth = 7;
        this.scaleHeight = 7;
>>>>>>> 1.19.3
    }
    @Override
    public ResourceLocation getTextureLocation(PureTitanLankyEntity instance) {
        return new ResourceLocation(GrinnersMobs.MODID, "textures/entity/puretitanlanky.png");
    }
    @Override
<<<<<<< HEAD
    public RenderType getRenderType(PureTitanLankyEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(6.0f, 6.0f, 6.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
=======
    public RenderType getRenderType(PureTitanLankyEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick){
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }

>>>>>>> 1.19.3
}