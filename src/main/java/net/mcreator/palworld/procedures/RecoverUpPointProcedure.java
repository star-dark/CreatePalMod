package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class RecoverUpPointProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format(entity.getData(PalworldModVariables.PLAYER_VARIABLES).RecoverSkillPoint);
	}
}
