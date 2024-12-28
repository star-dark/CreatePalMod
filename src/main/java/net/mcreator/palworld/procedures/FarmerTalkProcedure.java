package net.mcreator.palworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.entity.FarmerJobNPCEntity;

public class FarmerTalkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.talk_with = entity instanceof FarmerJobNPCEntity _datEntS ? _datEntS.getEntityData().get(FarmerJobNPCEntity.DATA_job) : "";
			_vars.syncPlayerVariables(sourceentity);
		}
		JobNpcClickProcedure.execute(world, x, y, z, sourceentity);
	}
}
