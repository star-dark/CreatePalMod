package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class RangeUpToolTipProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String tooltip = "";
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).AttackUpSkillPoint >= 5 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).HealthUpSkillPoint >= 5) {
			tooltip = "\uC0AC\uAC70\uB9AC 0.5\uC529 \uC99D\uAC00";
		} else {
			tooltip = "\uACF5\uACA9\uB825, \uCCB4\uB825 5\uD544\uC694";
		}
		return tooltip;
	}
}
