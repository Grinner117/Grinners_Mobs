package net.grinner117.grinnersmobs.base;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public record ModArmorMaterial(String name, int durablity, int[] protection, int enchantability, SoundEvent equipsound,
                               float toughness, float knocbackResistance,
                               Supplier<Ingredient> repairMaterial) implements ArmorMaterial {

    private static final int[] DURABLILITY_PER_SLOT = new int[] {13,15,16,11};
    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return DURABLILITY_PER_SLOT[slot.getIndex()]= this.durablity;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.protection[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipsound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial().get();
    }

    @Override
    public String getName() {
        return GrinnersMobs.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knocbackResistance;
    }
}
