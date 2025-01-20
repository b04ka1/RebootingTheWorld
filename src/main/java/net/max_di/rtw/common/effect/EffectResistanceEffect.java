package net.max_di.rtw.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class EffectResistanceEffect extends MobEffect {
    protected EffectResistanceEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        for (MobEffectInstance effectInstance : pLivingEntity.getActiveEffects()) {
            if (effectInstance.getEffect().value() != this) {
                pLivingEntity.removeEffect(effectInstance.getEffect());
            }
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }
}
