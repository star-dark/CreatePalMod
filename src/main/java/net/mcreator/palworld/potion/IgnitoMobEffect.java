
package net.mcreator.palworld.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.InstantenousMobEffect;

import net.mcreator.palworld.procedures.IgnitohyogwagasijagjeogyongdoeeosseulddaeProcedure;

public class IgnitoMobEffect extends InstantenousMobEffect {
	public IgnitoMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -39373);
	}

	@Override
	public void applyInstantenousEffect(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		IgnitohyogwagasijagjeogyongdoeeosseulddaeProcedure.execute(entity);
	}
}
