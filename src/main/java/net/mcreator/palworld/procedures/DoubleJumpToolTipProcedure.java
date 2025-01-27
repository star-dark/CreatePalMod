package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class DoubleJumpToolTipProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String tooltip = "";
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).HoverSkillPoint == 0) {
			tooltip = "\uC810\uD504 \uC2DC \uD55C\uBC88 \uB354 \uC810\uD504\uAC00\uB2A5 (\uD638\uBC84 \uC120\uD0DD \uC2DC \uC120\uD0DD\uBD88\uAC00)";
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).HoverSkillPoint == 1) {
			tooltip = "\uBC30\uC6B8 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4";
		}
		return tooltip;
	}
}
