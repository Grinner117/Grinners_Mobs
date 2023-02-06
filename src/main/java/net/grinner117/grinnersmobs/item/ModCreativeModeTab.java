package net.grinner117.grinnersmobs.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab GRINNERSTAB = new CreativeModeTab("grinnerstab") {
        public ItemStack makeIcon () {
            return new ItemStack(ModItems.MONSTERBONE.get());
        }
    };
   protected CreativeModeTab(CreativeModeTab.Builder builder) {
            this(builder.row, builder.column, builder.type, builder.displayName, builder.iconGenerator, builder.displayItemsGenerator, builder.backgroundLocation, builder.hasSearchBar, builder.searchBarWidth, builder.tabsImage, builder.labelColor, builder.slotColor);
        }