package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class PlayerLevelProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##LV").format(entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level);
	}
}
