package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.palworld.network.PalworldModVariables;

public class RecoverUpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points > 0 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).RecoverSkillPoint < 4 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level >= 10
				&& entity.getData(PalworldModVariables.PLAYER_VARIABLES).DefenseUpSkillPoint >= 5 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).HealthUpSkillPoint >= 5) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points - 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.RecoverSkillPoint = entity.getData(PalworldModVariables.PLAYER_VARIABLES).RecoverSkillPoint + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, (int) Double.POSITIVE_INFINITY, (int) Math.floor(entity.getData(PalworldModVariables.PLAYER_VARIABLES).RecoverSkillPoint / 2 - 1)));
		}
	}
}
