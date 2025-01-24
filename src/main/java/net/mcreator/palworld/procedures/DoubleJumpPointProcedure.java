package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class DoubleJumpPointProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format(entity.getData(PalworldModVariables.PLAYER_VARIABLES).DoubleJumpSkillPoint);
	}
}
