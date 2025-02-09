package net.mcreator.palworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModEntities;

public class KusanagiProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.KusanagiLocateX = immediatesourceentity.getX();
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.KusanagiLocateY = immediatesourceentity.getY();
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.KusanagiLocateZ = immediatesourceentity.getZ();
			_vars.syncPlayerVariables(entity);
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = PalworldModEntities.KUSANAGI.get().spawn(_level, BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setXRot((float) Math.toRadians(180));
			}
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.KamuiActivate = true;
			_vars.syncPlayerVariables(entity);
		}
	}
}
