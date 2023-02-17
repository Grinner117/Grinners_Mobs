package net.grinner117.grinnersmobs.item;


import net.grinner117.grinnersmobs.GrinnersMobs;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GrinnersMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab GRINNERSTAB;
    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {

    GRINNERSTAB = event.registerCreativeModeTab(new ResourceLocation(GrinnersMobs.MODID, "grinnerstab"),
            builder -> builder.icon(() -> new ItemStack(ModItems.MONSTERBONE.get()))
                    .title(Component.translatable("Grinner's Mobs"))
                .build());
    }
}
