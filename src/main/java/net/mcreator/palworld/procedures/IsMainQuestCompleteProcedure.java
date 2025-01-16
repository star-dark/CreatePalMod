package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class IsMainQuestCompleteProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(PalworldModVariables.PLAYER_VARIABLES).IsMainQuestExist && entity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestGoal == entity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestProgress;
	}
}
