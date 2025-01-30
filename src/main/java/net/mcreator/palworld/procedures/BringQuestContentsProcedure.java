package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class BringQuestContentsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(PalworldModVariables.PLAYER_VARIABLES).quest_buffer;
	}
}
