package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class CooltimeContentsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double hour = 0;
		double minute = 0;
		double second = 0;
		hour = Math.floor(entity.getData(PalworldModVariables.PLAYER_VARIABLES).QuestCooltimeBuffer / 72000);
		minute = Math.floor((entity.getData(PalworldModVariables.PLAYER_VARIABLES).QuestCooltimeBuffer % 72000) / 1200);
		second = Math.floor((entity.getData(PalworldModVariables.PLAYER_VARIABLES).QuestCooltimeBuffer % 1200) / 20);
		return new java.text.DecimalFormat("##").format(hour) + "h / " + new java.text.DecimalFormat("##").format(minute) + "m / " + new java.text.DecimalFormat("##").format(second) + "s";
	}
}
