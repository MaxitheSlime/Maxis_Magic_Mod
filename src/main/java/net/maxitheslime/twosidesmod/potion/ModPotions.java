package net.maxitheslime.twosidesmod.potion;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.maxitheslime.twosidesmod.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, TwoSidesMod.MOD_ID);

    public static final RegistryObject<Potion> SLIMEY_POTION = POTIONS.register("suction_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SUCTION_EFFECT.get(), 2400, 0)));
    public static final RegistryObject<Potion> SOUL_HARROW_POTION = POTIONS.register("soul_harrow",
            () -> new Potion(new MobEffectInstance(ModEffects.SOUL_HARROWING.get(), 600, 0)));
    public static final RegistryObject<Potion> SOUL_HARROW_II_POTION = POTIONS.register("soul_harrow_ii",
            () -> new Potion(new MobEffectInstance(ModEffects.SOUL_HARROWING_II.get(), 600, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
