package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class OpenSkillTreeGUIProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (IsFisherProcedure.execute(entity)) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("FisherSkillTree");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new FisherSkillTreeMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else if (IsMinerProcedure.execute(entity)) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("MinerSkillTree");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new MinerSkillTreeMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else if (IsFarmerProcedure.execute(entity)) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("FarmerSkillTree");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new FarmerSkillTreeMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uC9C1\uC5C5\uC774 \uC5C6\uC2B5\uB2C8\uB2E4.."), false);
		}
	}
}
