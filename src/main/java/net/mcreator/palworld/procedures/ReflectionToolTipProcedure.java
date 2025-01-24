package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class ReflectionToolTipProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String tooltip = "";
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).ReflectionSkillPointUp == 0) {
			tooltip = "\uADFC\uAC70\uB9AC \uACF5\uACA9 \uBC29\uC5B4\uC2DC \uB370\uBBF8\uC9C0 \uBC0F \uB109\uBC31";
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).HornPlayerSkillPoint <= 5) {
			tooltip = "\uB109\uBC31\uAC70\uB9AC \uBC0F \uB370\uBBF8\uC9C0 \uC99D\uAC00";
		}
		return tooltip;
	}
}
