package net.grinner117.grinnersmobs.entity;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.custom.PureTitanVillagerEntity;
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

    public static final RegistryObject<EntityType<PureTitanVillagerEntity>> PURETITANVILLAGER =
            ENTITY_TYPES.register("puretitanvillager",
                    () -> EntityType.Builder.of(PureTitanVillagerEntity::new, MobCategory.MONSTER)
                            .sized(2.0F, 12.0F)
                            .build(new ResourceLocation(GrinnersMobs.MODID,"puretitanvillager").toString()));

    public static void register(IEventBus eventBus) {

        ENTITY_TYPES.register(eventBus);
    }
}
