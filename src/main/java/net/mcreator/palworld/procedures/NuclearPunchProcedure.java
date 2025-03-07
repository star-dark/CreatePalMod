package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.palworld.network.PalworldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class NuclearPunchProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		execute(null, world, entity, immediatesourceentity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player && !(sourceentity == immediatesourceentity) && sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).NuclearPunchSkillPoint > 0) {
			if (amount >= 7 && sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).ChargeTime < 3) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, (int) Math.round(sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).NuclearPunchSkillPoint / 2 - 1)));
				{
					PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.ChargeTime = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).ChargeTime + 1;
					_vars.syncPlayerVariables(sourceentity);
				}
			}
		} else if (sourceentity instanceof Player && sourceentity == immediatesourceentity && sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).ChargeTime > 0
				&& sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).NuclearPunchSkillPoint > 0) {
			entity.setDeltaMovement(new Vec3((sourceentity.getLookAngle().x * 2), (sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).NuclearPunchSkillPoint / 2), (sourceentity.getLookAngle().z * 2)));
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), (float) amount);
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.ChargeTime = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).ChargeTime - 1;
				_vars.syncPlayerVariables(sourceentity);
			}
		}
	}
}
