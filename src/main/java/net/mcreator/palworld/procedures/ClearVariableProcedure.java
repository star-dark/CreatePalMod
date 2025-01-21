package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class ClearVariableProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.job_production = "";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.IsSubQuestExist = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.IsMainQuestExist = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.MainQuestContents = "";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.QuestCooltimeBuffer = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.SubQuestContents = "";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.Player_EXP = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.Player_Level = 1;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.Skill_Points = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
			_livingEntity0.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(2);
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.AttackUpSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
			_livingEntity1.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.HealthUpSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.ARMOR))
			_livingEntity2.getAttribute(Attributes.ARMOR).setBaseValue(0);
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.DefenseUpSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE))
			_livingEntity3.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).setBaseValue(4.5);
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.RangeUpSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.RecoverSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();
	}
}
