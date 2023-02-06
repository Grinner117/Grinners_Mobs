package net.grinner117.grinnersmobs.entity.client;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.SpikeProjectileEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SpikeProjectileRenderer extends ArrowRenderer<SpikeProjectileEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(GrinnersMobs.MODID, "textures/entity/spikeprojectile.png");

    public SpikeProjectileRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }


    public ResourceLocation getTextureLocation(SpikeProjectileEntity arrow) {
        return TEXTURE;
    }
}