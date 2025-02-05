package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class HeavenEffect2Procedure {
	@SubscribeEvent
	public static void onPlayerCriticalHit(CriticalHitEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity sourceentity) {
		execute(null, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (!sourceentity.onGround()) {
			if (sourceentity instanceof Player _player)
				_player.getCooldowns().addCooldown(PalworldModItems.DELETED_MOD_ELEMENT.get(), 0);
		}
	}
}
