package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class QuestTapCloseButtonAppearProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return IsNotMainQuestCompleteProcedure.execute(entity) && entity.getData(PalworldModVariables.PLAYER_VARIABLES).IsMainQuestExist;
	}
}
