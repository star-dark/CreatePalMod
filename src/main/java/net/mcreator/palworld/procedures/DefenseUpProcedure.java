package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class DefenseUpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points > 0 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).DefenseUpSkillPoint < 10) {
			if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.ARMOR))
				_livingEntity1.getAttribute(Attributes.ARMOR)
						.setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.ARMOR) ? _livingEntity0.getAttribute(Attributes.ARMOR).getBaseValue() : 0) + 2));
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points - 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.DefenseUpSkillPoint = entity.getData(PalworldModVariables.PLAYER_VARIABLES).DefenseUpSkillPoint + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
