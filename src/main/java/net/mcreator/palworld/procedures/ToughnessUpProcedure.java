package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class ToughnessUpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points > 0 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).ToughnessSkillPoint < 5) {
			if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS))
				_livingEntity1.getAttribute(Attributes.ARMOR_TOUGHNESS)
						.setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS) ? _livingEntity0.getAttribute(Attributes.ARMOR_TOUGHNESS).getBaseValue() : 0) + 0.5));
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points - 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.ToughnessSkillPoint = entity.getData(PalworldModVariables.PLAYER_VARIABLES).ToughnessSkillPoint + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
