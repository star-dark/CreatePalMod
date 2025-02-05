package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class FallingDamageReduceProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points > 0 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level >= 15
				&& entity.getData(PalworldModVariables.PLAYER_VARIABLES).FallingDamageReduceSkillPoint < 10) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points - 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.FallingDamageReduceSkillPoint = entity.getData(PalworldModVariables.PLAYER_VARIABLES).FallingDamageReduceSkillPoint + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.FALL_DAMAGE_MULTIPLIER))
				_livingEntity1.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).setBaseValue(
						((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.FALL_DAMAGE_MULTIPLIER) ? _livingEntity0.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).getBaseValue() : 0) - 0.1));
		}
	}
}
