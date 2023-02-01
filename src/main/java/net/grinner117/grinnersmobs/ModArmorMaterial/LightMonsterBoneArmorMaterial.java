package net.grinner117.grinnersmobs.ModArmorMaterial;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
public class LightMonsterBoneArmorMaterial implements ArmorMaterial {
    @Override
    public int getDurabilityForSlot(EquipmentSlot p_40410_) {
        return 200;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot p_40411_) {
        return 2;
    }

    @Override
    public int getEnchantmentValue() {
        return 70;
    }

    @Override
    public SoundEvent getEquipSound() {
        return null;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public float getToughness() {
        return 8;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.5F;
    }
}