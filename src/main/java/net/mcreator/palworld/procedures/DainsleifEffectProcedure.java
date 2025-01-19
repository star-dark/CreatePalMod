package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class DainsleifEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 20, 2));
	}
}
