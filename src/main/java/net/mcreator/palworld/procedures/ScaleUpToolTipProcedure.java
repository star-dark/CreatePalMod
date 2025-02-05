package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class ScaleUpToolTipProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String tooltip = "";
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).DefenseUpSkillPoint >= 5 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).HealthUpSkillPoint >= 5) {
			tooltip = "\uD06C\uAE30 \uC99D\uAC00, \uCCB4\uB8253\uCE78 \uC99D\uAC00";
		} else {
			tooltip = "\uBC29\uC5B4\uB825, \uCCB4\uB825 5\uD544\uC694";
		}
		return tooltip;
	}
}
