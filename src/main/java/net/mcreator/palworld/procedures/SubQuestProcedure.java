package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class SubQuestProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestContents + " " + new java.text.DecimalFormat("##").format(entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestProgress) + "/"
				+ new java.text.DecimalFormat("##").format(entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestGoal);
	}
}
