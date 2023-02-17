package net.grinner117.grinnersmobs.perks;

<<<<<<< HEAD
=======
import net.minecraft.world.effect.MobEffect;
>>>>>>> 1.19.3
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

>>>>>>> 1.19.3
public class Nightvison_Perk extends ArmorItem {
    public Nightvison_Perk(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);

    }

<<<<<<< HEAD
    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 3));
=======
    public static ArrayList<MobEffect> effectTable = new ArrayList<>(Arrays.asList(
            MobEffects.NIGHT_VISION
    ));

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            if (world.getGameTime() % (20 * 2) == 0) {
                player.addEffect(new MobEffectInstance(effectTable.get(new Random().nextInt(effectTable.size())), 40 * 20, new Random().nextInt(10)));

            }
>>>>>>> 1.19.3
        }
    }
}