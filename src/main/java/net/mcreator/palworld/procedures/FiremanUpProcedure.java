package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class FiremanUpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points > 0 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level >= 25 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).FireResistanceSkillPoint < 4) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points - 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.FireResistanceSkillPoint = entity.getData(PalworldModVariables.PLAYER_VARIABLES).FireResistanceSkillPoint + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
