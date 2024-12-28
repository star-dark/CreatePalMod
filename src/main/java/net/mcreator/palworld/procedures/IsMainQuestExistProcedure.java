package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class IsMainQuestExistProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(PalworldModVariables.PLAYER_VARIABLES).IsMainQuestExist;
	}
}
