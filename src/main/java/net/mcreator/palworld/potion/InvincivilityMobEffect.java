
package net.mcreator.palworld.potion;

import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.palworld.procedures.InvincivilityhyogwagasijagjeogyongdoeeosseulddaeProcedure;
import net.mcreator.palworld.procedures.InvincivilityOnEffectActiveTickProcedure;

import java.util.Set;

public class InvincivilityMobEffect extends MobEffect {
	public InvincivilityMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10066330);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		InvincivilityhyogwagasijagjeogyongdoeeosseulddaeProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		InvincivilityOnEffectActiveTickProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
