package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class FarmerTalkProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.talk_with = entity instanceof FarmerJobNPCEntity _datEntS ? _datEntS.getEntityData().get(FarmerJobNPCEntity.DATA_job) : "";
			_vars.syncPlayerVariables(sourceentity);
		}
	}
}
