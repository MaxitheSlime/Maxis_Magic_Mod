package net.maxitheslime.twosidesmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

// Climbing Effect by SameDifferent: https://github.com/samedifferent/TrickOrTreat/blob/master/LICENSE
// Distributed under MIT
public class SoulHarrowEffect extends MobEffect {
    public SoulHarrowEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(!pLivingEntity.isCurrentlyGlowing()) {
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING,600));
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean m_6584_(int pDuration, int pAmplifier) {
        return true;
    }
}
