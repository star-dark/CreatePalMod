package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class MainQuestProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestContents + " " + new java.text.DecimalFormat("##").format(entity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestProgress) + "/"
				+ new java.text.DecimalFormat("##").format(entity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestGoal);
	}
}
