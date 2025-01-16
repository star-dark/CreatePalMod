package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class PlayerExpGoalProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format(Math.round(entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level * Math.pow(1.1, entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level) * 100));
	}
}
