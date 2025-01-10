package net.mcreator.palworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.palworld.world.inventory.SubQuestProvideGUIMenu;
import net.mcreator.palworld.world.inventory.SubQuestCompleteMenu;
import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.entity.QueenEntity;

import io.netty.buffer.Unpooled;

public class QueenentitiemauseuukeulrigeulhaesseulddaeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).IsSubQuestExist && entity instanceof QueenEntity _datEntL0 && _datEntL0.getEntityData().get(QueenEntity.DATA_Quest_Activate)) {
			if (sourceentity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("SubQuestProvideGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new SubQuestProvideGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			SetRandomItemProcedure.execute(sourceentity);
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestGoal = Mth.nextInt(RandomSource.create(), 1, 10);
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestRequest = true;
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestProvider = entity instanceof QueenEntity _datEntS ? _datEntS.getEntityData().get(QueenEntity.DATA_provider_name) : "";
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.quest_buffer = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestItem.getDisplayName().getString() + "\uB97C "
						+ new java.text.DecimalFormat("##").format(sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestGoal) + "\uAC1C \uAD6C\uD574\uC624\uC138\uC694.";
				_vars.syncPlayerVariables(sourceentity);
			}
		} else if (!sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).IsSubQuestExist && !(entity instanceof QueenEntity _datEntL5 && _datEntL5.getEntityData().get(QueenEntity.DATA_Quest_Activate))) {
			if (sourceentity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("SubQuestProvideGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new SubQuestProvideGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.QuestCooltimeBuffer = entity instanceof QueenEntity _datEntI ? _datEntI.getEntityData().get(QueenEntity.DATA_cooltime) : 0;
				_vars.syncPlayerVariables(sourceentity);
			}
		} else if (sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).IsSubQuestExist
				&& (sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestProvider).equals(entity instanceof QueenEntity _datEntS ? _datEntS.getEntityData().get(QueenEntity.DATA_provider_name) : "")) {
			if (sourceentity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("SubQuestComplete");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new SubQuestCompleteMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else if (sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).IsSubQuestExist
				&& !((sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestProvider).equals(entity instanceof QueenEntity _datEntS ? _datEntS.getEntityData().get(QueenEntity.DATA_provider_name) : ""))) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uC774\uBBF8 \uD018\uC2A4\uD2B8\uAC00 \uC788\uC2B5\uB2C8\uB2E4."), false);
		}
	}
}
