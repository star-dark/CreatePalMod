package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class IsSubQuestCompleteProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(PalworldModVariables.PLAYER_VARIABLES).IsSubQuestExist && entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestGoal == entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestProgress;
	}
}
