package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class JobNpcGuiTextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String returnValue = "";
		if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).talk_with).equals("Farmer")) {
			returnValue = "\uB18D\uC0AC \uD558\uAE30 \uB531 \uC88B\uC740 \uB0A0\uC528\uAD6C\uBA3C";
		} else if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).talk_with).equals("Fisher")) {
			returnValue = "\uB098\uB791 \uB09A\uC2DC \uD560\uB798?";
		} else if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).talk_with).equals("Miner")) {
			returnValue = "\uD750\uD750\uD750.. \uB3D9\uC9C0\uC778\uAC00..?";
		}
		return returnValue;
	}
}
