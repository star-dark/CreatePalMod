package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class FdsfsdfsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (true == true) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Message"), false);
		}
	}
}
