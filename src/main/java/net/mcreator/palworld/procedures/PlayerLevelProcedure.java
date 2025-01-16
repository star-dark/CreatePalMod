package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class PlayerLevelProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##LV").format(entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level);
	}
}
