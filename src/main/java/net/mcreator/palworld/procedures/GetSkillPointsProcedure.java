package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class GetSkillPointsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points + 1;
			_vars.syncPlayerVariables(entity);
		}
	}
}
