package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.init.PalworldModItems;

import javax.annotation.Nullable;

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
				_player.getCooldowns().addCooldown(PalworldModItems.HEAVEN.get(), 0);
		}
	}
}
