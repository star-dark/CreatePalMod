package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class RecoverUpToolTipProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String tooltip = "";
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).DefenseUpSkillPoint >= 5 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).HealthUpSkillPoint >= 5) {
			tooltip = "2\uD3EC\uC778\uD2B8 \uB2F9 \uC7AC\uC0DD 1\uC529 \uC99D\uAC00";
		} else {
			tooltip = "\uBC29\uC5B4\uB825, \uCCB4\uB825 5\uD544\uC694";
		}
		return tooltip;
	}
}
