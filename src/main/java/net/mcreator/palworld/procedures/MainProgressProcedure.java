package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class MainProgressProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format(entity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestProgress) + " / " + new java.text.DecimalFormat("##").format(entity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestGoal);
	}
}
