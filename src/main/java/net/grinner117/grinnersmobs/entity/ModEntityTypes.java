package net.grinner117.grinnersmobs.entity;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.DeathSpikeEntity;
import net.grinner117.grinnersmobs.entity.custom.PureTitanLankyEntity;
import net.grinner117.grinnersmobs.entity.custom.PureTitanVillagerEntity;
import net.grinner117.grinnersmobs.entity.custom.SpikeProjectileEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GrinnersMobs.MODID);
    public static final RegistryObject<EntityType<SpikeProjectileEntity>> SPIKEPROJECTILE = ENTITY_TYPES.register("spikeprojectile",
            () -> EntityType.Builder.of((EntityType.EntityFactory<SpikeProjectileEntity>) SpikeProjectileEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).build("spikeprojectile"));
    public static final RegistryObject<EntityType<PureTitanVillagerEntity>> PURETITANVILLAGER =
            ENTITY_TYPES.register("puretitanvillager",
                    () -> EntityType.Builder.of(PureTitanVillagerEntity::new, MobCategory.MONSTER)
                            .sized(3.0F, 12.0F).clientTrackingRange(50)
                            .build(new ResourceLocation(GrinnersMobs.MODID,"puretitanvillager").toString()));
    public static final RegistryObject<EntityType<PureTitanLankyEntity>> PURETITANLANKY =
            ENTITY_TYPES.register("puretitanlanky",
                    () -> EntityType.Builder.of(PureTitanLankyEntity::new, MobCategory.MONSTER)
<<<<<<< HEAD
                            .sized(3.0F, 20.0F).clientTrackingRange(50)
=======
                            .sized(3.0F, 18.0F).clientTrackingRange(50)
>>>>>>> 1.19.3
                            .build(new ResourceLocation(GrinnersMobs.MODID,"puretitanlanky").toString()));
    public static final RegistryObject<EntityType<DeathSpikeEntity>> DEATHSPIKE =
            ENTITY_TYPES.register("deathspike",
                    () -> EntityType.Builder.of(DeathSpikeEntity::new, MobCategory.MONSTER)
<<<<<<< HEAD
                            .sized(2.0F, 1.0F).clientTrackingRange(50)
=======
                            .sized(2.0F, 2.0F).clientTrackingRange(50)
>>>>>>> 1.19.3
                            .build(new ResourceLocation(GrinnersMobs.MODID,"deathspike").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
