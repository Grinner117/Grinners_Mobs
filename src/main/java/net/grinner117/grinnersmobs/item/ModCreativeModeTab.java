package net.grinner117.grinnersmobs.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab GRINNERSTAB = new CreativeModeTab("grinnerstab") {
        @Override
        public ItemStack makeIcon () {
            return new ItemStack(ModItems.MONSTERBONE.get());
        }
    };
}
