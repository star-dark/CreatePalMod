package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.palworld.network.PalworldModVariables;

public class PigentitigajugeosseulddaeProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\uAFB8\uC6E8\uC5D1"), false);
		if ((sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestContents).equals("\uB3FC\uC9C0\uB97C 3\uB9C8\uB9AC \uC7A1\uC544\uC624\uC2DC\uC624")) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(MainProgressProcedure.execute(entity)), false);
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.MainQuestProgress = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestProgress + 1;
				_vars.syncPlayerVariables(sourceentity);
			}
			if (sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestGoal == sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestProgress) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uD018\uC2A4\uD2B8 \uC644\uB8CC!"), false);
			}
		}
	}
}
