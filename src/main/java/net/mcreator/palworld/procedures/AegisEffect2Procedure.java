package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class AegisEffect2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_bool == true && entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_tick > 0) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.aegis_bool = false;
				_vars.syncPlayerVariables(entity);
			}
			if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_tick < 200) {
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.aegis_tick = entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_tick + 100;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.aegis_tick = 300;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Aegis OFF"), true);
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_bool == false && entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_tick > 0) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.aegis_bool = true;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Aegis ON"), true);
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_bool == true && entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_tick <= 0) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Aegis Cool"), true);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Aegis Cool"), true);
		}
	}
}
