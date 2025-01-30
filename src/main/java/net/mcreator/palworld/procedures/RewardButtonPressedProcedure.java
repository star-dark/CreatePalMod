package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.palworld.network.PalworldModVariables;

public class RewardButtonPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\uBCF4\uC0C1\uC744 \uD68D\uB4DD\uD558\uC600\uC2B5\uB2C8\uB2E4"), false);
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).MainRewardRequest) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.MainRewardRequest = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.IsMainQuestExist = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.MainQuestGoal = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.MainQuestProgress = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.my_money = entity.getData(PalworldModVariables.PLAYER_VARIABLES).my_money + entity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestRewardMoney;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.MainQuestContents = "";
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubRewardRequest) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubRewardRequest = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.IsSubQuestExist = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestGoal = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestProgress = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.my_money = entity.getData(PalworldModVariables.PLAYER_VARIABLES).my_money + entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestRewardMoney;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestContents = "";
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
