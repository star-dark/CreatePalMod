package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class MinerTalkProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.talk_with = entity instanceof MinerJobNPCEntity _datEntS ? _datEntS.getEntityData().get(MinerJobNPCEntity.DATA_job) : "";
			_vars.syncPlayerVariables(sourceentity);
		}
	}
}
