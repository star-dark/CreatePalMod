package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class AttackUPProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points > 0 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).AttackUpSkillPoint < 10) {
			if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
				_livingEntity1.getAttribute(Attributes.ATTACK_DAMAGE)
						.setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity0.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0) + 1));
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points - 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.AttackUpSkillPoint = entity.getData(PalworldModVariables.PLAYER_VARIABLES).AttackUpSkillPoint + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
