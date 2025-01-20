package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class BalmungEffectProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player)) {
			if (entity.getPersistentData().getDouble("Stack") <= 3) {
				entity.getPersistentData().putDouble("Stack", (entity.getPersistentData().getDouble("Stack") + 1));
			} else if (entity.getPersistentData().getDouble("Stack") >= 4) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), 100);
			} else {
				entity.getPersistentData().putDouble("Stack", 1);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 1));
		}
	}
}
