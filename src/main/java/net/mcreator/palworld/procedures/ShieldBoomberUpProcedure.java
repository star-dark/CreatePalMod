package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class ShieldBoomberUpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points > 0 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).shieldBoomberSkillpoint < 5 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level >= 25) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points - 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.shieldBoomberSkillpoint = entity.getData(PalworldModVariables.PLAYER_VARIABLES).shieldBoomberSkillpoint + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
