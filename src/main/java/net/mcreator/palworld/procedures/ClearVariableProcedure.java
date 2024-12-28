package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

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
