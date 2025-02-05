package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class SkyshatterEffect2Procedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!entity.onGround() && entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.CONFUSION)) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), (float) (sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level * 2));
		}
	}
}
