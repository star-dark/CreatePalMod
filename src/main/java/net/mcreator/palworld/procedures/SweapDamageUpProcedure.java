package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class SweapDamageUpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points > 0 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).ToughnessSkillPoint < 5) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SweapDamageSkillPoint = entity.getData(PalworldModVariables.PLAYER_VARIABLES).SweapDamageSkillPoint + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.SWEEPING_DAMAGE_RATIO))
				_livingEntity0.getAttribute(Attributes.SWEEPING_DAMAGE_RATIO)
						.setBaseValue((entity.getData(PalworldModVariables.PLAYER_VARIABLES).SweapDamageSkillPoint / (entity.getData(PalworldModVariables.PLAYER_VARIABLES).SweapDamageSkillPoint + 1)));
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
