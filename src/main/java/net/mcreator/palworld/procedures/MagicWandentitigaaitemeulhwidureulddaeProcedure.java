package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class MagicWandentitigaaitemeulhwidureulddaeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.Player_EXP = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_EXP + 10000;
			_vars.syncPlayerVariables(entity);
		}
	}
}
