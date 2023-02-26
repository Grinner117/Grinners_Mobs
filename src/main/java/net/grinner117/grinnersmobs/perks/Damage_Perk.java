package net.grinner117.grinnersmobs.perks;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Damage_Perk extends ArmorItem {
    public Damage_Perk(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);

    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 3));
        }

    }
}