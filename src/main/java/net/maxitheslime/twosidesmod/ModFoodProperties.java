package net.maxitheslime.twosidesmod;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties BONSAI_LEMON = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.25f).effect(() -> new MobEffectInstance
                    (MobEffects.ABSORPTION, 200), 0.20f).build();
}
