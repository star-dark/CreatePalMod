package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class FoodFighterUpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points > 0 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).FoodFighterSkillPoint < 5 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level >= 15) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points - 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.FoodFighterSkillPoint = entity.getData(PalworldModVariables.PLAYER_VARIABLES).FoodFighterSkillPoint + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.MAX_ABSORPTION))
				_livingEntity0.getAttribute(Attributes.MAX_ABSORPTION).setBaseValue((entity.getData(PalworldModVariables.PLAYER_VARIABLES).FoodFighterSkillPoint * 2));
		}
	}
}
