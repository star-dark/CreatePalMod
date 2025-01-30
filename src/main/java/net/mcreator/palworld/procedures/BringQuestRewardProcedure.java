package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class BringQuestRewardProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format(entity.getData(PalworldModVariables.PLAYER_VARIABLES).RewardMoneyBuffer) + "\uC6D0";
	}
}
