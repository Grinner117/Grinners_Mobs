package net.grinner117.grinnersmobs.entity;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.*;
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
                            .sized(3.0F, 20.0F).clientTrackingRange(50)
                            .build(new ResourceLocation(GrinnersMobs.MODID,"puretitanlanky").toString()));
    public static final RegistryObject<EntityType<DeathSpikeEntity>> DEATHSPIKE =
            ENTITY_TYPES.register("deathspike",
                    () -> EntityType.Builder.of(DeathSpikeEntity::new, MobCategory.MONSTER)
                            .sized(2.0F, 2.0F).clientTrackingRange(50)
                            .build(new ResourceLocation(GrinnersMobs.MODID,"deathspike").toString()));
    public static final RegistryObject<EntityType<EntlingOakEntity>> ENTLINGOAK =
            ENTITY_TYPES.register("entlingoak",
                    () -> EntityType.Builder.of(EntlingOakEntity::new, MobCategory.MONSTER)
                            .sized(2.0F, 3.0F).clientTrackingRange(60)
                            .build(new ResourceLocation(GrinnersMobs.MODID,"entlingoak").toString()));
    public static final RegistryObject<EntityType<EntOakEntity>> ENTOAK =
            ENTITY_TYPES.register("entoak",
                    () -> EntityType.Builder.of(EntOakEntity::new, MobCategory.MONSTER)
                            .sized(3.0F, 8.0F).clientTrackingRange(70)
                            .build(new ResourceLocation(GrinnersMobs.MODID,"entoak").toString()));
    public static final RegistryObject<EntityType<ChildRatEntity>> CHILDRAT =
            ENTITY_TYPES.register("childrat",
                    () -> EntityType.Builder.of(ChildRatEntity::new, MobCategory.MONSTER)
                            .sized(0.5F, 0.5F).clientTrackingRange(20)
                            .build(new ResourceLocation(GrinnersMobs.MODID,"childrat").toString()));
    public static final RegistryObject<EntityType<DireRatEntity>> DIRERAT =
            ENTITY_TYPES.register("direrat",
                    () -> EntityType.Builder.of(DireRatEntity::new, MobCategory.MONSTER)
                            .sized(1.0F, 1.0F).clientTrackingRange(30)
                            .build(new ResourceLocation(GrinnersMobs.MODID,"direrat").toString()));
    public static final RegistryObject<EntityType<BroodRatEntity>> BROODRAT =
            ENTITY_TYPES.register("broodrat",
                    () -> EntityType.Builder.of(BroodRatEntity::new, MobCategory.MONSTER)
                            .sized(2.0F, 2.0F).clientTrackingRange(30)
                            .build(new ResourceLocation(GrinnersMobs.MODID,"broodrat").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
