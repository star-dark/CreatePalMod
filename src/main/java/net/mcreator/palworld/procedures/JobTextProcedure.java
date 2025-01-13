package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class JobTextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String job = "";
		if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).job_production).equals("Farmer")) {
			job = "\uB18D\uBD80";
		} else if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).job_production).equals("Fisher")) {
			job = "\uC5B4\uBD80";
		} else if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).job_production).equals("Miner")) {
			job = "\uAD11\uBD80";
		} else {
			job = "\uBB34\uC9C1";
		}
		return job;
	}
}
