package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.common.NeoForgeMod;

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
		if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.MAX_ABSORPTION))
			_livingEntity2.getAttribute(Attributes.MAX_ABSORPTION).setBaseValue(0);
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.HealthUpSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.ARMOR))
			_livingEntity3.getAttribute(Attributes.ARMOR).setBaseValue(0);
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.DefenseUpSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE))
			_livingEntity4.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).setBaseValue(3);
		if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE))
			_livingEntity5.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).setBaseValue(4.5);
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
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.FoodFighterSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.HornPlayerSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.ReflectionSkillPointUp = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.DoubleJumpSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.HoverSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.shieldBoomberSkillpoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.timeBuffer = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.SpeedUpSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
			_livingEntity6.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1);
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.ScaleUpSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.SCALE))
			_livingEntity7.getAttribute(Attributes.SCALE).setBaseValue(1);
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.ToughnessSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS))
			_livingEntity8.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(0);
		if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE))
			_livingEntity9.getAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE).setBaseValue(0);
		if (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
			_livingEntity10.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(0);
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.KnockbackResistanceSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.SweapDamageSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.SWEEPING_DAMAGE_RATIO))
			_livingEntity11.getAttribute(Attributes.SWEEPING_DAMAGE_RATIO).setBaseValue(0);
		if (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.STEP_HEIGHT))
			_livingEntity12.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(0.6);
		if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.SNEAKING_SPEED))
			_livingEntity13.getAttribute(Attributes.SNEAKING_SPEED).setBaseValue(0.3);
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.StepHeightSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.SneakingSpeedSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.BreakingSpeedSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.BLOCK_BREAK_SPEED))
			_livingEntity14.getAttribute(Attributes.BLOCK_BREAK_SPEED).setBaseValue(0.3);
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.FallingDamageReduceSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.FALL_DAMAGE_MULTIPLIER))
			_livingEntity15.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).setBaseValue(1);
		if (entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(NeoForgeMod.SWIM_SPEED))
			_livingEntity16.getAttribute(NeoForgeMod.SWIM_SPEED).setBaseValue(1);
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.ThrowKusanagiActivate = true;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.KamuiActivate = false;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.IgnitoSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.transformSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.FireResistanceSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.PhoenixSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(NeoForgeMod.SWIM_SPEED))
			_livingEntity18.getAttribute(NeoForgeMod.SWIM_SPEED).setBaseValue(1);
		if (entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(Attributes.WATER_MOVEMENT_EFFICIENCY))
			_livingEntity19.getAttribute(Attributes.WATER_MOVEMENT_EFFICIENCY).setBaseValue(0);
		if (entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.SUBMERGED_MINING_SPEED))
			_livingEntity20.getAttribute(Attributes.SUBMERGED_MINING_SPEED).setBaseValue(0.2);
		if (entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.OXYGEN_BONUS))
			_livingEntity21.getAttribute(Attributes.OXYGEN_BONUS).setBaseValue(1);
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.FishmanSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.InvisibleSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.ArcherySkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.SpeedSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.JumpSkillPoint = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
			_livingEntity22.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.41999998688697815);
		if (entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(Attributes.GRAVITY))
			_livingEntity23.getAttribute(Attributes.GRAVITY).setBaseValue(0.08);
	}
}
