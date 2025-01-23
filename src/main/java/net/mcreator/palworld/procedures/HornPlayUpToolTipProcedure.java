package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class HornPlayUpToolTipProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String tooltip = "";
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).HornPlayerSkillPoint == 0) {
			tooltip = "\uC5FC\uC18C\uBFD4 \uC0AC\uC6A9\uC2DC \uC8FC\uBCC0 \uD50C\uB808\uC774\uC5B4 \uC2E0\uC18D\uBC84\uD504";
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).HornPlayerSkillPoint <= 3) {
			tooltip = "\uC2E0\uC18D\uBC84\uD504 1\uC99D\uAC00";
		} else {
			tooltip = "\uBC84\uD504\uC2DC\uAC04 3\uCD08\uC99D\uAC00";
		}
		return tooltip;
	}
}
