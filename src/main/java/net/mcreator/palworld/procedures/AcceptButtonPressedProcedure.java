package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.palworld.network.PalworldModVariables;

public class AcceptButtonPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestRequest) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uD018\uC2A4\uD2B8\uB97C \uC218\uB77D\uD588\uC2B5\uB2C8\uB2E4"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(entity.getData(PalworldModVariables.PLAYER_VARIABLES).quest_buffer), false);
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.MainQuestContents = entity.getData(PalworldModVariables.PLAYER_VARIABLES).quest_buffer;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.IsMainQuestExist = true;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.MainQuestProgress = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.MainQuestRewardMoney = entity.getData(PalworldModVariables.PLAYER_VARIABLES).RewardMoneyBuffer;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.MainQuestRequest = false;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestRequest) {
			if (!entity.getData(PalworldModVariables.PLAYER_VARIABLES).IsSubQuestExist) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uD018\uC2A4\uD2B8\uB97C \uC218\uB77D\uD588\uC2B5\uB2C8\uB2E4"), false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(entity.getData(PalworldModVariables.PLAYER_VARIABLES).quest_buffer), false);
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.SubQuestContents = entity.getData(PalworldModVariables.PLAYER_VARIABLES).quest_buffer;
					_vars.syncPlayerVariables(entity);
				}
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.IsSubQuestExist = true;
					_vars.syncPlayerVariables(entity);
				}
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.SubQuestProgress = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.SubQuestRewardMoney = entity.getData(PalworldModVariables.PLAYER_VARIABLES).RewardMoneyBuffer;
					_vars.syncPlayerVariables(entity);
				}
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.QuestCooltimeBuffer = 1728000;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uB354\uC774\uC0C1 \uD018\uC2A4\uD2B8\uB97C \uBC1B\uC744 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4"), false);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestRequest = false;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
