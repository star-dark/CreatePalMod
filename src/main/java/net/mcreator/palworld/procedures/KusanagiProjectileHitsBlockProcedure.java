package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class KusanagiProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = PalworldModEntities.KUSANAGI.get().spawn(_level, BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setXRot((float) Math.toRadians(180));
			}
		}
	}
}
