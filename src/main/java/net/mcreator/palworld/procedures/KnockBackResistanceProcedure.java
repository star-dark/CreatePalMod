package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class KnockBackResistanceProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points > 0 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).ToughnessSkillPoint < 5) {
			if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
				_livingEntity1.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(
						((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE) ? _livingEntity0.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue() : 0) + 0.1));
			if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE))
				_livingEntity3.getAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE)
						.setBaseValue(((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE)
								? _livingEntity2.getAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE).getBaseValue()
								: 0) + 0.1));
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points - 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.KnockbackResistanceSkillPoint = entity.getData(PalworldModVariables.PLAYER_VARIABLES).KnockbackResistanceSkillPoint + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
