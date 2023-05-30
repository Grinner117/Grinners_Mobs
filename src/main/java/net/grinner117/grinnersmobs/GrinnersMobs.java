package net.grinner117.grinnersmobs;

import net.grinner117.grinnersmobs.entity.ModEntityTypes;
import net.grinner117.grinnersmobs.entity.client.*;
import net.grinner117.grinnersmobs.item.ModCreativeModeTab;
import net.grinner117.grinnersmobs.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib.GeckoLib;

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

        modEventBus.addListener(this::addCreative);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntityTypes.PURETITANVILLAGER.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(ModEntityTypes.PURETITANLANKY.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);

            SpawnPlacements.register(ModEntityTypes.DEATHSPIKE.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);

            SpawnPlacements.register(ModEntityTypes.ENTLINGOAK.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(ModEntityTypes.ENTOAK.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);

            SpawnPlacements.register(ModEntityTypes.CHILDRAT.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(ModEntityTypes.DIRERAT.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(ModEntityTypes.BROODRAT.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);

            SpawnPlacements.register(ModEntityTypes.FIRENEWT.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
        });
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModeTab.GRINNERSTAB) {
            event.accept(ModItems.MONSTERBONE);
            event.accept(ModItems.MONSTERLEATHER);
            event.accept(ModItems.MONSTERFLESH);
            event.accept(ModItems.RATTAIL);
            event.accept(ModItems.RATTAILBUNDLE);

            event.accept(ModItems.MONSTERFURTUFT);
            event.accept(ModItems.MONSTERFABRIC);
            event.accept(ModItems.SPIKEPROJECTILE);
            event.accept(ModItems.ENTLINGCORE);
            event.accept(ModItems.ENTBARK);

            event.accept(ModItems.LIGHTMONSTERBONEARMOR_BOOTS);
            event.accept(ModItems.LIGHTMONSTERBONEARMOR_CHESTPLATE);
            event.accept(ModItems.LIGHTMONSTERBONEARMOR_HELMET);
            event.accept(ModItems.LIGHTMONSTERBONEARMOR_LEGGINGS);

            event.accept(ModItems.RATARMOR_LEGGINGS);

            event.accept(ModItems.DEATHSPIKEARMOR_HELMET);
            event.accept(ModItems.DEATHSPIKEARMOR_CHESTPLATE);
            event.accept(ModItems.DEATHSPIKEARMOR_LEGGINGS);
            event.accept(ModItems.DEATHSPIKEARMOR_BOOTS);

            event.accept(ModItems.ENTLINGARMOR_HELMET);
            event.accept(ModItems.ENTLINGARMOR_CHESTPLATE);
            event.accept(ModItems.ENTLINGARMOR_LEGGINGS);
            event.accept(ModItems.ENTLINGARMOR_BOOTS);

            event.accept(ModItems.ENTARMOR_HELMET);
            event.accept(ModItems.ENTARMOR_CHESTPLATE);
            event.accept(ModItems.ENTARMOR_LEGGINGS);
            event.accept(ModItems.ENTARMOR_BOOTS);

            event.accept(ModItems.DEATHSPIKE_SPAWN_EGG);
            event.accept(ModItems.PURETITANLANKY_SPAWN_EGG);
            event.accept(ModItems.PURETITANVILLAGER_SPAWN_EGG);
            event.accept(ModItems.ENTLINGOAK_SPAWN_EGG);
            event.accept(ModItems.ENTOAK_SPAWN_EGG);
            event.accept(ModItems.CHILDRAT_SPAWN_EGG);
            event.accept(ModItems.DIRERAT_SPAWN_EGG);
            event.accept(ModItems.BROODRAT_SPAWN_EGG);
            event.accept(ModItems.FIRENEWT_SPAWN_EGG);

        }
    }
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.PURETITANVILLAGER.get(), PureTitanVillagerRenderer::new);
            EntityRenderers.register(ModEntityTypes.PURETITANLANKY.get(), PureTitanLankyRenderer::new);

            EntityRenderers.register(ModEntityTypes.DEATHSPIKE.get(), DeathSpikeRenderer::new);

            EntityRenderers.register(ModEntityTypes.ENTLINGOAK.get(), EntlingOakRenderer::new);
            EntityRenderers.register(ModEntityTypes.ENTOAK.get(), EntOakRenderer::new);

            EntityRenderers.register(ModEntityTypes.CHILDRAT.get(), ChildRatRenderer::new);
            EntityRenderers.register(ModEntityTypes.BROODRAT.get(), BroodRatRenderer::new);
            EntityRenderers.register(ModEntityTypes.DIRERAT.get(), DireRatRenderer::new);

            EntityRenderers.register(ModEntityTypes.FIRENEWT.get(), FireNewtRenderer::new);


            EntityRenderers.register(ModEntityTypes.SPIKEPROJECTILE.get(), SpikeProjectileRenderer::new);
        }
    }
}