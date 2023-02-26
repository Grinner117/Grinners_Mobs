package net.grinner117.grinnersmobs.item.armor;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class EntlingArmor_Chestplate extends Item {
    public EntlingArmor_Chestplate(Properties properties) {
        super(properties);}
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> componets, TooltipFlag flag){
        if(Screen.hasShiftDown()){
            componets.add(Component.literal("Right click for more Info").withStyle(ChatFormatting.DARK_AQUA));
        } else{
            componets.add(Component.literal("Regen 2, Slow Movement 1").withStyle(ChatFormatting.YELLOW));
        }
        super.appendHoverText(stack, level, componets,flag);
    }
}
