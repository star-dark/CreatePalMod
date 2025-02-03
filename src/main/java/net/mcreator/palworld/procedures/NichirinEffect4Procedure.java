package net.mcreator.palworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.palworld.network.PalworldModVariables;

public class NichirinEffect4Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.Nichirin_cool = world.dayTime();
			_vars.syncPlayerVariables(entity);
		}
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_number >= 2) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Nichirin_number = 0;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("1\uD615 : \uC218\uBA74\uBCA0\uAE30"), true);
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_number == 0) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Nichirin_number = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_number + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("2\uD615 : \uBB3C\uBC29\uC544"), true);
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_number == 1) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Nichirin_number = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_number + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("8\uD615 : \uC6A9\uC18C"), true);
		}
	}
}
