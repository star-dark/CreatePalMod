package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class AvalonOfMerlinEffect4Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Avalon_number = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number + 1;
				_vars.syncPlayerVariables(entity);
			}
			AvalonOfMerlinEffect1Procedure.execute(world, entity);
			AvalonOfMerlinEffect2Procedure.execute(world, entity);
		}
	}
}
