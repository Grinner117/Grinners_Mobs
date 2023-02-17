package net.grinner117.grinnersmobs.perks;

import net.grinner117.grinnersmobs.base.IDamageHandlingArmor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FireReflect_Perk extends ArmorItem implements IDamageHandlingArmor{
    public FireReflect_Perk(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
<<<<<<< HEAD

    }

=======
    }
>>>>>>> 1.19.3
    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 250, 3));
        }
    }
    @SubscribeEvent
    public static void armorAttackHandler(LivingDamageEvent event){
        for (ItemStack armor : event.getEntity().getArmorSlots()){
            if (armor.getItem() instanceof IDamageHandlingArmor){
                float newDamage = ((IDamageHandlingArmor)armor.getItem()).onDamaged(event.getEntity(), armor.getEquipmentSlot(), event.getSource(), event.getAmount());
                event.setAmount(newDamage);
            }
        }
    }
    @Override
    public float onDamaged(LivingEntity entity, EquipmentSlot slot, DamageSource source, float amount) {
        Entity attacker = source.getEntity();
        if (attacker instanceof LivingEntity){
            attacker.hurt(DamageSource.ON_FIRE, amount / 2);
            attacker.setSecondsOnFire(4);
            return amount / 2;
        } else {
            return amount;
        }
    }
}