package net.grinner117.grinnersmobs;

import net.grinner117.grinnersmobs.entity.ModEntityTypes;
import net.grinner117.grinnersmobs.entity.client.DeathSpikeRenderer;
import net.grinner117.grinnersmobs.entity.client.PureTitanLankyRenderer;
import net.grinner117.grinnersmobs.entity.client.PureTitanVillagerRenderer;
import net.grinner117.grinnersmobs.entity.client.SpikeProjectileRenderer;
import net.grinner117.grinnersmobs.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

import static net.grinner117.grinnersmobs.GrinnersMobs.MODID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MODID)
public class GrinnersMobs {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "grinnersmobs";

    // Directly reference a slf4j logger
    public GrinnersMobs() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        ModEntityTypes.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntityTypes.PURETITANVILLAGER.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(ModEntityTypes.PURETITANLANKY.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
        });
    }
      //PURETITANVILLAGER
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.PURETITANVILLAGER.get(), PureTitanVillagerRenderer::new);
            EntityRenderers.register(ModEntityTypes.PURETITANLANKY.get(), PureTitanLankyRenderer::new);
            EntityRenderers.register(ModEntityTypes.DEATHSPIKE.get(), DeathSpikeRenderer::new);
            EntityRenderers.register(ModEntityTypes.SPIKEPROJECTILE.get(), SpikeProjectileRenderer::new);

        }
    }
}
