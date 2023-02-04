package net.grinner117.grinnersmobs.item;

import net.grinner117.grinnersmobs.entity.ModEntityTypes;
import net.grinner117.grinnersmobs.entity.custom.SpikeProjectileEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SpikeProjectileItem extends ArrowItem {
    public SpikeProjectileItem(Properties props) {
        super(props);

    }
    @Override
    public AbstractArrow createArrow(Level world, ItemStack ammoStack, LivingEntity shooter) {
        return new SpikeProjectileEntity(ModEntityTypes.SPIKEPROJECTILE.get(), shooter, world);
    }
}