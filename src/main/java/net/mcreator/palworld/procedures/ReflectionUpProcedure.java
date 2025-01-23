package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class ReflectionUpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points > 0 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).ReflectionSkillPointUp < 5 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level >= 15) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points - 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.ReflectionSkillPointUp = entity.getData(PalworldModVariables.PLAYER_VARIABLES).ReflectionSkillPointUp + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
