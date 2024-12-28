package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class JobNpcClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if ((sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).job_production).equals("")) {
			if (sourceentity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("JobNpcGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new JobNpcGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else if ((sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).job_production).equals(sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).talk_with)) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uC774\uBBF8 \uB3D9\uC77C\uD55C \uC9C1\uC5C5\uC744 \uAC00\uC9C0\uACE0 \uC788\uC2B5\uB2C8\uB2E4"), false);
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.talk_with = "";
				_vars.syncPlayerVariables(sourceentity);
			}
		} else {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uC774\uBBF8 \uB2E4\uB978 \uC9C1\uC5C5\uC744 \uAC00\uC9C0\uACE0 \uC788\uC2B5\uB2C8\uB2E4"), false);
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.talk_with = "";
				_vars.syncPlayerVariables(sourceentity);
			}
		}
	}
}
