package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class RejectButtonPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestRequest) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.MainQuestRequest = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.MainQuestGoal = 0;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestRequest) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestRequest = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestGoal = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
