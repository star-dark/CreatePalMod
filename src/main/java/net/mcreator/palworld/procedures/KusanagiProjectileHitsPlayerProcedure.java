package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class KusanagiProjectileHitsPlayerProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.KusanagiLocateX = entity.getX();
			_vars.syncPlayerVariables(sourceentity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.KusanagiLocateY = entity.getY();
			_vars.syncPlayerVariables(sourceentity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.KusanagiLocateZ = entity.getZ();
			_vars.syncPlayerVariables(sourceentity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.KamuiActivate = true;
			_vars.syncPlayerVariables(sourceentity);
		}
	}
}
