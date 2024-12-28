package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class SubQuestProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestContents + " " + new java.text.DecimalFormat("##").format(entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestProgress) + "/"
				+ new java.text.DecimalFormat("##").format(entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestGoal);
	}
}
