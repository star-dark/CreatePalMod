package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class DoubleJumpUpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points > 0 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).DoubleJumpSkillPoint < 1 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level >= 20
				&& entity.getData(PalworldModVariables.PLAYER_VARIABLES).HoverSkillPoint == 0) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points - 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.DoubleJumpSkillPoint = entity.getData(PalworldModVariables.PLAYER_VARIABLES).DoubleJumpSkillPoint + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
