package net.grinner117.grinnersmobs.init;

import net.grinner117.grinnersmobs.ModArmorMaterial.LightMonsterBoneArmorMaterial;
import net.grinner117.grinnersmobs.item.ModCreativeModeTab;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraftforge.registries.ForgeRegistries.Keys.ITEMS;

public class ItemInit {

    public static final ArmorMaterial LIGHTMONSTERBONEARMORMATERIAL = new LightMonsterBoneArmorMaterial();

    public static final RegistryObject<Item> LIGHTMONSTERBONEARMOR_HELMET = ITEMS.registry("pink_helmet",
            () -> new ArmorItem(LightMonsterBoneArmorMaterial.LightMonsterBoneArmor, EquipmentSlot.HEAD, (new Item.Properties().tab(ModCreativeModeTab.GRINNERSTAB)));

    public static final RegistryObject<Item> LIGHTMONSTERBONEARMOR_CHESTPLATE = ITEMS.registry("pink_chestplate",
            () -> new ArmorItem(LightMonsterBoneArmorMaterial.LightMonsterBoneArmor, EquipmentSlot.CHEST, (new Item.Properties().tab(ModCreativeModeTab.GRINNERSTAB)));

    public static final RegistryObject<Item> LIGHTMONSTERBONEARMOR_LEGGINGS = ITEMS.registry("pink_leggings",
            () -> new ArmorItem(LightMonsterBoneArmorMaterial.LightMonsterBoneArmor, EquipmentSlot.LEGS, (new Item.Properties().tab(ModCreativeModeTab.GRINNERSTAB)));

    public static final RegistryObject<Item> LIGHTMONSTERBONEARMOR_BOOTS = ITEMS.registry("pink_boots",
            () -> new ArmorItem(LightMonsterBoneArmorMaterial.LightMonsterBoneArmor, EquipmentSlot.FEET, (new Item.Properties().tab(ModCreativeModeTab.GRINNERSTAB)));

 //   public static final Item LIGHTMONSTERBONEARMORMATERIAL_HELEMENT = new LightMonsterBoneArmor(LightMonsterBoneArmorMaterial,
       //     EquipmentSlot.HEAD, (new Item.Properties().tab(ModCreativeModeTab.GRINNERSTAB)));
//    public static final Item LIGHTMONSTERBONEARMORMATERIAL_CHESTPLATE = new LightMonsterBoneArmor(LightMonsterBoneArmorMaterial,
 //           EquipmentSlot.CHEST, (new Item.Properties().tab(ModCreativeModeTab.GRINNERSTAB)));
  //  public static final Item LIGHTMONSTERBONEARMORMATERIAL_LEGGINGS = new LightMonsterBoneArmor(LightMonsterBoneArmorMaterial,
  //          EquipmentSlot.LEGS, (new Item.Properties().tab(ModCreativeModeTab.GRINNERSTAB)));
 //   public static final Item LIGHTMONSTERBONEARMORMATERIAL_BOOTS = new LightMonsterBoneArmor(LightMonsterBoneArmorMaterial,
           // EquipmentSlot.FEET, (new Item.Properties().tab(ModCreativeModeTab.GRINNERSTAB)));

}
