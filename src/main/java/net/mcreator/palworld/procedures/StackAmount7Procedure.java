package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class StackAmount7Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return Math.floor(entity.getData(PalworldModVariables.PLAYER_VARIABLES).PheonixStack / 10) == 7;
	}
}
