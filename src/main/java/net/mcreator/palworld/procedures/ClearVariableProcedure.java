package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class ClearVariableProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.job_production = "";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.IsSubQuestExist = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.IsMainQuestExist = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.MainQuestContents = "";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.QuestCooltimeBuffer = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.SubQuestContents = "";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.Player_EXP = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.Player_Level = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.Skill_Points = 0;
			_vars.syncPlayerVariables(entity);
		}
	}
}
