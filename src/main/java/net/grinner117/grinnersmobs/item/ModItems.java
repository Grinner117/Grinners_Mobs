package net.grinner117.grinnersmobs.item;


import net.grinner117.grinnersmobs.GrinnersMobs;
import net.grinner117.grinnersmobs.base.ModArmorMaterial;
import net.grinner117.grinnersmobs.entity.ModEntityTypes;
import net.grinner117.grinnersmobs.perks.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GrinnersMobs.MODID);
    public static final RegistryObject<Item> PURETITANLANKY_SPAWN_EGG = ITEMS.register("puretitanlanky_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PURETITANLANKY, 0x22b541, 0x19732e,
                    new Item.Properties()));

    public static final RegistryObject<Item> PURETITANVILLAGER_SPAWN_EGG = ITEMS.register("puretitanvillager_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PURETITANVILLAGER, 0x22b841, 0x19782e,
                    new Item.Properties()));

    public static final RegistryObject<Item> ENTLINGOAK_SPAWN_EGG = ITEMS.register("entlingoak_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ENTLINGOAK, 0x22b841, 0xF4732e,
                    new Item.Properties()));
    public static final RegistryObject<Item> ENTOAK_SPAWN_EGG = ITEMS.register("entoak_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ENTOAK, 0x22b841, 0xF7F2e,
                    new Item.Properties()));
    public static final RegistryObject<Item> DEATHSPIKE_SPAWN_EGG = ITEMS.register("deathspike_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DEATHSPIKE, 0x54b541, 0xF4732e,
                    new Item.Properties()));
    public static final RegistryObject<Item> CHILDRAT_SPAWN_EGG = ITEMS.register("childrat_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CHILDRAT, 0x54bfff, 0xF4732e,
                    new Item.Properties()));
    public static final RegistryObject<Item> DIRERAT_SPAWN_EGG = ITEMS.register("direrat_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DIRERAT, 0x54bfff, 0xF473f2e,
                    new Item.Properties()));
    public static final RegistryObject<Item> BROODRAT_SPAWN_EGG = ITEMS.register("broodrat_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BROODRAT, 0x54bfff, 0xF473f2e,
                    new Item.Properties()));


    public static final RegistryObject<Item> MONSTERFLESH = ITEMS.register("monsterflesh",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(2)
                            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 100, 0), 0.5F)
                            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 100, 0), 0.5F)
                            .effect(() -> new MobEffectInstance(MobEffects.HARM, 30, 0), 0.5F)
                            .build())));

    public static final RegistryObject<Item> RATTAIL = ITEMS.register("rattail",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(1)
                            .effect(() -> new MobEffectInstance(MobEffects.HARM, 10, 0), 0.7F)
                            .build())));
    public static final RegistryObject<Item> MONSTERBONE = ITEMS.register("monsterbone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RATTAILBUNDLE = ITEMS.register("rattailbundle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MONSTERLEATHER = ITEMS.register("monsterleather",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MONSTERFURTUFT = ITEMS.register("monsterfurtuft",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MONSTERFABRIC = ITEMS.register("monsterfabric",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENTLINGCORE = ITEMS.register("entlingcore",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENTBARK = ITEMS.register("entbark",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPIKEPROJECTILE = ITEMS.register("spikeprojectile",
            () -> new SpikeProjectileItem(new Item.Properties()));

    public static final RegistryObject<ArmorItem> LIGHTMONSTERBONEARMOR_HELMET = ITEMS.register("lightmonsterbonearmor_helmet",
            () -> new Nightvison_Perk(ArmorTiers.LIGHTMONSTERBONEARMOR, EquipmentSlot.HEAD, props()));
    public static final RegistryObject<ArmorItem> LIGHTMONSTERBONEARMOR_CHESTPLATE = ITEMS.register("lightmonsterbonearmor_chestplate",
            () -> new DamageRes2_Perk(ArmorTiers.LIGHTMONSTERBONEARMOR, EquipmentSlot.CHEST, props()));
    public static final RegistryObject<ArmorItem> LIGHTMONSTERBONEARMOR_LEGGINGS = ITEMS.register("lightmonsterbonearmor_leggings",
            () -> new Jump3_Perk(ArmorTiers.LIGHTMONSTERBONEARMOR, EquipmentSlot.LEGS, props()));
    public static final RegistryObject<ArmorItem> LIGHTMONSTERBONEARMOR_BOOTS = ITEMS.register("lightmonsterbonearmor_boots",
            () -> new Speed3_Perk(ArmorTiers.LIGHTMONSTERBONEARMOR, EquipmentSlot.FEET, props()));

    public static final RegistryObject<ArmorItem> DEATHSPIKEARMOR_HELMET = ITEMS.register("deathspikearmor_helmet",
            () -> new Damage3_Perk(ArmorTiers.DEATHSPIKEARMOR, EquipmentSlot.HEAD, props()));
    public static final RegistryObject<ArmorItem> DEATHSPIKEARMOR_CHESTPLATE = ITEMS.register("deathspikearmor_chestplate",
            () -> new FireReflect_Perk(ArmorTiers.DEATHSPIKEARMOR, EquipmentSlot.CHEST, props()));
    public static final RegistryObject<ArmorItem> DEATHSPIKEARMOR_LEGGINGS = ITEMS.register("deathspikearmor_leggings",
            () -> new DamageRes2_Perk(ArmorTiers.DEATHSPIKEARMOR, EquipmentSlot.LEGS, props()));
    public static final RegistryObject<ArmorItem> DEATHSPIKEARMOR_BOOTS = ITEMS.register("deathspikearmor_boots",
            () -> new Speed3_Perk(ArmorTiers.DEATHSPIKEARMOR, EquipmentSlot.FEET, props()));

    public static final RegistryObject<ArmorItem> ENTLINGARMOR_HELMET = ITEMS.register("entlingarmor_helmet",
            () -> new DigSpeed2_Perk(ArmorTiers.ENTLINGARMOR, EquipmentSlot.HEAD, props()));
    public static final RegistryObject<ArmorItem> ENTLINGARMOR_CHESTPLATE = ITEMS.register("entlingarmor_chestplate",
            () -> new EntlingCurseB_Perk(ArmorTiers.ENTLINGARMOR, EquipmentSlot.CHEST, props()));
    public static final RegistryObject<ArmorItem> ENTLINGARMOR_LEGGINGS = ITEMS.register("entlingarmor_leggings",
            () -> new EntlingCurseA_Perk(ArmorTiers.ENTLINGARMOR, EquipmentSlot.LEGS, props()));
    public static final RegistryObject<ArmorItem> ENTLINGARMOR_BOOTS = ITEMS.register("entlingarmor_boots",
            () -> new DamageRes2_Perk(ArmorTiers.ENTLINGARMOR, EquipmentSlot.FEET, props()));

    public static final RegistryObject<ArmorItem> ENTARMOR_HELMET = ITEMS.register("entarmor_helmet",
            () -> new DigSpeed2_Perk(ArmorTiers.ENTARMOR, EquipmentSlot.HEAD, props()));
    public static final RegistryObject<ArmorItem> ENTARMOR_CHESTPLATE = ITEMS.register("entarmor_chestplate",
            () -> new Regeneration2_Perk(ArmorTiers.ENTARMOR, EquipmentSlot.CHEST, props()));
    public static final RegistryObject<ArmorItem> ENTARMOR_LEGGINGS = ITEMS.register("entarmor_leggings",
            () -> new Saturation_Perk(ArmorTiers.ENTARMOR, EquipmentSlot.LEGS, props()));
    public static final RegistryObject<ArmorItem> ENTARMOR_BOOTS = ITEMS.register("entarmor_boots",
            () -> new DamageRes4_Perk(ArmorTiers.ENTARMOR, EquipmentSlot.FEET, props()));

    public static final RegistryObject<ArmorItem> RATARMOR_LEGGINGS = ITEMS.register("ratarmor_leggings",
            () -> new Rat_Perk(ArmorTiers.RATARMOR, EquipmentSlot.LEGS, props()));


private static Item.Properties props(){return new Item.Properties(); }
       public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);    }

public static class ArmorTiers{
public static final ArmorMaterial LIGHTMONSTERBONEARMOR = new ModArmorMaterial(
        "lightmonsterbonearmor",
        2200,
        new int[]{7,15,12,7},
        200,
        SoundEvents.ARMOR_EQUIP_NETHERITE,
        12.0f, 0.8f,
        () -> Ingredient.of(ModItems.MONSTERLEATHER.get()));
    public static final ArmorMaterial DEATHSPIKEARMOR = new ModArmorMaterial(
            "deathspikearmor",
            2200,
            new int[]{9,13,12,9},
            300,
            SoundEvents.ARMOR_EQUIP_CHAIN,
            8.0f, 0.3f,
            () -> Ingredient.of(ModItems.SPIKEPROJECTILE.get()));
    public static final ArmorMaterial ENTLINGARMOR = new ModArmorMaterial(
            "entlingarmor",
            2400,
            new int[]{7,13,12,7},
            260,
            SoundEvents.ARMOR_EQUIP_TURTLE,
            16.0f, 6.0f,
            () -> Ingredient.of(ModItems.ENTBARK.get()));
    public static final ArmorMaterial ENTARMOR = new ModArmorMaterial(
            "entarmor",
            3000,
            new int[]{8,14,13,8},
            300,
            SoundEvents.ARMOR_EQUIP_TURTLE,
            20.0f, 8.0f,
            () -> Ingredient.of(ModItems.ENTBARK.get()));

    public static final ArmorMaterial RATARMOR = new ModArmorMaterial(
            "ratarmor",
            864,
            new int[]{6,6,6,6},
            300,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            4.0f, 0.0f,
            () -> Ingredient.of(ModItems.RATTAIL.get()));

}
}