package net.grinner117.grinnersmobs.event;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.entity.ModEntityTypes;
import net.grinner117.grinnersmobs.entity.custom.*;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = GrinnersMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.PURETITANVILLAGER.get(), PureTitanVillagerEntity.setAttributes());
            event.put(ModEntityTypes.PURETITANLANKY.get(), PureTitanLankyEntity.setAttributes());
            event.put(ModEntityTypes.DEATHSPIKE.get(), DeathSpikeEntity.setAttributes());
            event.put(ModEntityTypes.ENTLINGOAK.get(), EntlingOakEntity.setAttributes());
            event.put(ModEntityTypes.ENTOAK.get(), EntOakEntity.setAttributes());
        }
    }
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public class ArmorHandlers {

    }
}
