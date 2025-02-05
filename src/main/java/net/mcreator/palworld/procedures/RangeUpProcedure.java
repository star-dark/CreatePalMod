package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class RangeUpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points > 0 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level >= 4 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).RangeUpSkillPoint < 10
				&& entity.getData(PalworldModVariables.PLAYER_VARIABLES).AttackUpSkillPoint >= 5 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).HealthUpSkillPoint >= 5) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points - 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.RangeUpSkillPoint = entity.getData(PalworldModVariables.PLAYER_VARIABLES).RangeUpSkillPoint + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE))
				_livingEntity1.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).setBaseValue(
						((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE) ? _livingEntity0.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getBaseValue() : 0) + 0.5));
			if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE))
				_livingEntity3.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).setBaseValue(
						((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE) ? _livingEntity2.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).getBaseValue() : 0)
								+ 0.5));
		}
	}
}
