package net.grinner117.grinnersmobs.perks;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Rat_Perk extends ArmorItem {
    public Rat_Perk(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);

    }
    public static ArrayList<MobEffect> effectTable = new ArrayList<>(Arrays.asList(
            MobEffects.HUNGER
    ));
    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 9));
            if (world.getGameTime() % (10000) == 0) {
                player.addEffect(new MobEffectInstance(effectTable.get(new Random().nextInt(effectTable.size())), 800, new Random().nextInt(20)));
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> componets, TooltipFlag flag){
        if(Screen.hasShiftDown()){
            componets.add(Component.literal("Damage 10, Random Hunger").withStyle(ChatFormatting.RED));
        } else{
            componets.add(Component.literal("Rat's Curse").withStyle(ChatFormatting.DARK_RED));
        }
        super.appendHoverText(stack, level, componets,flag);
    }
}