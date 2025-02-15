package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class NichirinEffect6Procedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.dayTime() == entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_tick) {
			NichirinEffect3Procedure.execute(world, x, y, z, entity);
		} else if (world.dayTime() == entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_tick + 14) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Nichirin_cool = world.dayTime() + 60;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PalworldModMobEffects.WATER_POTION_EFFECT, 60, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 3, 3, false, false));
		}
	}
}
