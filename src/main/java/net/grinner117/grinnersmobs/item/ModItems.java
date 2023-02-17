package net.grinner117.grinnersmobs.item;

import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.base.ModArmorMaterial;
import net.grinner117.grinnersmobs.entity.ModEntityTypes;
<<<<<<< HEAD
import net.grinner117.grinnersmobs.entity.custom.SpikeProjectileEntity;
import net.grinner117.grinnersmobs.perks.DamageRes2_Perk;
import net.grinner117.grinnersmobs.perks.Jump2_Perk;
import net.grinner117.grinnersmobs.perks.Nightvison_Perk;
import net.grinner117.grinnersmobs.perks.Speed4_Perk;
=======
import net.grinner117.grinnersmobs.perks.*;
>>>>>>> 1.19.3
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
<<<<<<< HEAD
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
=======
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
>>>>>>> 1.19.3
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GrinnersMobs.MODID);
    public static final RegistryObject<Item> PURETITANVILLAGER_SPAWN_EGG = ITEMS.register("puretitanvillager_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PURETITANVILLAGER, 0x27b341, 0x19732e,
<<<<<<< HEAD
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> PURETITANLANKY_SPAWN_EGG = ITEMS.register("puretitanlanky_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PURETITANLANKY, 0x22b541, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> DEATHSPIKE_SPAWN_EGG = ITEMS.register("deathspike_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DEATHSPIKE, 0x52b541, 0xFF732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> MONSTERFLESH = ITEMS.register("monsterflesh",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.GRINNERSTAB)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(2)
                            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 100, 0), 0.5F)
                            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 100, 0), 0.5F)
                            .effect(() -> new MobEffectInstance(MobEffects.HARM, 30, 0), 0.5F)
                            .build())));
    public static final RegistryObject<Item> MONSTERBONE = ITEMS.register("monsterbone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.GRINNERSTAB)));
    public static final RegistryObject<Item> MONSTERLEATHER = ITEMS.register("monsterleather",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.GRINNERSTAB)));

    // in ItemInit.java
    public static final RegistryObject<Item> SPIKEPROJECTILE = ITEMS.register("spikeprojectile",
            () -> new SpikeProjectileItem(new Item.Properties().tab(ModCreativeModeTab.GRINNERSTAB)));
    public static final RegistryObject<ArmorItem> LIGHTMONSTERBONEARMOR_HELMET = ITEMS.register("lightmonsterbonearmor_helmet",
            () -> new Nightvison_Perk(ArmorTiers.LIGHTMONSTERBONEARMOR, EquipmentSlot.HEAD, props()));
    public static final RegistryObject<ArmorItem> LIGHTMONSTERBONEARMOR_CHESTPLATE = ITEMS.register("lightmonsterbonearmor_chestplate",
            () -> new DamageRes2_Perk(ArmorTiers.LIGHTMONSTERBONEARMOR, EquipmentSlot.CHEST, props()));
    public static final RegistryObject<ArmorItem> LIGHTMONSTERBONEARMOR_LEGGINGS = ITEMS.register("lightmonsterbonearmor_leggings",
            () -> new Jump2_Perk(ArmorTiers.LIGHTMONSTERBONEARMOR, EquipmentSlot.LEGS, props()));
    public static final RegistryObject<ArmorItem> LIGHTMONSTERBONEARMOR_BOOTS = ITEMS.register("lightmonsterbonearmor_boots",
            () -> new Speed4_Perk(ArmorTiers.LIGHTMONSTERBONEARMOR, EquipmentSlot.FEET, props()));

private static Item.Properties props(){return new Item.Properties().tab(ModCreativeModeTab.GRINNERSTAB); }

=======
                    new Item.Properties()));
    public static final RegistryObject<Item> PURETITANLANKY_SPAWN_EGG = ITEMS.register("puretitanlanky_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PURETITANLANKY, 0x22b541, 0x19732e,
                    new Item.Properties()));
    public static final RegistryObject<Item> DEATHSPIKE_SPAWN_EGG = ITEMS.register("deathspike_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DEATHSPIKE, 0x52b541, 0xFF732e,
                    new Item.Properties()));

    public static final RegistryObject<Item> MONSTERFLESH = ITEMS.register("monsterflesh",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(2)
                            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 100, 0), 0.5F)
                            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 100, 0), 0.5F)
                            .effect(() -> new MobEffectInstance(MobEffects.HARM, 30, 0), 0.5F)
                            .build())));
    public static final RegistryObject<Item> MONSTERBONE = ITEMS.register("monsterbone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MONSTERLEATHER = ITEMS.register("monsterleather",
            () -> new Item(new Item.Properties()));

    // in ItemInit.java
    public static final RegistryObject<Item> SPIKEPROJECTILE = ITEMS.register("spikeprojectile",
            () -> new SpikeProjectileItem(new Item.Properties()));
    public static final RegistryObject<ArmorItem> LIGHTMONSTERBONEARMOR_HELMET = ITEMS.register("lightmonsterbonearmor_helmet",
            () -> new Nightvison_Perk(ArmorTiers.LIGHTMONSTERBONEARMOR, EquipmentSlot.HEAD, props()));
    public static final RegistryObject<ArmorItem> LIGHTMONSTERBONEARMOR_CHESTPLATE = ITEMS.register("lightmonsterbonearmor_chestplate",
            () -> new DamageRes2_Perk(ArmorTiers.LIGHTMONSTERBONEARMOR, EquipmentSlot.CHEST, props()));
    public static final RegistryObject<ArmorItem> LIGHTMONSTERBONEARMOR_LEGGINGS = ITEMS.register("lightmonsterbonearmor_leggings",
            () -> new Jump2_Perk(ArmorTiers.LIGHTMONSTERBONEARMOR, EquipmentSlot.LEGS, props()));
    public static final RegistryObject<ArmorItem> LIGHTMONSTERBONEARMOR_BOOTS = ITEMS.register("lightmonsterbonearmor_boots",
            () -> new Speed3_Perk(ArmorTiers.LIGHTMONSTERBONEARMOR, EquipmentSlot.FEET, props()));
    public static final RegistryObject<ArmorItem> DEATHSPIKEARMOR_HELMET = ITEMS.register("deathspikearmor_helmet",
            () -> new Health3_Perk(ArmorTiers.DEATHSPIKEARMOR, EquipmentSlot.HEAD, props()));
    public static final RegistryObject<ArmorItem> DEATHSPIKEARMOR_CHESTPLATE = ITEMS.register("deathspikearmor_chestplate",
            () -> new Damage_Perk(ArmorTiers.DEATHSPIKEARMOR, EquipmentSlot.CHEST, props()));
    public static final RegistryObject<ArmorItem> DEATHSPIKEARMOR_LEGGINGS = ITEMS.register("deathspikearmor_leggings",
            () -> new DamageRes2_Perk(ArmorTiers.DEATHSPIKEARMOR, EquipmentSlot.LEGS, props()));
    public static final RegistryObject<ArmorItem> DEATHSPIKEARMOR_BOOTS = ITEMS.register("deathspikearmor_boots",
            () -> new Speed4_Perk(ArmorTiers.DEATHSPIKEARMOR, EquipmentSlot.FEET, props()));



private static Item.Properties props(){return new Item.Properties(); }

>>>>>>> 1.19.3
       public static void register(IEventBus eventBus) {

    ITEMS.register(eventBus);
    }

public static class ArmorTiers{
public static final ArmorMaterial LIGHTMONSTERBONEARMOR = new ModArmorMaterial(
        "lightmonsterbonearmor",
<<<<<<< HEAD
        1000,
        new int[]{7,15,12,7},
        300,
=======
        1800,
        new int[]{7,15,12,7},
        200,
>>>>>>> 1.19.3
        SoundEvents.ARMOR_EQUIP_NETHERITE,
        8.0f, 0.5f,
        () -> Ingredient.of(ModItems.MONSTERLEATHER.get()));

<<<<<<< HEAD
}

}
=======
    public static final ArmorMaterial DEATHSPIKEARMOR = new ModArmorMaterial(
            "deathspikearmor",
            2000,
            new int[]{10,16,14,10},
            300,
            SoundEvents.ARMOR_EQUIP_CHAIN,
            12.0f, 0.3f,
            () -> Ingredient.of(ModItems.SPIKEPROJECTILE.get()));

}

}

>>>>>>> 1.19.3
