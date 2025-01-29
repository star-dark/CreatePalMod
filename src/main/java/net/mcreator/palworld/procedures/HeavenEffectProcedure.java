package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class HeavenEffectProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(0, (10 * entity.getLookAngle().y), 0));
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 3000);
	}
}
