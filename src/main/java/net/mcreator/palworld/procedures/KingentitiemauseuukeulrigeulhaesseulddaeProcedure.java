package net.mcreator.palworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.palworld.world.inventory.QuestProvideGUIMenu;
import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.entity.KingEntity;

import io.netty.buffer.Unpooled;

public class KingentitiemauseuukeulrigeulhaesseulddaeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			_ent.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("QuestProvideGUI");
				}

				@Override
				public boolean shouldTriggerClientSideContainerClosingOnOpen() {
					return false;
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new QuestProvideGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
		if (!sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).IsMainQuestExist) {
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.MainQuestGoal = entity instanceof KingEntity _datEntI ? _datEntI.getEntityData().get(KingEntity.DATA_Quest_goal1) : 0;
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.RewardMoneyBuffer = entity instanceof KingEntity _datEntI ? _datEntI.getEntityData().get(KingEntity.DATA_Quest_reward1) : 0;
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.quest_buffer = entity instanceof KingEntity _datEntS ? _datEntS.getEntityData().get(KingEntity.DATA_Quest1) : "";
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.MainQuestRequest = true;
				_vars.syncPlayerVariables(sourceentity);
			}
		} else {
			if (sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestGoal == sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).MainQuestProgress) {
				{
					PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.MainRewardRequest = true;
					_vars.syncPlayerVariables(sourceentity);
				}
			}
		}
	}
}
