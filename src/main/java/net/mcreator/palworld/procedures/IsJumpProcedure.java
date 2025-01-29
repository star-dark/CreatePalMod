package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class IsJumpProcedure {
	@SubscribeEvent
	public static void onEntityFall(LivingFallEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static double execute(LevelAccessor world, Entity entity) {
		return execute(null, world, entity);
	}

	private static double execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return 0;
		double landMoment = 0;
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.JumpVar = true;
			_vars.syncPlayerVariables(entity);
		}
		landMoment = world.dayTime();
		return landMoment;
	}
}
