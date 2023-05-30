package net.grinner117.grinnersmobs.perks;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class Speed3_Perk extends ArmorItem {
    public Speed3_Perk(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);

    }
    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 3,false, false, true));
        }

    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> componets, TooltipFlag flag){
        if(Screen.hasShiftDown()){
            componets.add(Component.literal("Movement Speed 3").withStyle(ChatFormatting.DARK_AQUA));
        } else{
            componets.add(Component.literal("Shift Right click for more Info").withStyle(ChatFormatting.YELLOW));
        }
        super.appendHoverText(stack, level, componets,flag);
    }
}