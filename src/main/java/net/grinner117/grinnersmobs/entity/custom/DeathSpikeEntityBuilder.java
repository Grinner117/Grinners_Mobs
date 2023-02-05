package net.grinner117.grinnersmobs.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class DeathSpikeEntityBuilder {
    private EntityType<? extends Monster> p32725;
    private Level p32726;
    private EntityType<? extends AbstractSkeleton> p32133;
    private Level p32134;

    public DeathSpikeEntityBuilder setP_32725_(EntityType<? extends Monster> p32725) {
        this.p32725 = p32725;
        return this;
    }

    public DeathSpikeEntityBuilder setP_32726_(Level p32726) {
        this.p32726 = p32726;
        return this;
    }

    public DeathSpikeEntityBuilder setP_32133_(EntityType<? extends AbstractSkeleton> p32133) {
        this.p32133 = p32133;
        return this;
    }

    public DeathSpikeEntityBuilder setP_32134_(Level p32134) {
        this.p32134 = p32134;
        return this;
    }

    public DeathSpikeEntity createDeathSpikeEntity() {
        return new DeathSpikeEntity(p32725, p32726);
    }
}