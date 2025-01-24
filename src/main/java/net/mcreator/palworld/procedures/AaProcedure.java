package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModParticleTypes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AaProcedure {
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
		double startTime = 0;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).BlinkVar) {
			if (world.dayTime() <= entity.getData(PalworldModVariables.PLAYER_VARIABLES).timeBuffer + 10) {
				world.addParticle((SimpleParticleType) (PalworldModParticleTypes.HOVER_PARTICLE.get()), x, y, z, 0, 0, 0);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("##.##\uCD08").format((entity.getData(PalworldModVariables.PLAYER_VARIABLES).timeBuffer + 10) - world.dayTime()))), true);
			} else {
				entity.setNoGravity(false);
				entity.setInvisible(false);
			}
		}
	}
}
