package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class ClearVariableProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.job_production = "";
			_vars.syncPlayerVariables(entity);
		}
	}
}
