package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class BangobuEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 35, 1));
			entity.setDeltaMovement(new Vec3((1.5 * entity.getLookAngle().x), (0 + entity.getLookAngle().y), (1.5 * entity.getLookAngle().z)));
		}
	}
}
