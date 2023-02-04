package net.grinner117.grinnersmobs.entity.custom;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class SpikeProjectileEntity extends AbstractArrow {
    public SpikeProjectileEntity(EntityType<SpikeProjectileEntity> entityType, Level world) {
        super(entityType, world);
        this.setBaseDamage(15.0F);
    }

    public SpikeProjectileEntity(EntityType<SpikeProjectileEntity> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);
        this.setBaseDamage(15.0F);
    }

    public SpikeProjectileEntity(EntityType<SpikeProjectileEntity> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
        this.setBaseDamage(15.0F);
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    // in ExplosiveArrowEntity.java
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);

    }
  }