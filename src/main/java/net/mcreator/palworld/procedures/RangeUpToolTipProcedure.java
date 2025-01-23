package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class RangeUpToolTipProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String tooltip = "";
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).AttackUpSkillPoint >= 5 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).HealthUpSkillPoint >= 5) {
			tooltip = "2\uD3EC\uC778\uD2B8 \uB2F9 \uC0AC\uAC70\uB9AC 1\uC529 \uC99D\uAC00";
		} else {
			tooltip = "\uACF5\uACA9\uB825, \uCCB4\uB825 5\uD544\uC694";
		}
		return tooltip;
	}
}
