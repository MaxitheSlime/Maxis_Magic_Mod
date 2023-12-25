package net.maxitheslime.twosidesmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.maxitheslime.twosidesmod.item.ModArmorMaterials;
import net.maxitheslime.twosidesmod.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> ROSE_QUARTZ_ARMOR_EFFECT =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmorMaterials.ROSE_QUARTZ, new MobEffectInstance(ModEffects.SUCTION_EFFECT.get(), 200, 0))
                    .build();

    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(!level.isClientSide && hasFullSuitofArmorOn(player)){
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<ArmorMaterial, MobEffectInstance> entry : ROSE_QUARTZ_ARMOR_EFFECT.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapEffect = entry.getValue();

            if (hasPlayerCorrectArmorOn(mapArmorMaterial, player)){
                addEffectToPlayer(mapEffect, player);
            }
        }
    }

    private void addEffectToPlayer(MobEffectInstance mapEffect, Player player) {
        boolean hasPlayerEffect = player.hasEffect(mapEffect.getEffect());

        if(!hasPlayerEffect){
            player.addEffect(new MobEffectInstance(mapEffect.getEffect(),
                    mapEffect.getDuration(), mapEffect.getAmplifier()));
        }
    }

    private boolean hasPlayerCorrectArmorOn(ArmorMaterial mapArmorMaterial, Player player) {
        for(ItemStack armorStack : player.getArmorSlots()){
            if(!(armorStack.getItem() instanceof ArmorItem)){
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == mapArmorMaterial && leggings.getMaterial() == mapArmorMaterial
                && chestplate.getMaterial() == mapArmorMaterial && helmet.getMaterial() == mapArmorMaterial;
    }

    private static boolean hasFullSuitofArmorOn(Player player){
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }
}
