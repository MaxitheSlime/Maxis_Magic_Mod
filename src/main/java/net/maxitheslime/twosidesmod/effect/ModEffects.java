package net.maxitheslime.twosidesmod.effect;

import net.maxitheslime.twosidesmod.TwoSidesMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TwoSidesMod.MOD_ID);

    public static final RegistryObject<MobEffect> SUCTION_EFFECT = MOB_EFFECTS.register("gravitated",
            () -> new SuctionEffect(MobEffectCategory.NEUTRAL, 0x115c58).addAttributeModifier(Attributes.MOVEMENT_SPEED,
                    "7107DE5E-7CE8-4030-940E-514C1F160891", -0.25f, AttributeModifier.Operation.MULTIPLY_TOTAL));
    public static final RegistryObject<MobEffect> SOUL_HARROWING = MOB_EFFECTS.register("soul_harrowed",
            () -> new SoulHarrowEffect(MobEffectCategory.HARMFUL, 0x5800ff)
                    .addAttributeModifier(Attributes.ARMOR,"7107DE5E-7CE8-4030-940E-514C1F160892",
                            -0.5f, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.MAX_HEALTH, "7107DE5E-7CE8-4030-940E-514C1F160893",
                            -0.25f, AttributeModifier.Operation.MULTIPLY_TOTAL));
    public static final RegistryObject<MobEffect> SOUL_HARROWING_II = MOB_EFFECTS.register("soul_harrowed_ii",
            () -> new SoulHarrowEffect(MobEffectCategory.HARMFUL, 0x5800ff)
                    .addAttributeModifier(Attributes.ARMOR,"7107DE5E-7CE8-4030-940E-514C1F160894",
                            -0.75f, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.MAX_HEALTH, "7107DE5E-7CE8-4030-940E-514C1F160895",
                            -0.5f, AttributeModifier.Operation.MULTIPLY_TOTAL));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}