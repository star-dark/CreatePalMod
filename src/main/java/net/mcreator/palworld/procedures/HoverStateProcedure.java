package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModParticleTypes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HoverStateProcedure {
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
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).BlinkVar) {
			if (world.dayTime() <= entity.getData(PalworldModVariables.PLAYER_VARIABLES).timeBuffer + 20) {
				world.addParticle((SimpleParticleType) (PalworldModParticleTypes.HOVER_PARTICLE.get()), x, y, z, 0, 0, 0);
			} else {
				entity.setNoGravity(false);
				entity.setInvisible(false);
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.BlinkVar = false;
					_vars.syncPlayerVariables(entity);
				}
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.timeBuffer = world.dayTime() + 100;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
