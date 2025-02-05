package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class AmanomurakumonotsurugiEffect2Procedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z ) {
if (world.dayTime()<=) {world.addParticle((SimpleParticleType) (PalworldModParticleTypes.THUNDER_PARTICLE.get()), x, (y+1), z, 0, 0, 0);}
}
}
